package com.nongxin.terminal.controller.backstage.plan;

import com.nongxin.terminal.entity.plant.OrderContent;
import com.nongxin.terminal.service.plan.OrderContentService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderContent")
public class OrderContentController {

    @Autowired
    private OrderContentService orderContentService;

    @PostMapping("/add")
    @ApiOperation("添加工单内容")
    public Result addOrderContent(@Validated @RequestBody OrderContent orderContent){
        Result result = new Result();
        boolean isSuccess = orderContentService.add(orderContent);
        if (isSuccess){
            result.setMessage("添加工单内容成功");
        }else {
            result.setMessage("添加工单内容失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除工单内容")
    public Result deleteOrderContent(Integer id){
        Result result = new Result();
        boolean isSuccess = orderContentService.delete(id);
        if (isSuccess){
            result.setMessage("删除工单内容成功");
        }else {
            result.setMessage("删除工单内容失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

}
