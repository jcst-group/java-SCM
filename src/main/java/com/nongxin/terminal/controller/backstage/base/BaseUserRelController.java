package com.nongxin.terminal.controller.backstage.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.base.BaseUserRel;
import com.nongxin.terminal.service.base.BaseUserRelService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baseUserRel")
public class BaseUserRelController {

    @Autowired
    private BaseUserRelService baseUserRelService;

    @PostMapping("/add")
    @ApiOperation("添加基地人员对应关系")
    public Result addBaseUserRel(@Validated @RequestBody BaseUserRel baseUserRel){
        Result result = new Result();
        boolean isSuccess = baseUserRelService.add(baseUserRel);
        if (isSuccess){
            result.setMessage("添加基地人员对应关系成功");
        }else {
            result.setMessage("添加基地人员对应关系失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除基地人员对应关系")
    public Result deleteBaseUserRel(Integer id){
        Result result = new Result();
        boolean isSuccess = baseUserRelService.delete(id);
        if (isSuccess){
            result.setMessage("删除基地人员对应关系成功");
        }else {
            result.setMessage("删除基地人员对应关系失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询基地人员对应关系")
    public Result<PageInfo> getBaseUserRelList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                               @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                               String baseName,String userName){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<BaseUserRel> lotList = baseUserRelService.getBaseUserList(baseName,userName);
        PageInfo pageInfo = new PageInfo(lotList);
        result.setSuccessResult(pageInfo);
        return result;
    }

}
