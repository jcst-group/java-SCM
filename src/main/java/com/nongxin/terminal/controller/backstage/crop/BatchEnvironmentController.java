package com.nongxin.terminal.controller.backstage.crop;

import com.nongxin.terminal.entity.crop.BatchEnvironment;
import com.nongxin.terminal.service.crop.BatchEnvironmentService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/batchEnvironment")
public class BatchEnvironmentController {

    @Autowired
    private BatchEnvironmentService batchEnvironmentService;

    @PostMapping("/add")
    @ApiOperation("添加批次环境")
    public Result addBatchEnvironment(@Validated @RequestBody BatchEnvironment batchEnvironment){
        Result result = new Result();
        boolean isSuccess = batchEnvironmentService.add(batchEnvironment);
        if (isSuccess){
            result.setMessage("添加成功");
        }else {
            result.setMessage("添加失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/getBatchEnvironment")
    @ApiOperation("获取批次环境")
    public Result getBatchEnvironment(Integer batchId){
        Result result = new Result();
        result.setSuccessResult(batchEnvironmentService.selectByBatchId(batchId));
        return result;
    }

}
