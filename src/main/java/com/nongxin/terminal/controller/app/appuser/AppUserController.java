package com.nongxin.terminal.controller.app.appuser;

import com.alibaba.fastjson.JSONObject;
import com.nongxin.terminal.dao.envmonitor.EquipmentMapper;
import com.nongxin.terminal.entity.system.AppResource;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.service.system.AppResourceService;
import com.nongxin.terminal.service.system.RoleService;
import com.nongxin.terminal.service.system.UserService;
import com.nongxin.terminal.util.*;
import com.nongxin.terminal.util.enumUtil.system.ResourceTypeEnum;
import com.nongxin.terminal.util.enumUtil.system.RoleTypeEnum;
import com.nongxin.terminal.vo.MenuTreeNode;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.SysLoginModel;
import com.nongxin.terminal.vo.constant.CommonConstant;
import com.nongxin.terminal.vo.constant.DefContants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/app/user")
public class AppUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private AppResourceService appResourceService;
    @Autowired
    private EquipmentMapper equipmentMapper;

    @PostMapping("/login")
    @ApiOperation("登录接口")
    public Result<JSONObject> login(@RequestBody SysLoginModel sysLoginModel, HttpServletRequest request){
        Result<JSONObject> result = new Result<>();
        //LOGGER.info("login :"+sysLoginModel.toString());
        String username = sysLoginModel.getUsername();
        String password = sysLoginModel.getPassword();
        User user = userService.getUserByUserName(username,1);
        if(user==null) {
            result.error500("用户名或密码错误");
        }else{
            //加密密码时的办法
            String checkStr = password+user.getSalt();
            String inputPassword = Md5Util.md5(checkStr);
            String userPassword = user.getPassword();
            if(!userPassword.equals(inputPassword)) {
                result.error500("用户名或密码错误");
                return result;
            }
            List<Role> roleList = roleService.getRoleByUid(user.getUid());
            if (roleList==null || roleList.isEmpty()){
                result.error500("该用户暂未分配角色，无法登录");
                return result;
            }
            boolean isAdmin = false;
            for(Role r:roleList){
                if(RoleTypeEnum.ADMIN==r.getType()){
                    isAdmin = true;
                    break;
                }
            }
            if (!isAdmin){
                List<AppResource> appResourceList = appResourceService.getAppResourceByUid(user.getUid(),ResourceTypeEnum.BACK_RECOURCE);
                if (appResourceList == null || appResourceList.isEmpty()){
                    result.error500("该用户暂无权限，无法登录");
                    return result;
                }
            }
            //生成token
            String token = JwtUtil.sign(user.getUsername(), password);
            redisUtil.set(CommonConstant.PREFIX_APP_TOKEN + token, token);
            JSONObject obj = new JSONObject();
            obj.put("token", token);
            obj.put("userInfo", user);
            result.setResult(obj);
            result.success("登录成功");
        }
        return result;
    }

    @GetMapping("/logout")
    @ApiOperation("退出登录")
    public Result<String> LogOut(HttpServletRequest request){
        Result<String> result = new Result<>();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        redisUtil.del(CommonConstant.PREFIX_APP_TOKEN+token);
        result.setSuccess(true);
        result.setMessage("已退出");
        return result;
    }

    @GetMapping("/getUserInfo")
    @ApiOperation("获取用户信息")
    public Result<User> getUserInfo(HttpServletRequest request){
        Result result = new Result();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        if (token == null){
            result.error500("token不能为空！！");
            return result;
        }
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserAndRoleByUserName(username);
        result.setSuccessResult(user);
        return result;
    }

    @GetMapping("/updatePassword")
    @ApiOperation("修改密码")
    public Result updatePassword(String newPassword,String oldPassword,HttpServletRequest request){
        Result result = new Result();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserByUserName(username,null);
        if (!Md5Util.md5(oldPassword+user.getSalt()).equals(user.getPassword())){
            result.setMessage("原密码错误！！");
            result.setSuccess(false);
            return result;
        }
        String salt = CommonUtil.getRandomString(6);
        String md5Password = Md5Util.md5(newPassword+salt);
        User user1 = new User();
        user1.setSalt(salt);
        user1.setPassword(md5Password);
        user1.setUid(user.getUid());
        boolean isSuccess = userService.update(user1);
        if (isSuccess){
            result.setMessage("修改密码成功！！");
        }else {
            result.setMessage("修改密码失败！！");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @ApiOperation(value = "获取用户app菜单", httpMethod = "GET",notes = "根据用户查询该用户的角色对应的app菜单")
    @GetMapping("/getUserMenu")
    public Result<List<MenuTreeNode>> getUserMenuByUserId(HttpServletRequest request){
        Result<List<MenuTreeNode>> result = new Result<>();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        if (token == null){
            result.error500("token不能为空！！");
            return result;
        }
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserByUserName(username,1);
        List<MenuTreeNode> treeNodes = new ArrayList<>();
        Integer uid = null;
        if (user != null){
            uid = user.getUid();
        }
        List<Role> roleList = roleService.getRoleByUid(uid);
        boolean isAdmin = false;
        for(Role r:roleList){
            if(RoleTypeEnum.ADMIN==r.getType()){
                isAdmin = true;
                break;
            }
        }
        List<AppResource> resourcesList = null;
        if (isAdmin){
            resourcesList= appResourceService.getAppResourceList(ResourceTypeEnum.BACK_RECOURCE);
        }else {
            resourcesList = appResourceService.getAppResourceByUid(uid,ResourceTypeEnum.BACK_RECOURCE);
        }
        boolean flag = equipmentMapper.getBaseEquipmentByUid(uid)>0;
        for (AppResource resource: resourcesList) {
            if (flag || (!resource.getName().equals("环控任务") && !resource.getName().equals("预警任务"))){
                MenuTreeNode node = new MenuTreeNode();
                BeanUtils.copyProperties(resource,node);
                treeNodes.add(node);
            }
        }
        List<MenuTreeNode> menuTreeNodes = TreeUtil.buildTreeBy2Loop(treeNodes,-1);

        result.setSuccessResult(menuTreeNodes);
        return result;
    }

}
