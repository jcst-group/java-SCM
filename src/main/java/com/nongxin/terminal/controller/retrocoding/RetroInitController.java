package com.nongxin.terminal.controller.retrocoding;

import com.nongxin.terminal.util.enumUtil.test.DetectionCategoryEnum;
import com.nongxin.terminal.util.enumUtil.test.DetectionStageEnum;
import com.nongxin.terminal.service.processing.ProBatchService;
import com.nongxin.terminal.service.retrospective.RetroCodingService;
import com.nongxin.terminal.service.testing.DetectionItemsService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 追溯码初加工接口
 */
@RestController
@RequestMapping("/retro/init")
public class RetroInitController {

    @Autowired
    private ProBatchService proBatchService;
    @Autowired
    private DetectionItemsService detectionItemsService;
    @Autowired
    private RetroCodingService retroCodingService;

    @GetMapping("/getInit")
    @ApiOperation("根据追溯码获取初加工信息")
    public Result selectByRetroCode(@RequestParam(required = true)String retroCode){
        Result result = new Result();
        result.setSuccessResult(proBatchService.selectByRetroCode(retroCode));
        return result;
    }

    @GetMapping("/getDetectionItem")
    @ApiOperation("获取追溯码初加工检测数据")
    public Result getDetectionItem(@RequestParam(required = true)Integer relationId,
                                   @RequestParam(required = true)DetectionCategoryEnum category){
        Result result = new Result();
        result.setSuccessResult(detectionItemsService.getDetectionByRelationId(relationId,DetectionStageEnum.INIPRO,category));
        return result;
    }

    @GetMapping("/getRetroPic")
    @ApiOperation("根据追溯码获取相关图片")
    public Result getRetroPic(@RequestParam(required = true)String retroCode){
        Result result = new Result();
        result.setSuccessResult(retroCodingService.getRetroPic(retroCode));
        return result;
    }

}
