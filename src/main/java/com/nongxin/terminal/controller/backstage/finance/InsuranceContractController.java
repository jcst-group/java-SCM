package com.nongxin.terminal.controller.backstage.finance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.finance.FertilizerPurchase;
import com.nongxin.terminal.entity.finance.InsuranceContract;
import com.nongxin.terminal.service.finance.FertilizerPurchaseService;
import com.nongxin.terminal.service.finance.InsuranceContractService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insuranceContract")
public class InsuranceContractController {

    @Autowired
    private InsuranceContractService insuranceContractService;

    @PostMapping("/add")
    @ApiOperation("添加保险合同")
    public Result add(@Validated @RequestBody InsuranceContract insuranceContract){
        Result result = new Result();
        boolean isSuccess = insuranceContractService.add(insuranceContract);
        if (isSuccess){
            result.setMessage("添加保险合同成功");
        }else {
            result.setMessage("添加保险合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除保险合同")
    public Result delete(Integer id){
        Result result = new Result();
        boolean isSuccess = insuranceContractService.delete(id);
        if (isSuccess){
            result.setMessage("删除保险合同成功");
        }else {
            result.setMessage("删除保险合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改保险合同")
    public Result update(@RequestBody InsuranceContract insuranceContract){
        Result result = new Result();
        boolean isSuccess = insuranceContractService.update(insuranceContract);
        if (isSuccess){
            result.setMessage("修改保险合同成功");
        }else {
            result.setMessage("修改保险合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页查询保险合同")
    public Result<PageInfo> getList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                    @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                    Integer yearId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<InsuranceContract> list = insuranceContractService.getInsuranceContractList(yearId);
        PageInfo pageInfo = new PageInfo(list);
        result.setSuccessResult(pageInfo);
        return result;
    }

}
