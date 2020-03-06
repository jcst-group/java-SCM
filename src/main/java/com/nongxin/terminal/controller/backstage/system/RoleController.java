package com.nongxin.terminal.controller.backstage.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.service.system.RoleService;
import com.nongxin.terminal.util.enumUtil.system.RoleStatusEnum;
import com.nongxin.terminal.util.enumUtil.system.RoleTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add")
    @ApiOperation("增加角色")
    public Result addAppResource(@Validated @RequestBody Role role){
        Result result = new Result();
        role.setStatus(RoleStatusEnum.ENABLED);
        if (role.getType()==RoleTypeEnum.ADMIN){
            result.setMessage("无法添加管理员角色，请重新选择角色类型！！");
            result.setSuccess(false);
            return result;
        }
        boolean isSuccess = roleService.add(role);
        if (isSuccess){
            result.setMessage("添加角色成功");
        }else{
            result.setMessage("添加角色失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除角色")
    public Result deleteAppResource(@RequestParam(required = true) Integer id){
        Result result = new Result();
        boolean isSuccess = roleService.delete(id);
        if (isSuccess){
            result.setMessage("删除角色成功");
        }else{
            result.setMessage("删除角色失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改角色")
    public Result updateAppResource(@RequestBody Role role){
        Result result = new Result();
        role.setStatus(RoleStatusEnum.ENABLED);
        boolean isSuccess = roleService.update(role);
        if (isSuccess){
            result.setMessage("修改角色成功");
        }else{
            result.setMessage("修改角色失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询角色")
    public Result<PageInfo> getRoleList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                             @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                             Role role){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<Role> roleList = roleService.getRoleList(role);
        PageInfo pageInfo = new PageInfo(roleList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/all")
    @ApiOperation("查询所有角色")
    public Result getAllRole(){
        Result result = new Result();
        result.setSuccessResult(roleService.getAllRoleList());
        return result;
    }

    @PostMapping("/addResourceToRole")
    @ApiOperation("为角色分配权限")
    public Result addResourceToRole(@RequestBody Role role){
        Result result = new Result();
        boolean isSuccess = roleService.addResourceToRole(role);
        if (isSuccess){
            result.setMessage("分配权限成功");
        }else{
            result.setMessage("分配权限失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }



}
