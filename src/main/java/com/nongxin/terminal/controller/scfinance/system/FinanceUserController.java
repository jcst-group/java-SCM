package com.nongxin.terminal.controller.scfinance.system;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.dao.scfinance.detection.FinanceUserMapper;
import com.nongxin.terminal.dao.scfinance.system.FianceuserUserBaseRelMapper;
import com.nongxin.terminal.dao.scfinance.system.FinanceRoleResourceMapper;
import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.entity.scfinance.insurance.FianceuserUserBaseRel;
import com.nongxin.terminal.entity.scfinance.system.FinanceResource;
import com.nongxin.terminal.entity.scfinance.system.FinanceUser;
import com.nongxin.terminal.service.base.BaseInfoService;
import com.nongxin.terminal.service.scfinance.BatchPlanAreaCalService;
import com.nongxin.terminal.service.scfinance.detection.IFinanceUserService;
import com.nongxin.terminal.service.scfinance.system.IFinanceRoleService;
import com.nongxin.terminal.service.scfinance.system.impl.FianceuserUserBaseRelServiceImpl;
import com.nongxin.terminal.util.*;
import com.nongxin.terminal.util.enumUtil.system.ResourceTypeEnum;
import com.nongxin.terminal.util.enumUtil.system.UserStatusEnum;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author clover
 * @since 2019-12-10
 */
@RestController
public class FinanceUserController {

    //private static final Logger LOGGER = LoggerFactory.getLogger(FinanceUserController.class);

    @Autowired
    private IFinanceUserService userService;
    @Autowired
    private FinanceUserMapper financeUserMapper;
    @Autowired
    private IFinanceRoleService roleService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private FinanceRoleResourceMapper roleResourceMapper;

    @Autowired
    private BaseInfoService baseInfoService;

    @Autowired
    private FianceuserUserBaseRelMapper fianceuserUserBaseRelMapper;

    @Autowired
    private FianceuserUserBaseRelServiceImpl baseRelService;

    @Autowired
    private BatchPlanAreaCalService batchPlanAreaCalService;

    @PostMapping("/financeuser/login")
    @ApiOperation("登录接口")
    public Result<JSONObject> login(@RequestBody SysLoginModel sysLoginModel, HttpServletRequest request){
        Result<JSONObject> result = new Result<>();
        //LOGGER.info("login :"+sysLoginModel.toString());
        String username = sysLoginModel.getUsername();
        String password = sysLoginModel.getPassword();
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        FinanceUser user = userService.getOne(queryWrapper);
        if(user==null) {
            result.error500("用户名或密码错误");
        }else if (user.getStatus()== UserStatusEnum.PROHIBIT){
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
//            List<Role> roleList = roleService.getRoleByUid(user.getUid());
//            if (roleList==null || roleList.isEmpty()){
//                result.error500("该用户暂未分配角色，无法登录");
//                return result;
//            }
            //生成token
            String token = JwtUtil.signFinanceUser(user, password);
            redisUtil.set(CommonConstant.PREFIX_FINANCE_TOKEN + token, token);
            //设置超时时间
            redisUtil.expire(CommonConstant.PREFIX_FINANCE_TOKEN + token, JwtUtil.EXPIRE_TIME/1000);
            JSONObject obj = new JSONObject();
            obj.put("token", token);
            obj.put("userInfo", user);
            result.setResult(obj);
            result.success("登录成功");
        }
        return result;
    }

    @GetMapping("/financeuser/logout")
    @ApiOperation("退出登录")
    public Result<String> LogOut(String token){
        Result<String> result = new Result<>();
        redisUtil.del(CommonConstant.PREFIX_FINANCE_TOKEN+token);
        result.setSuccess(true);
        result.setMessage("删除成功");
        return result;
    }

    @ApiOperation(value = "获取用户app菜单", httpMethod = "GET",notes = "根据用户查询该用户的角色对应的app菜单")
    @GetMapping("/financeuser/getUserMenu")
    public Result<List<MenuTreeNode>> getUserMenuByUserId(HttpServletRequest request){
        Result<List<MenuTreeNode>> result = new Result<>();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        if (token == null){
            result.error500("token不能为空！！");
            return result;
        }
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        FinanceUser user = userService.getOne(queryWrapper);
        if (user == null){
            result.error500("用户不存在！！");
            return result;
        }
        List<MenuTreeNode> treeNodes = new ArrayList<>();
        //获取前端菜单
        List<FinanceResource> resourcesList = roleResourceMapper.getFinanceResourceByUid(user.getId(),ResourceTypeEnum.BACK_RECOURCE);

        for (FinanceResource resource: resourcesList) {
            MenuTreeNode node = new MenuTreeNode();
            BeanUtils.copyProperties(resource,node);
            treeNodes.add(node);
        }
        List<MenuTreeNode> menuTreeNodes = TreeUtil.buildTreeBy2Loop(treeNodes,-1);

        result.setSuccessResult(menuTreeNodes);
        return result;
    }

    @GetMapping("/finance/financeUser/list")
    @ApiOperation(value = "分页带条件查询用户")
    public Result queryFinanceUser(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                   @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                   FinanceUser user){
        Result result = new Result<>();
        Page<FinanceUser> page = new Page<>(pageNo, pageSize);
        QueryWrapper<FinanceUser> wrapper = new QueryWrapper<>();
        //IPage<FinanceUser> page1 = userService.page(page, wrapper);
        IPage<FinanceUser> page1 = financeUserMapper.userList(page,wrapper);
        result.setSuccessResult(page1);
        return result;
    }




    @PostMapping("/finance/financeUser/save")
    @ApiOperation(value = "增加金融账户")
    public Result addFinanceUser(@RequestBody FinanceUser user){
        Result result = new Result<>();
        String password = user.getPassword();
        String salt = CommonUtil.getRandomString(6);
        String md5Password = Md5Util.md5(password+salt);
        user.setSalt(salt);
        user.setPassword(md5Password);
        user.setStatus(UserStatusEnum.ENABLED);

        boolean save = userService.save(user);
        if(save){
            result.setSuccessResult("添加金融用户成功");
        }else{
            result.setResult("添加金融用户失败");
        }
        return result;
    }

    @PostMapping("/finance/financeUser/updatePassword")
    @ApiOperation(value = "增加金融账户")
    public Result updatePassword(@RequestBody FinanceUser user){
        Result result = new Result<>();
        String password = user.getPassword();
        String message = "";
        boolean save = false;
        if(password == null){
            message = "密码不能为空";
        }else if(user.getId() == null){
            message = "用户ID不能为空";
        }else{
            FinanceUser updateUser = new FinanceUser();
            String salt = CommonUtil.getRandomString(6);
            String md5Password = Md5Util.md5(password+salt);
            updateUser.setSalt(salt);
            updateUser.setPassword(md5Password);
            updateUser.setStatus(UserStatusEnum.ENABLED);
            updateUser.setId(user.getId());
            save = userService.updateById(updateUser);
        }
        if(save){
            result.setSuccessResult("修改密码成功");
        }else{
            message = message.equals("")?"密码修改失败":message;
            result.setResult(message);
        }
        return result;
    }

    @PostMapping("/finance/financeUser/updateUser")
    @ApiOperation(value = "更新金融账户")
    public Result updateUser(@RequestBody FinanceUser user){
        Result result = new Result<>();
        String message = "";
        boolean save = false;
        if(user.getId() == null){
            message = "用户ID不能为空";
        }else{
            user.setPassword(null);
            save = userService.updateById(user);
        }
        if(save){
            result.setSuccessResult("用户修改成功");
        }else{
            message = message.equals("")?"用户修改失败":message;
            result.setResult(message);
        }
        return result;
    }

    @GetMapping("/finance/financeUser/checkUserName")
    @ApiOperation(value = "删除金融用户")
    public Result checkUserName(String username,String phone){
        Result result = new Result<>();
        String message = "";
        QueryWrapper<FinanceUser> queryWrapper = new QueryWrapper<FinanceUser>();
        if(username!=null){
            queryWrapper.lambda().eq(FinanceUser::getUsername,username);
        }
        if(phone!=null){
            queryWrapper.lambda().eq(FinanceUser::getPhone,phone);
        }

        int count = userService.count(queryWrapper);
        if(count>0){
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

    @GetMapping("/finance/financeUser/deleteUser")
    @ApiOperation(value = "删除金融用户")
    public Result deleteUser(@RequestParam Integer userId){
        Result result = new Result<>();
        String message = "";
        boolean delete = false;
        if(userId == null){
            message = "用户ID不能为空";
        }else{
            delete = userService.removeById(userId);
        }
        if(delete){
            result.setSuccessResult("用户删除成功");
        }else{
            message = message.equals("")?"用户删除失败":message;
            result.setResult(message);
        }
        return result;
    }

    @GetMapping("/finance/base/all")
    @ApiOperation("获取所有基地，用于下拉列表选择")
    public Result getAllBaseInfo(String baseName){
        Result result = new Result();
        result.setSuccessResult(baseInfoService.getAllBaseInfo(null,null,baseName));
        return result;
    }

    @GetMapping("/finance/baseRelateBatch/all")
    @ApiOperation("获取所有基地，用于下拉列表选择")
    public Result getAllBaseRelateBatch(){
        Result result = new Result();
        result.setSuccessResult(fianceuserUserBaseRelMapper.querryBaseRelateBatch(JwtUtil.queryFnanceUserId()));
        return result;
    }

    @GetMapping("/finance/baseRelateBatch/allById")
    @ApiOperation("获取所有基地，用于下拉列表选择")
    public Result getAllBaseRelateBatch(@RequestParam Integer id){
        Result result = new Result();
        result.setSuccessResult(fianceuserUserBaseRelMapper.querryBaseRelateBatch(id));
        return result;
    }

    @GetMapping("/finance/baseRelateBatch/calPrepareItem")
    @ApiOperation("计算该批次和面积的准备项金额")
    public Result calPrepareItem(@RequestParam Integer batchId, @RequestParam BigDecimal area){
        Result result = new Result();
        Map items = new HashMap();
        try {
            items = batchPlanAreaCalService.cal(batchId, area);
        }catch (Exception e){
            e.printStackTrace();
        }
        result.setSuccessResult(items);
        return result;
    }

    @PostMapping("/finance/base/bind")
    @ApiOperation("绑定基地")
    public Result bindBase(@RequestBody FinanceUser user){
        Result result = new Result();
        Integer id = user.getId();
        List<BaseInfo> bases = user.getBases();
        boolean bind = false;
        String message = "";
        if(id==null){
            message = "合作社ID不能为空";
        }else{

            if(bases==null){
                bases = new ArrayList<>();
            }
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("financeuser_id",id);
            boolean remove = baseRelService.remove(queryWrapper);
            for(BaseInfo b:bases){
                Integer baseId = b.getId();

                if(baseId == null){

                }else{
                    FianceuserUserBaseRel baseRel = new FianceuserUserBaseRel();
                    baseRel.setBaseId(baseId);
                    baseRel.setFinanceuserId(id);
                    baseRelService.save(baseRel);
                }
            }
            bind = true;

        }

        if(bind){
            result.setSuccessResult("合作社绑定基地成功");
        }else{
            if(message==""){
                message = "合作社绑定基地失败";
            }
            result.setResult(message);
        }
        return result;
    }
}
