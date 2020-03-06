package com.nongxin.terminal.controller.backstage.processing;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.batch.InitialProBatch;
import com.nongxin.terminal.service.processing.ProBatchService;
import com.nongxin.terminal.util.enumUtil.common.CodingStatusEnum;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.initPro.InitProVo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/probatch")
public class ProcessBatchController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessBatchController.class);

    @Autowired
    private ProBatchService proBatchService;

    @PostMapping("/add")
    @ApiOperation("添加初加工批次")
    public Result addProBatch(@Validated @RequestBody InitialProBatch initialProBatch){
        Result result = new Result();
        initialProBatch.setStatus(CodingStatusEnum.UNCODED);
        boolean isSuccess = proBatchService.add(initialProBatch);
        if (isSuccess){
            result.setMessage("添加初加工批次成功");
        }else {
            result.setMessage("添加初加工批次失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除初加工批次")
    public Result deleteProBatch(Integer id){
        Result result = new Result();
        boolean isSuccess = proBatchService.delete(id);
        if (isSuccess){
            result.setMessage("删除初加工批次成功");
        }else {
            result.setMessage("删除初加工批次失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改初加工批次")
    public Result updateProBatch(@RequestBody InitialProBatch initialProBatch){
        Result result = new Result();
        boolean isSuccess = proBatchService.update(initialProBatch);
        if (isSuccess){
            result.setMessage("修改初加工批次成功");
        }else {
            result.setMessage("修改初加工批次失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询初加工批次")
    public Result<PageInfo> getProBatchList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                            @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                            Integer planId, Date startTime, Date endTime,Integer recoveryId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<InitialProBatch> processingList = proBatchService.selectProBatchs(planId,startTime,endTime,recoveryId);
        PageInfo pageInfo = new PageInfo(processingList);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/getInitProVoByPlanId")
    @ApiOperation("根据种植计划id查询初加工批次")
    public Result<List<InitProVo>> getInitProVoByPlanId(Integer planId){
        Result<List<InitProVo>> result = new Result<>();
        result.setSuccessResult(proBatchService.getInitProVoByPlanId(planId));
        return result;
    }


}
