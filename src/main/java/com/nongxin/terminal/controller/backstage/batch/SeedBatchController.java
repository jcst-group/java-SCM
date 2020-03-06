package com.nongxin.terminal.controller.backstage.batch;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.batch.SeedBatch;
import com.nongxin.terminal.service.batch.SeedBatchService;
import com.nongxin.terminal.util.CodeUtil;
import com.nongxin.terminal.util.enumUtil.common.CodeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seed")
public class SeedBatchController {

    @Autowired
    private SeedBatchService seedBatchService;

    @PostMapping("/add")
    @ApiOperation("添加种子")
    public Result addSeed(@Validated @RequestBody SeedBatch seedBatch){
        Result result = new Result();
        seedBatch.setSeedCode(CodeUtil.getCode(CodeEnum.SEED));
        boolean isSuccess = seedBatchService.add(seedBatch);
        if (isSuccess){
            result.setMessage("添加种子成功");
        }else {
            result.setMessage("添加种子失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除种子")
    public Result deleteSeed(Integer id){
        Result result = new Result();
        boolean isSuccess = seedBatchService.delete(id);
        if (isSuccess){
            result.setMessage("删除种子成功");
        }else {
            result.setMessage("删除种子失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改种子")
    public Result updateSeed(@RequestBody SeedBatch seedBatch){
        Result result = new Result();
        boolean isSuccess = seedBatchService.update(seedBatch);
        if (isSuccess){
            result.setMessage("修改种子成功");
        }else {
            result.setMessage("修改种子失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询种子")
    public Result<PageInfo> getSeedList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                        @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                        String cropName,String supplier){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<SeedBatch> seedList = seedBatchService.getSeedList(cropName,supplier);
        PageInfo pageInfo = new PageInfo(seedList);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/all")
    @ApiOperation("获取所有种子，用于下拉列表选择")
    public Result getAllSeed(@RequestParam(required = true) Integer cropId){
        Result result = new Result();
        result.setSuccessResult(seedBatchService.getAllSeed(cropId));
        return result;
    }

    @GetMapping("/getSeedAndBatch")
    @ApiOperation("获取所有种子以及种子对应批次，可根据种子编码和批次名称进行筛选")
    public Result getAllSeed(@RequestParam(required = true) Integer cropId,String condition){
        Result result = new Result();
        result.setSuccessResult(seedBatchService.getSeedAndBatch(cropId,condition));
        return result;
    }

}
