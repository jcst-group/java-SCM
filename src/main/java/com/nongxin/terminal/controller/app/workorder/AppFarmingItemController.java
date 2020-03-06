package com.nongxin.terminal.controller.app.workorder;

import com.nongxin.terminal.service.plan.FarmingItemService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/farmingItem")
public class AppFarmingItemController {

    @Autowired
    private FarmingItemService farmingItemService;

    @GetMapping("/selectById")
    @ApiOperation("根据id查询农事项目")
    public Result selectById(Integer id){
        Result result = new Result();
        result.setSuccessResult(farmingItemService.selectByPrimaryKey(id));
        return result;
    }

}
