package com.nongxin.terminal.controller.backstage.testing;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.testing.DetectionItems;
import com.nongxin.terminal.util.enumUtil.test.DetectionStageEnum;
import com.nongxin.terminal.service.testing.DetectionItemsService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detectionItems")
public class DetectionItemsController {

    @Autowired
    private DetectionItemsService detectionItemsService;

    @PostMapping("/add")
    @ApiOperation("添加检测标准")
    public Result addDetectionItems(@Validated @RequestBody DetectionItems detectionItems){
        Result result = new Result();
        boolean isSuccess = detectionItemsService.add(detectionItems);
        if (isSuccess){
            result.setMessage("添加检测标准成功");
        }else {
            result.setMessage("添加检测标准失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除检测标准")
    public Result deleteDetectionItems(Integer id){
        Result result = new Result();
        boolean isSuccess = detectionItemsService.delete(id);
        if (isSuccess){
            result.setMessage("删除检测标准成功");
        }else {
            result.setMessage("删除检测标准失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改检测标准")
    public Result updateDetectionItems(@RequestBody DetectionItems detectionItems){
        Result result = new Result();
        boolean isSuccess = detectionItemsService.update(detectionItems);
        if (isSuccess){
            result.setMessage("修改检测标准成功");
        }else {
            result.setMessage("修改检测标准失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询检测标准")
    public Result<PageInfo> getDetectionItemsList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                  @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                                  DetectionStageEnum stage, Integer cropId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<DetectionItems> lotList = detectionItemsService.getDetectionItemsList(stage,cropId);
        PageInfo pageInfo = new PageInfo(lotList);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/getSeedDetection")
    @ApiOperation("获取种子检测项")
    public Result getSeedDetection(@RequestParam(required = true) Integer cropId){
        Result result = new Result();
        result.setSuccessResult(detectionItemsService.selectByStage(DetectionStageEnum.SEED,cropId));
        return result;
    }

    @GetMapping("/getRecoveryDetection")
    @ApiOperation("获取采收检测项")
    public Result getRecoveryDetection(@RequestParam(required = true)Integer cropId){
        Result result = new Result();
        result.setSuccessResult(detectionItemsService.selectByStage(DetectionStageEnum.RECOVERY,cropId));
        return result;
    }

    @GetMapping("/getIniproDetection")
    @ApiOperation("获取初加工检测项")
    public Result getIniproDetection(@RequestParam(required = true)Integer cropId){
        Result result = new Result();
        result.setSuccessResult(detectionItemsService.selectByStage(DetectionStageEnum.INIPRO,cropId));
        return result;
    }

}
