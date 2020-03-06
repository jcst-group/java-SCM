package com.nongxin.terminal.controller.backstage.system;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.service.system.RoleService;
import com.nongxin.terminal.service.system.UserService;
import com.nongxin.terminal.util.CommonUtil;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.Md5Util;
import com.nongxin.terminal.util.RedisUtil;
import com.nongxin.terminal.util.enumUtil.system.RoleTypeEnum;
import com.nongxin.terminal.util.enumUtil.system.UserStatusEnum;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.SysLoginModel;
import com.nongxin.terminal.vo.constant.CommonConstant;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RedisUtil redisUtil;


    @PostMapping("/login")
    @ApiOperation("登录接口")
    public Result<JSONObject> login(@RequestBody SysLoginModel sysLoginModel, HttpServletRequest request){
        Result<JSONObject> result = new Result<>();
        //LOGGER.info("login :"+sysLoginModel.toString());
        String username = sysLoginModel.getUsername();
        String password = sysLoginModel.getPassword();
        User user = userService.getUserByUserName(username,null);
        if(user==null) {
            result.error500("用户名或密码错误");
        }else if (user.getStatus()==UserStatusEnum.PROHIBIT){
            result.error500("该账号已被禁用！！");
            return result;
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
            //生成token
            String token = JwtUtil.sign(user.getUsername(), password);
            redisUtil.set(CommonConstant.PREFIX_USER_TOKEN + token, token);
            //设置超时时间
            redisUtil.expire(CommonConstant.PREFIX_USER_TOKEN + token, JwtUtil.EXPIRE_TIME/1000);
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
    public Result<String> LogOut(String token){
        Result<String> result = new Result<>();
        LOGGER.info(token);
        redisUtil.del(CommonConstant.PREFIX_USER_TOKEN+token);
        result.setSuccess(true);
        result.setMessage("删除成功");
        return result;
    }

    @GetMapping("/checkUser")
    @ApiOperation("检验账号或手机号是否存在")
    public Result checkUserName(String username,String phone){
        Result result = new Result();
        if (userService.checkUser(username,phone)!=null){
            if (username!=null){
                result.setMessage("用户名已存在！！");
            }else if (phone != null){
                result.setMessage("手机号已存在！！");
            }
            result.setSuccess(false);
        }else {
            result.setSuccess(true);
        }
        return result;
    }

    @PostMapping("/add")
    @ApiOperation("增加用户")
    public Result addUser(@Validated @RequestBody User user){
        Result result = new Result();
        String password = user.getPassword();
        String salt = CommonUtil.getRandomString(6);
        String md5Password = Md5Util.md5(password+salt);
        user.setSalt(salt);
        user.setPassword(md5Password);
        user.setStatus(UserStatusEnum.ENABLED);
        boolean isSuccess = userService.add(user);
        if (isSuccess){
            result.setMessage("添加用户成功");
        }else{
            result.setMessage("添加用户失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除用户")
    public Result deleteUser(@RequestParam(required = true) Integer id){
        Result result = new Result();
        boolean isSuccess = userService.delete(id);
        if (isSuccess){
            result.setMessage("删除用户成功");
        }else{
            result.setMessage("删除用户失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改用户信息")
    public Result updateUser(@RequestBody User user){
        Result result = new Result();
        if(!StringUtils.isEmpty(user.getPassword())){
            String salt = CommonUtil.getRandomString(6);
            String md5Password = Md5Util.md5(user.getPassword()+salt);
            user.setSalt(salt);
            user.setPassword(md5Password);
        }
        boolean isSuccess = userService.update(user);
        if (isSuccess){
            result.setMessage("修改用户信息成功");
        }else{
            result.setMessage("修改用户信息失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询用户")
    public Result<PageInfo> getUserList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                             @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                            User user){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<User> roleList = userService.getUserList(user);
        PageInfo pageInfo = new PageInfo(roleList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/all")
    @ApiOperation("获取所有用户，用于下拉列表选择")
    public Result getAllUser(){
        Result result = new Result();
        result.setSuccessResult(userService.getAllUser());
        return result;
    }

    @PostMapping("/addRoleToUser")
    @ApiOperation("给用户分配角色")
    public Result addRoleToUser(@RequestBody User user){
        Result result = new Result();
        boolean isSuccess = userService.addRoleToUser(user);
        if (isSuccess){
            result.setMessage("分配角色成功");
        }else{
            result.setMessage("分配角色失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/updateStatus")
    @ApiOperation("修改用户状态")
    public Result updateStatus(@RequestParam(required = true) Integer id){
        Result result = new Result();
        boolean isSuccess = userService.updateUserStatus(id);
        if (isSuccess){
            result.setMessage("修改用户状态成功");
        }else{
            result.setMessage("修改用户状态失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/getUserAndRole")
    @ApiOperation("获取所有用户和用户角色")
    public Result<PageInfo> getUserAndRole(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                           @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                           String realName){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<User> userList = userService.getUserAndRole(realName);
        PageInfo pageInfo = new PageInfo(userList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getFarmer")
    @ApiOperation("获取所有农户")
    public Result getFarmer(String realName){
        Result result = new Result();
        result.setSuccessResult(userService.getFarmer(RoleTypeEnum.FARMER,realName));
        return result;
    }

}
