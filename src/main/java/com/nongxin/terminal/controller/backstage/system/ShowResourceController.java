package com.nongxin.terminal.controller.backstage.system;

import com.nongxin.terminal.entity.system.ShowResource;
import com.nongxin.terminal.service.system.ShowResourceService;
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
@RequestMapping("/showResource")
public class ShowResourceController {

    @Autowired
    private ShowResourceService showResourceService;

    @PostMapping("/add")
    @ApiOperation("增加看板权限")
    public Result addShowResource(@Validated @RequestBody ShowResource showResource){
        Result result = new Result();
        boolean isSuccess = showResourceService.add(showResource);
        if (isSuccess){
            result.setMessage("添加看板权限成功");
        }else{
            result.setMessage("添加看板权限失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除看板权限")
    public Result deleteShowResource(@RequestParam(required = true) Integer id){
        Result result = new Result();
        boolean isSuccess = showResourceService.delete(id);
        if (isSuccess){
            result.setMessage("删除看板权限成功");
        }else{
            result.setMessage("删除看板权限失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改看板权限")
    public Result updateShowResource(@RequestBody ShowResource showResource){
        Result result = new Result();
        boolean isSuccess = showResourceService.update(showResource);
        if (isSuccess){
            result.setMessage("修改看板权限成功");
        }else{
            result.setMessage("修改看板权限失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @ApiOperation(value = "获取全部菜单列", httpMethod = "GET",notes = "获得的是菜单的树状结构数据，通常用于刷新表单")
    @GetMapping("/list")
    public Result<List<MenuTreeNode>> getMenus(){
        Result<List<MenuTreeNode>> result = new Result<>();
        List<MenuTreeNode> treeNodes = new ArrayList<>();
        List<ShowResource> resources = showResourceService.getShowResourceList(null);
        for (ShowResource resource: resources) {
            MenuTreeNode node = new MenuTreeNode();
            BeanUtils.copyProperties(resource,node);
            treeNodes.add(node);
        }
        List<MenuTreeNode> menuTreeNodes = TreeUtil.buildTreeBy2Loop(treeNodes,-1);

        result.setSuccessResult(menuTreeNodes);
        return result;
    }

}
