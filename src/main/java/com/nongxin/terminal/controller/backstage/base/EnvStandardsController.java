package com.nongxin.terminal.controller.backstage.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.base.EnvStandards;
import com.nongxin.terminal.service.base.EnvStandardsService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/envStandards")
public class EnvStandardsController {

    @Autowired
    private EnvStandardsService envStandardsService;

    @PostMapping("/add")
    @ApiOperation("增加基地环境标准")
    public Result addEnvStandards(@Validated @RequestBody EnvStandards envStandards){
        Result result = new Result();
        boolean isSuccess = envStandardsService.add(envStandards);
        if (isSuccess){
            result.setMessage("添加基地环境标准成功");
        }else{
            result.setMessage("添加基地环境标准失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除基地环境标准")
    public Result deleteEnvStandards(@RequestParam(required = true) Integer id){
        Result result = new Result();
        boolean isSuccess = envStandardsService.delete(id);
        if (isSuccess){
            result.setMessage("删除基地环境标准成功");
        }else{
            result.setMessage("删除基地环境标准失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改基地环境标准")
    public Result updateEnvStandards(@RequestBody EnvStandards envStandards){
        Result result = new Result();
        boolean isSuccess = envStandardsService.update(envStandards);
        if (isSuccess){
            result.setMessage("修改基地环境标准成功");
        }else{
            result.setMessage("修改基地环境标准失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询基地环境标准")
    public Result<PageInfo> getEnvStandards(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                        @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                        EnvStandards envStandards){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<EnvStandards> envStandardsList = envStandardsService.getEnvStandards(envStandards);
        PageInfo pageInfo = new PageInfo(envStandardsList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/all")
    @ApiOperation(value = "查询所有基地环境标准")
    public Result<List<EnvStandards>> getAllEnvStandards(){
        Result<List<EnvStandards>> result = new Result<>();
        List<EnvStandards> envStandardsList = envStandardsService.getEnvStandards(null);
        result.setSuccessResult(envStandardsList);
        return result;
    }

}
