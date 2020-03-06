package com.nongxin.terminal.controller.backstage.illness;

import com.nongxin.terminal.service.illness.IllnessService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/illness")
public class IllnessController {

    @Autowired
    private IllnessService illnessService;

    @GetMapping("/all")
    @ApiOperation(value = "获取所有病虫害",notes = "可根据病虫害名称模糊查询")
    public Result all(String illnessName){
        Result result = new Result();
        result.setSuccessResult(illnessService.getAll(illnessName));
        return result;
    }

}
