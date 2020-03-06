package com.nongxin.terminal.controller.retrocoding;

import com.nongxin.terminal.util.enumUtil.test.DetectionCategoryEnum;
import com.nongxin.terminal.util.enumUtil.test.DetectionStageEnum;
import com.nongxin.terminal.service.batch.SeedBatchService;
import com.nongxin.terminal.service.testing.DetectionItemsService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 追溯码种子/种苗接口
 */
@RestController
@RequestMapping("/retro/seedBatch")
public class RetroSeedBatchController {

    @Autowired
    private SeedBatchService seedBatchService;
    @Autowired
    private DetectionItemsService detectionItemsService;

    @GetMapping("/getSeedBatch")
    @ApiOperation("根据追溯码获取种子信息")
    public Result getSeedDetection(@RequestParam(required = true)String retroCode){
        Result result = new Result();
        result.setSuccessResult(seedBatchService.selectByRetroCode(retroCode));
        return result;
    }

    @GetMapping("/getDetectionItem")
    @ApiOperation("获取追溯码种子检测数据")
    public Result getDetectionItem(@RequestParam(required = true)Integer relationId,
                                   @RequestParam(required = true)DetectionCategoryEnum category){
        Result result = new Result();
        result.setSuccessResult(detectionItemsService.getDetectionByRelationId(relationId,DetectionStageEnum.SEED,category));
        return result;
    }

}
