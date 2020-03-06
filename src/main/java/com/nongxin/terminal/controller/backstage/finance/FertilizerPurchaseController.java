package com.nongxin.terminal.controller.backstage.finance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.finance.BasePurchase;
import com.nongxin.terminal.entity.finance.FertilizerPurchase;
import com.nongxin.terminal.service.finance.BasePurchaseService;
import com.nongxin.terminal.service.finance.FertilizerPurchaseService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fertilizerPurchase")
public class FertilizerPurchaseController {

    @Autowired
    private FertilizerPurchaseService fertilizerPurchaseService;

    @PostMapping("/add")
    @ApiOperation("添加肥料采购合同")
    public Result add(@Validated @RequestBody FertilizerPurchase fertilizerPurchase){
        Result result = new Result();
        boolean isSuccess = fertilizerPurchaseService.add(fertilizerPurchase);
        if (isSuccess){
            result.setMessage("添加肥料采购合同成功");
        }else {
            result.setMessage("添加肥料采购合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除肥料采购合同")
    public Result delete(Integer id){
        Result result = new Result();
        boolean isSuccess = fertilizerPurchaseService.delete(id);
        if (isSuccess){
            result.setMessage("删除肥料采购合同成功");
        }else {
            result.setMessage("删除肥料采购合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改肥料采购合同")
    public Result update(@RequestBody FertilizerPurchase fertilizerPurchase){
        Result result = new Result();
        boolean isSuccess = fertilizerPurchaseService.update(fertilizerPurchase);
        if (isSuccess){
            result.setMessage("修改肥料采购合同成功");
        }else {
            result.setMessage("修改肥料采购合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页查询肥料采购合同")
    public Result<PageInfo> getList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                    @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                    Integer yearId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<FertilizerPurchase> list = fertilizerPurchaseService.getFertilizerPurchaseList(yearId);
        PageInfo pageInfo = new PageInfo(list);
        result.setSuccessResult(pageInfo);
        return result;
    }

}
