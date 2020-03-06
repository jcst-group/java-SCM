package com.nongxin.terminal.controller.backstage.illness;

import com.nongxin.terminal.entity.illness.TreatmentPlan;
import com.nongxin.terminal.service.illness.IllnessService;
import com.nongxin.terminal.service.illness.TreatmentPlanService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treatmentPlan")
public class TreatmentPlanController {

    @Autowired
    private TreatmentPlanService treatmentPlanService;

    @GetMapping("/selectByIllId")
    @ApiOperation(value = "获取某病虫害的所有治疗方案",notes = "可根据治疗方案名称模糊查询")
    public Result selectByIllId(TreatmentPlan treatmentPlan){
        Result result = new Result();
        result.setSuccessResult(treatmentPlanService.selectByIllId(treatmentPlan));
        return result;
    }

}
