package com.nongxin.terminal.controller.backstage.processing;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.processing.ProcessingMethods;
import com.nongxin.terminal.service.processing.ProcessingMethodsService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/processing")
public class ProcessingMethodsController {

    @Autowired
    private ProcessingMethodsService processingMethodsService;

    @PostMapping("/add")
    @ApiOperation("添加初加工方式")
    public Result addProcessing(@Validated @RequestBody ProcessingMethods processingMethods){
        Result result = new Result();
        boolean isSuccess = processingMethodsService.add(processingMethods);
        if (isSuccess){
            result.setMessage("添加初加工方式成功");
        }else {
            result.setMessage("添加初加工方式失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除初加工方式")
    public Result deleteProcessing(Integer id){
        Result result = new Result();
        boolean isSuccess = processingMethodsService.delete(id);
        if (isSuccess){
            result.setMessage("删除初加工方式成功");
        }else {
            result.setMessage("删除初加工方式失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改初加工方式")
    public Result updateProcessing(@RequestBody ProcessingMethods processingMethods){
        Result result = new Result();
        boolean isSuccess = processingMethodsService.update(processingMethods);
        if (isSuccess){
            result.setMessage("修改初加工方式成功");
        }else {
            result.setMessage("修改初加工方式失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询初加工方式")
    public Result<PageInfo> getProcessingList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                        @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                        Integer cropId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<ProcessingMethods> processingList = processingMethodsService.getProcessingMethods(cropId);
        PageInfo pageInfo = new PageInfo(processingList);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/all")
    @ApiOperation("获取所有初加工方式，用于下拉列表选择")
    public Result getAllProcessing(){
        Result result = new Result();
        result.setSuccessResult(processingMethodsService.getAllProcessingMethods());
        return result;
    }

    @GetMapping("/selectByCropId")
    @ApiOperation("根据作物筛选加工方式")
    public Result selectByCropId(Integer cropId){
        Result result = new Result();
        result.setSuccessResult(processingMethodsService.selectByCropId(cropId));
        return result;
    }

}
