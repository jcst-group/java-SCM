package com.nongxin.terminal.controller.backstage.finance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.finance.LaborDispatch;
import com.nongxin.terminal.service.finance.LaborDispatchService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laborDispatch")
public class LaborDispatchController {

    @Autowired
    private LaborDispatchService laborDispatchService;

    @PostMapping("/add")
    @ApiOperation("添加劳务派遣合同")
    public Result add(@Validated @RequestBody LaborDispatch laborDispatch){
        Result result = new Result();
        boolean isSuccess = laborDispatchService.add(laborDispatch);
        if (isSuccess){
            result.setMessage("添加劳务派遣合同成功");
        }else {
            result.setMessage("添加劳务派遣合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除劳务派遣合同")
    public Result delete(Integer id){
        Result result = new Result();
        boolean isSuccess = laborDispatchService.delete(id);
        if (isSuccess){
            result.setMessage("删除劳务派遣合同成功");
        }else {
            result.setMessage("删除劳务派遣合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改劳务派遣合同")
    public Result update(@RequestBody LaborDispatch laborDispatch){
        Result result = new Result();
        boolean isSuccess = laborDispatchService.update(laborDispatch);
        if (isSuccess){
            result.setMessage("修改劳务派遣合同成功");
        }else {
            result.setMessage("修改劳务派遣合同失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页查询劳务派遣合同")
    public Result<PageInfo> getList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                    @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                    Integer yearId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<LaborDispatch> list = laborDispatchService.getLaborDispatchList(yearId);
        PageInfo pageInfo = new PageInfo(list);
        result.setSuccessResult(pageInfo);
        return result;
    }

}
