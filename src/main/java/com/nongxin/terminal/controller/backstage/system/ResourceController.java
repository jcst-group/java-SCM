package com.nongxin.terminal.controller.backstage.system;

import com.nongxin.terminal.entity.system.Resource;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.service.system.ResourceService;
import com.nongxin.terminal.service.system.RoleService;
import com.nongxin.terminal.service.system.UserService;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.TreeUtil;
import com.nongxin.terminal.util.enumUtil.system.ResourceTypeEnum;
import com.nongxin.terminal.util.enumUtil.system.RoleTypeEnum;
import com.nongxin.terminal.vo.MenuTreeNode;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.constant.DefContants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ApiOperation("增加后台权限")
    public Result addResource(@Validated @RequestBody Resource resource){
        Result result = new Result();
        boolean isSuccess = resourceService.add(resource);
        if (isSuccess){
            result.setMessage("添加后台权限成功");
        }else{
            result.setMessage("添加后台权限失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除后台权限")
    public Result deleteResource(@RequestParam(required = true) Integer id){
        Result result = new Result();
        boolean isSuccess = resourceService.delete(id);
        if (isSuccess){
            result.setMessage("删除后台权限成功");
        }else{
            result.setMessage("删除后台权限失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改后台权限")
    public Result updateResource(@RequestBody Resource resource){
        Result result = new Result();
        boolean isSuccess = resourceService.update(resource);
        if (isSuccess){
            result.setMessage("修改后台权限成功");
        }else{
            result.setMessage("修改后台权限失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @ApiOperation(value = "获取后台全部菜单列", httpMethod = "GET",notes = "获得的是菜单的树状结构数据，通常用于刷新表单")
    @GetMapping("/list")
    public Result<List<MenuTreeNode>> getMenus(){
        Result<List<MenuTreeNode>> result = new Result<>();
        List<MenuTreeNode> treeNodes = new ArrayList<>();
        List<Resource> resources = resourceService.getResourceList(null);
        for (Resource resource: resources) {
            MenuTreeNode node = new MenuTreeNode();
            BeanUtils.copyProperties(resource,node);
            treeNodes.add(node);
        }
        List<MenuTreeNode> menuTreeNodes = TreeUtil.buildTreeBy2Loop(treeNodes,-1);

        result.setSuccessResult(menuTreeNodes);
        return result;
    }

    /*@ApiOperation(value = "获取用户菜单", httpMethod = "GET",notes = "根据用户查询该用户的角色对应的菜单")
    @GetMapping("/getUserMenu")
    public Result<List<MenuTreeNode>> getUserMenuByUserId(HttpServletRequest request){
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserByUserName(username,1);
        Result<List<MenuTreeNode>> result = new Result<>();
        List<MenuTreeNode> treeNodes = new ArrayList<>();
        List<Role> roleList = roleService.getRoleByUid(user.getUid());
        boolean isAdmin = false;
        for(Role r:roleList){
            if(RoleTypeEnum.ADMIN==r.getType()){
                isAdmin = true;
                break;
            }
        }
        List<Resource> resourcesList = null;
        if (isAdmin){
            resourcesList= resourceService.getResourceList(ResourceTypeEnum.BACK_RECOURCE);
            for (Resource resource : resourcesList){
                resource.setAction(resourceService.getAction(resource.getId(),null));
            }
        }else {
            resourcesList = resourceService.getResourceByUid(user.getUid(),ResourceTypeEnum.BACK_RECOURCE);
            for (Resource resource : resourcesList){
                resource.setAction(resourceService.getAction(resource.getId(),user.getUid()));
            }
        }
        for (Resource resource: resourcesList) {
            MenuTreeNode node = new MenuTreeNode();
            BeanUtils.copyProperties(resource,node);
            treeNodes.add(node);
        }
        List<MenuTreeNode> menuTreeNodes = TreeUtil.buildTreeBy2Loop(treeNodes,-1);

        result.setSuccessResult(menuTreeNodes);
        return result;
    }*/

    @ApiOperation(value = "获取用户菜单", httpMethod = "GET",notes = "根据用户查询该用户的角色对应的菜单")
    @GetMapping("/getUserMenu")
    public Result<List<MenuTreeNode>> getUserMenuByUserId(HttpServletRequest request){
        Result<List<MenuTreeNode>> result = new Result<>();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        // 解密获得username，用于和数据库进行对比
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserByUserName(username,1);
        if (user == null){
            result.error500("用户不存在！！");
            return result;
        }
        List<MenuTreeNode> treeNodes = new ArrayList<>();
        List<Role> roleList = roleService.getRoleByUid(user.getUid());
        boolean isAdmin = false;
        for(Role r:roleList){
            if(RoleTypeEnum.ADMIN==r.getType()){
                isAdmin = true;
                break;
            }
        }
        List<Resource> resourcesList = null;
        if (isAdmin){
            resourcesList= resourceService.getResourceList(ResourceTypeEnum.BACK_RECOURCE);
        }else {
            resourcesList = resourceService.getResourceByUid(user.getUid(),ResourceTypeEnum.BACK_RECOURCE);
        }
        for (Resource resource: resourcesList) {
            MenuTreeNode node = new MenuTreeNode();
            BeanUtils.copyProperties(resource,node);
            treeNodes.add(node);
        }
        List<MenuTreeNode> menuTreeNodes = TreeUtil.buildTreeBy2Loop(treeNodes,-1);

        result.setSuccessResult(menuTreeNodes);
        return result;
    }

    @GetMapping("/selectByCode")
    @ApiOperation("根据code获取菜单")
    public Result selectByCode(@RequestParam(required = true)String code){
        Result result = new Result();
        result.setSuccessResult(resourceService.selectByCode(code));
        return result;
    }

    @GetMapping("/getWaitHandle")
    @ApiOperation("判断是否拥有待处理事项权限")
    public Result getWaitHandle(HttpServletRequest request){
        Result result = new Result();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserByUserName(username,1);
        if (user == null){
            result.error500("用户不存在！！");
            return result;
        }
        List<Role> roleList = roleService.getRoleByUid(user.getUid());
        boolean isAdmin = false;
        for(Role r:roleList){
            if(RoleTypeEnum.ADMIN==r.getType()){
                isAdmin = true;
                break;
            }
        }
        if (!isAdmin){
            if (resourceService.getWaitHandleByUid(user.getUid(),"/orderApply/getPendDisCount")==null){
                result.setSuccess(false);
                return result;
            }
        }
        result.setSuccess(true);
        return result;
    }

}
