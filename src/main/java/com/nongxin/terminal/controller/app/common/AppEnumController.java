package com.nongxin.terminal.controller.app.common;

import com.nongxin.terminal.util.enumUtil.plan.WorkOrderStatusEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/enum")
public class AppEnumController {

    @GetMapping("/getWorkOrderStatusEnum")
    @ApiOperation("获取工单状态枚举")
    public Result getWorkOrderStatusEnum(){
        Result result = new Result();
        result.setSuccessResult(WorkOrderStatusEnum.values());
        return result;
    }

}
