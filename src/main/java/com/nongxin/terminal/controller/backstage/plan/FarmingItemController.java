package com.nongxin.terminal.controller.backstage.plan;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.plant.FarmingItem;
import com.nongxin.terminal.service.plan.FarmingItemService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmingItem")
public class FarmingItemController {

    @Autowired
    private FarmingItemService farmingItemService;

    @PostMapping("/add")
    @ApiOperation("添加农事项目")
    public Result addFarmingItem(@Validated @RequestBody FarmingItem farmingItem){
        Result result = new Result();
        boolean isSuccess = farmingItemService.add(farmingItem);
        if (isSuccess){
            result.setMessage("添加农事项目成功");
        }else {
            result.setMessage("添加农事项目失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除农事项目")
    public Result deleteFarmingItem(Integer id){
        Result result = new Result();
        boolean isSuccess = farmingItemService.delete(id);
        if (isSuccess){
            result.setMessage("删除农事项目成功");
        }else {
            result.setMessage("删除农事项目失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改农事项目")
    public Result updateFarmingItem(@RequestBody FarmingItem farmingItem){
        Result result = new Result();
        boolean isSuccess = farmingItemService.update(farmingItem);
        if (isSuccess){
            result.setMessage("修改农事项目成功");
        }else {
            result.setMessage("修改农事项目失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询农事项目")
    public Result<PageInfo> getFarmingItemList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                                Integer cropId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<FarmingItem> farmingItemList = farmingItemService.getFarmingItemList(cropId);
        PageInfo pageInfo = new PageInfo(farmingItemList);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/all")
    @ApiOperation("查询所有农事项目，用于下拉列表选择")
    public Result getAllFarmingItem(){
        Result result = new Result();
        result.setSuccessResult(farmingItemService.getAllFarmingItem());
        return result;
    }

    @GetMapping("/getFarmingItemByCropId")
    @ApiOperation("根据作物id查询农事项目")
    public Result getFarmingItemByCropId(Integer cropId){
        Result result = new Result();
        result.setSuccessResult(farmingItemService.getFarmingItemByCropId(cropId));
        return result;
    }

}
