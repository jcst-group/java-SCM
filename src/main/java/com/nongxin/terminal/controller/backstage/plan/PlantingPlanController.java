package com.nongxin.terminal.controller.backstage.plan;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.plant.PlantingPlan;
import com.nongxin.terminal.service.plan.PlantingPlanService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantingPlan")
public class PlantingPlanController {

    @Autowired
    private PlantingPlanService plantingPlanService;

    @PostMapping("/add")
    @ApiOperation("添加种植计划")
    public Result addPlantingPlan(@Validated @RequestBody PlantingPlan plantingPlan){
        Result result = new Result();
        boolean isSuccess = plantingPlanService.add(plantingPlan);
        if (isSuccess){
            result.setMessage("添加种植计划成功");
        }else {
            result.setMessage("添加种植计划失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除种植计划")
    public Result deletePlantingPlan(Integer id){
        Result result = new Result();
        boolean isSuccess = plantingPlanService.delete(id);
        if (isSuccess){
            result.setMessage("删除种植计划成功");
        }else {
            result.setMessage("删除种植计划失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改种植计划")
    public Result updatePlantingPlan(@RequestBody PlantingPlan plantingPlan){
        Result result = new Result();
        boolean isSuccess = plantingPlanService.update(plantingPlan);
        if (isSuccess){
            result.setMessage("修改种植计划成功");
        }else {
            result.setMessage("修改种植计划失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询种植计划")
    public Result<PageInfo> getPlantingPlanList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                                String planName, Integer cropId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<PlantingPlan> plantingPlanList = plantingPlanService.getPlantingPlanList(planName,cropId);
        PageInfo pageInfo = new PageInfo(plantingPlanList);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/all")
    @ApiOperation("获取所有种植计划")
    public Result getAllPlant(){
        Result result = new Result();
        result.setSuccessResult(plantingPlanService.getPlantingPlanList(null,null));
        return result;
    }

    @GetMapping("/copyPlan")
    @ApiOperation("复制种植计划")
    public Result copyPlan(@RequestParam(required = true)Integer id,@RequestParam(required = true)String planName){
        Result result = new Result();
        boolean isSuccess = plantingPlanService.copyPlan(id,planName);
        if (isSuccess){
            result.setMessage("复制种植计划成功");
        }else {
            result.setMessage("复制种植计划失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

}
