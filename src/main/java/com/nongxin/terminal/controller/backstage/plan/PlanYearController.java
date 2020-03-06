package com.nongxin.terminal.controller.backstage.plan;

import com.nongxin.terminal.entity.plant.PlanYear;
import com.nongxin.terminal.service.plan.PlanYearService;
import com.nongxin.terminal.util.enumUtil.plan.PlanYearEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planYear")
public class PlanYearController {

    @Autowired
    private PlanYearService planYearService;

    @PostMapping("/add")
    @ApiOperation("添加种植年")
    public Result addPlanYear(@Validated @RequestBody PlanYear planYear){
        Result result = new Result();
        if (planYear.getYear() != null){
            planYear.setYear(PlanYearEnum.getByValue((short)(planYear.getYear().getValue()+1)));
        }else {
            planYear.setYear(PlanYearEnum.ONE);
        }
        boolean isSuccess = planYearService.add(planYear);
        if (isSuccess){
            result.setMessage("添加种植年成功");
        }else {
            result.setMessage("添加种植年失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除种植年")
    public Result deletePlanYear(@RequestParam(required = true) Integer id){
        Result result = new Result();
        boolean isSuccess = planYearService.delete(id);
        if (isSuccess){
            result.setMessage("删除种植年成功");
        }else {
            result.setMessage("删除种植年失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/getPlanYearByPlanId")
    @ApiOperation("获取种植计划年")
    public Result getPlanYearByPlanId(@RequestParam(required = true) Integer planId){
        Result result = new Result();
        result.setSuccessResult(planYearService.getPlanYearByPlanId(planId));
        return result;
    }

}
