package com.nongxin.terminal.controller.backstage.plan;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.plant.Farming;
import com.nongxin.terminal.entity.plant.OrderApply;
import com.nongxin.terminal.entity.plant.WorkOrder;
import com.nongxin.terminal.service.plan.OrderApplyService;
import com.nongxin.terminal.service.plan.WorkOrderService;
import com.nongxin.terminal.util.enumUtil.plan.FarmingTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orderApply")
public class OrderApplyController {

    @Autowired
    private OrderApplyService orderApplyService;
    @Autowired
    private WorkOrderService workOrderService;

    @GetMapping("/getPendDisCount")
    @ApiOperation("获取待处理事项数量")
    public Result getPendDisCount(){
        Result result = new Result();
        result.setSuccessResult(orderApplyService.getOrderApplyCount());
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("处理工单执行请求")
    public Result update(@RequestBody OrderApply orderApply){
        Result result = new Result();
        boolean isSuccess = orderApplyService.update(orderApply);
        result.setMessage(isSuccess ? "处理成功":"处理失败");
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/getOrderByApply")
    @ApiOperation("获取工单详情")
    public Result getOrderByApply(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                  @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                  String status){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String,Object>> list = workOrderService.getOrderByApply(status);
        PageInfo pageInfo = new PageInfo(list);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getOrderApply")
    @ApiOperation("查询工单申请")
    public Result getOrderApply(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                Integer orderId,String status){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<OrderApply> list = orderApplyService.getOrderApply(orderId,status);
        PageInfo pageInfo = new PageInfo(list);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

}
