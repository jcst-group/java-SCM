package com.nongxin.terminal.controller.backstage.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.service.base.BaseInfoService;
import com.nongxin.terminal.util.CodeUtil;
import com.nongxin.terminal.util.enumUtil.base.BaseTypeEnum;
import com.nongxin.terminal.util.enumUtil.base.CategoryEnum;
import com.nongxin.terminal.util.enumUtil.common.CodeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baseInfo")
public class BaseInfoController {

    @Autowired
    private BaseInfoService baseInfoService;

    @PostMapping("/add")
    @ApiOperation("添加基地")
    public Result addBaseInfo(@Validated @RequestBody BaseInfo baseInfo){
        Result result = new Result();
        baseInfo.setBaseCode(CodeUtil.getCode(CodeEnum.BASE));
        boolean isSuccess = baseInfoService.add(baseInfo);
        if (isSuccess){
            result.setMessage("添加基地成功");
        }else {
            result.setMessage("添加基地失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除基地")
    public Result deleteBaseInfo(Integer id){
        Result result = new Result();
        boolean isSuccess = baseInfoService.delete(id);
        if (isSuccess){
            result.setMessage("删除基地成功");
        }else {
            result.setMessage("删除基地失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改基地")
    public Result updateBaseInfo(@RequestBody BaseInfo baseInfo){
        Result result = new Result();
        boolean isSuccess = baseInfoService.update(baseInfo);
        if (isSuccess){
            result.setMessage("修改基地成功");
        }else {
            result.setMessage("修改基地失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询基地")
    public Result<PageInfo> getBaseList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                        @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                        BaseInfo baseInfo){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<BaseInfo> roleList = baseInfoService.getBaseInfoList(baseInfo);
        PageInfo pageInfo = new PageInfo(roleList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/all")
    @ApiOperation("获取所有基地，用于下拉列表选择")
    public Result getAllBaseInfo(String baseName){
        Result result = new Result();
        result.setSuccessResult(baseInfoService.getAllBaseInfo(null,null,baseName));
        return result;
    }

    @GetMapping("/selectAll")
    @ApiOperation("获取所有基地，用于下拉列表选择")
    public Result selectAll(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                            @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                            CategoryEnum category, BaseTypeEnum baseType, String baseName){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<BaseInfo> baseList = baseInfoService.getAllBaseInfo(category,baseType,baseName);
        PageInfo pageInfo = new PageInfo(baseList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getBaseWithoutUser")
    @ApiOperation("/获取无用户的基地")
    public Result getBaseWithoutUser(){
        Result result = new Result();
        result.setSuccessResult(baseInfoService.getBaseWithoutUser());
        return result;
    }

    @GetMapping("/selectByPrimaryKey")
    @ApiOperation("根据基地id查询基地")
    public Result selectByPrimaryKey(Integer id){
        Result result = new Result();
        result.setSuccessResult(baseInfoService.selectByPrimaryKey(id));
        return result;
    }

    @GetMapping("/getBaseEquipment")
    @ApiOperation("获取有设备的基地")
    public Result getBaseEquipment(){
        Result result = new Result();
        result.setSuccessResult(baseInfoService.getBaseEquipment());
        return result;
    }
}
