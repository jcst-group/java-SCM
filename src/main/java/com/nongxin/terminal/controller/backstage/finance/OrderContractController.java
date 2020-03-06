package com.nongxin.terminal.controller.backstage.finance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.finance.LaborDispatch;
import com.nongxin.terminal.entity.finance.OrderContract;
import com.nongxin.terminal.service.finance.LaborDispatchService;
import com.nongxin.terminal.service.finance.OrderContractService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderContract")
public class OrderContractController {

    @Autowired
    private OrderContractService orderContractService;

    @PostMapping("/add")
    @ApiOperation("添加订单合同")
    public Result add(@Validated @RequestBody OrderContract orderContract){
        Result result = new Result();
        boolean isSuccess = orderContractService.add(orderContract);
        if (isSuccess){
            result.setMessage("添加订单合同成功");
        }else {
            result.setMessage("添加订单合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除订单合同")
    public Result delete(Integer id){
        Result result = new Result();
        boolean isSuccess = orderContractService.delete(id);
        if (isSuccess){
            result.setMessage("删除订单合同成功");
        }else {
            result.setMessage("删除订单合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改订单合同")
    public Result update(@RequestBody OrderContract orderContract){
        Result result = new Result();
        boolean isSuccess = orderContractService.update(orderContract);
        if (isSuccess){
            result.setMessage("修改订单合同成功");
        }else {
            result.setMessage("修改订单合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页查询订单合同")
    public Result<PageInfo> getList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                    @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                    Integer yearId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<OrderContract> list = orderContractService.getOrderContractList(yearId);
        PageInfo pageInfo = new PageInfo(list);
        result.setSuccessResult(pageInfo);
        return result;
    }

}
