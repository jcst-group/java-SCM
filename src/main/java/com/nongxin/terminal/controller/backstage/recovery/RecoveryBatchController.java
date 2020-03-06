package com.nongxin.terminal.controller.backstage.recovery;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.recovery.RecoveryBatch;
import com.nongxin.terminal.service.recovery.RecoveryBatchService;
import com.nongxin.terminal.util.CodeUtil;
import com.nongxin.terminal.util.enumUtil.common.CodeEnum;
import com.nongxin.terminal.util.enumUtil.common.CodingStatusEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/recoveryBatch")
public class RecoveryBatchController {

    @Autowired
    private RecoveryBatchService recoveryBatchService;

    @PostMapping("/add")
    @ApiOperation("添加采收批次")
    public Result addRecoveryBatch(@Validated @RequestBody RecoveryBatch recoveryBatch){
        Result result = new Result();
        recoveryBatch.setRecoveryCode(CodeUtil.getCode(CodeEnum.RECOVERYBATCH));
        recoveryBatch.setStatus(CodingStatusEnum.UNCODED);
        boolean isSuccess = recoveryBatchService.add(recoveryBatch);
        if (isSuccess){
            result.setMessage("添加采收批次成功");
        }else {
            result.setMessage("添加采收批次失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除采收批次")
    public Result deleteRecoveryBatch(Integer id){
        Result result = new Result();
        boolean isSuccess = recoveryBatchService.delete(id);
        if (isSuccess){
            result.setMessage("删除采收批次成功");
        }else {
            result.setMessage("删除采收批次失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改采收批次")
    public Result updateRecoveryBatch(@RequestBody RecoveryBatch recoveryBatch){
        Result result = new Result();
        boolean isSuccess = recoveryBatchService.update(recoveryBatch);
        if (isSuccess){
            result.setMessage("修改采收批次成功");
        }else {
            result.setMessage("修改采收批次失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation("查询所有采收批次")
    public Result<PageInfo> getRecoveryBatch(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                   @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                                   Integer batchId, Date startTime, Date endTime){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<RecoveryBatch> recoveryBatches = recoveryBatchService.getRecoveryBatch(batchId,startTime,endTime);
        PageInfo pageInfo = new PageInfo(recoveryBatches);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/getRecoveryVo")
    @ApiOperation("获取种植批次关联数据")
    public Result getRecoveryVo(@RequestParam(required = true) Integer batchId){
        Result result = new Result();
        result.setSuccessResult(recoveryBatchService.getRecoveryVo(batchId));
        return result;
    }

    @GetMapping("/getRecoveryByCropId")
    @ApiOperation("根据作物获取采收批次")
    public Result getRecoveryByCropId(Integer cropId,String condition){
        Result result = new Result();
        result.setSuccessResult(recoveryBatchService.getRecoveryByCropId(cropId,condition));
        return result;
    }

    @GetMapping("/getRecoveryByPlanId")
    @ApiOperation("根据种植计划和采收物查询采收批次")
    public Result getRecoveryByPlanId(Integer planId, Integer harvestId,Integer baseId,String batchName){
        Result result = new Result();
        result.setSuccessResult(recoveryBatchService.getRecoveryByPlanId(planId,harvestId,baseId,batchName));
        return result;
    }

    @GetMapping("/getAllRecovery")
    @ApiOperation("获取所有采收批次")
    public Result getAllRecovery(String recoveryCode,String batchName){
        Result result = new Result();
        result.setSuccessResult(recoveryBatchService.getAllRecovery(recoveryCode,batchName));
        return result;
    }

}
