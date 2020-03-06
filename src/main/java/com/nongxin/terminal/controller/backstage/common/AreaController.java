package com.nongxin.terminal.controller.backstage.common;

import com.nongxin.terminal.entity.address.Area;
import com.nongxin.terminal.service.common.AreaService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/getAreaByLevel")
    @ApiOperation("获取一级地区")
    public Result<List<Area>> getAreaByLevel(){
        Result<List<Area>> result = new Result<List<Area>>();
        result.setSuccessResult(areaService.getAreaByLevel(1));
        return result;
    }

    @GetMapping("/getAreaByParentCode")
    @ApiOperation("根据code获取子地区")
    public Result<List<Area>> getAreaByParentCode(@RequestParam(required = true)String parentCode){
        Result<List<Area>> result = new Result<List<Area>>();
        result.setSuccessResult(areaService.getAreaByParentCode(parentCode));
        return result;
    }
}
