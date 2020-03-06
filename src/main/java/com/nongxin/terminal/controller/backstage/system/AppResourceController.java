package com.nongxin.terminal.controller.backstage.system;

import com.nongxin.terminal.entity.system.AppResource;
import com.nongxin.terminal.service.system.AppResourceService;
import com.nongxin.terminal.util.TreeUtil;
import com.nongxin.terminal.vo.MenuTreeNode;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/appResource")
public class AppResourceController {

    @Autowired
    private AppResourceService appResourceService;

    @PostMapping("/add")
    @ApiOperation("增加app权限")
    public Result addAppResource(@Validated @RequestBody AppResource appResource){
        Result result = new Result();
        boolean isSuccess = appResourceService.add(appResource);
        if (isSuccess){
            result.setMessage("添加app权限成功");
        }else{
            result.setMessage("添加app权限失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除app权限")
    public Result deleteAppResource(@RequestParam(required = true) Integer id){
        Result result = new Result();
        boolean isSuccess = appResourceService.delete(id);
        if (isSuccess){
            result.setMessage("删除app权限成功");
        }else{
            result.setMessage("删除app权限失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改app权限")
    public Result updateAppResource(@RequestBody AppResource appResource){
        Result result = new Result();
        boolean isSuccess = appResourceService.update(appResource);
        if (isSuccess){
            result.setMessage("修改app权限成功");
        }else{
            result.setMessage("修改app权限失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @ApiOperation(value = "获取app全部菜单列", httpMethod = "GET",notes = "获得的是菜单的树状结构数据，通常用于刷新表单")
    @GetMapping("/list")
    public Result<List<MenuTreeNode>> getMenus(){
        Result<List<MenuTreeNode>> result = new Result<>();
        List<MenuTreeNode> treeNodes = new ArrayList<>();
        List<AppResource> resources = appResourceService.getAppResourceList(null);
        for (AppResource resource: resources) {
            MenuTreeNode node = new MenuTreeNode();
            BeanUtils.copyProperties(resource,node);
            treeNodes.add(node);
        }
        List<MenuTreeNode> menuTreeNodes = TreeUtil.buildTreeBy2Loop(treeNodes,-1);

        result.setSuccessResult(menuTreeNodes);
        return result;
    }

}
