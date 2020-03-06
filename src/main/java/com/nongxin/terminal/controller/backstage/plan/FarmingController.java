package com.nongxin.terminal.controller.backstage.plan;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.plant.Farming;
import com.nongxin.terminal.service.plan.FarmingService;
import com.nongxin.terminal.util.enumUtil.plan.FarmingTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farming")
public class FarmingController {

    @Autowired
    private FarmingService farmingService;

    @PostMapping("/add")
    @ApiOperation("添加农事活动")
    public Result addFarming(@Validated @RequestBody Farming farming){
        Result result = new Result();
        farming.setType(FarmingTypeEnum.ORDINARY);
        boolean isSuccess = farmingService.add(farming);
        if (isSuccess){
            result.setMessage("添加农事活动成功");
        }else {
            result.setMessage("添加农事活动失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/addTemporaryFarming")
    @ApiOperation("添加临时农事活动")
    public Result addTemporaryFarming(@Validated @RequestBody Farming farming){
        Result result = new Result();
        farming.setType(FarmingTypeEnum.TEMPORARY);
        boolean isSuccess = farmingService.add(farming);
        if (isSuccess){
            result.setMessage("添加临时农事活动成功");
        }else {
            result.setMessage("添加临时农事活动失败");
        }
        result.setSuccess(isSuccess);
        result.setResult(farming.getId());
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除农事活动")
    public Result deleteFarming(Integer id){
        Result result = new Result();
        boolean isSuccess = farmingService.delete(id);
        if (isSuccess){
            result.setMessage("删除农事活动成功");
        }else {
            result.setMessage("删除农事活动失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改农事活动")
    public Result updateFarming(@RequestBody Farming farming){
        Result result = new Result();
        boolean isSuccess = farmingService.update(farming);
        if (isSuccess){
            result.setMessage("修改农事活动成功");
        }else {
            result.setMessage("修改农事活动失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/updateSequExecute")
    @ApiOperation("修改农事按序执行")
    public Result updateFarming(@RequestParam(required = true)Integer id,@RequestParam(required = true)boolean sequExecute){
        Result result = new Result();
        boolean isSuccess = farmingService.updateSequExecute(id,sequExecute);
        if (isSuccess){
            result.setMessage("修改成功");
        }else {
            result.setMessage("修改失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询种植计划",notes = "根据种植年计划id查询种植计划")
    public Result<List<Farming>> getFarmingList(Integer planYearId){
        Result<List<Farming>> result = new Result<>();
        result.setSuccessResult(farmingService.getFarmingList(planYearId,null,null));
        return result;
    }

    @GetMapping("/temporaryFarmingList")
    @ApiOperation(value = "分页带条件查询临时农事")
    public Result<PageInfo> getTemporaryFarmingList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                        @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                        String farmingName){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<Farming> roleList = farmingService.getFarmingList(null,farmingName,FarmingTypeEnum.TEMPORARY);
        PageInfo pageInfo = new PageInfo(roleList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

}
