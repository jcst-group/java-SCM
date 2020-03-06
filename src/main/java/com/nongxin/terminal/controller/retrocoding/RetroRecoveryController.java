package com.nongxin.terminal.controller.retrocoding;

import com.nongxin.terminal.util.enumUtil.test.DetectionCategoryEnum;
import com.nongxin.terminal.util.enumUtil.test.DetectionStageEnum;
import com.nongxin.terminal.service.recovery.RecoveryBatchService;
import com.nongxin.terminal.service.testing.DetectionItemsService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 追溯码采收接口
 */
@RestController
@RequestMapping("/retro/recovery")
public class RetroRecoveryController {

    @Autowired
    private RecoveryBatchService recoveryService;
    @Autowired
    private DetectionItemsService detectionItemsService;

    @GetMapping("/getRecovery")
    @ApiOperation("根据追溯码获取采收信息")
    public Result getSeedDetection(@RequestParam(required = true)String retroCode){
        Result result = new Result();
        result.setSuccessResult(recoveryService.getRecoveryByRetroCode(retroCode));
        return result;
    }

    @GetMapping("/getDetectionItem")
    @ApiOperation("获取追溯码采收检测数据")
    public Result getDetectionItem(@RequestParam(required = true)Integer relationId,
                                   @RequestParam(required = true)DetectionCategoryEnum category){
        Result result = new Result();
        result.setSuccessResult(detectionItemsService.getDetectionByRelationId(relationId,DetectionStageEnum.RECOVERY,category));
        return result;
    }

}
