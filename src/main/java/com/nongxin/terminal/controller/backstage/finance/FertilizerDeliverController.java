package com.nongxin.terminal.controller.backstage.finance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.finance.BasePurchase;
import com.nongxin.terminal.entity.finance.FertilizerDeliver;
import com.nongxin.terminal.service.finance.BasePurchaseService;
import com.nongxin.terminal.service.finance.FertilizerDeliverService;
import com.nongxin.terminal.support.BaseException;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fertilizerDeliver")
public class FertilizerDeliverController {

    @Autowired
    private FertilizerDeliverService fertilizerDeliverService;

    @PostMapping("/add")
    @ApiOperation("添加肥料交付情况")
    public Result add(@Validated @RequestBody FertilizerDeliver fertilizerDeliver) throws BaseException {
        Result result = new Result();
        boolean isSuccess = fertilizerDeliverService.add(fertilizerDeliver);
        if (isSuccess){
            result.setMessage("添加肥料交付情况成功");
        }else {
            result.setMessage("添加肥料交付情况失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除肥料交付情况")
    public Result delete(Integer id){
        Result result = new Result();
        boolean isSuccess = fertilizerDeliverService.delete(id);
        if (isSuccess){
            result.setMessage("删除肥料交付情况成功");
        }else {
            result.setMessage("删除肥料交付情况失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改肥料交付情况")
    public Result update(@RequestBody FertilizerDeliver fertilizerDeliver) throws BaseException {
        Result result = new Result();
        boolean isSuccess = fertilizerDeliverService.update(fertilizerDeliver);
        if (isSuccess){
            result.setMessage("修改肥料交付情况成功");
        }else {
            result.setMessage("修改肥料交付情况失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询肥料交付情况")
    public Result getList(@RequestParam(required = true)Integer fertilizerId){
        Result result = new Result<>();
        result.setSuccessResult(fertilizerDeliverService.getFertilizerDeliverList(fertilizerId));
        return result;
    }

}
