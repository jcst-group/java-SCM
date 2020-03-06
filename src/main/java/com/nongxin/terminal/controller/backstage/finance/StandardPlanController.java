package com.nongxin.terminal.controller.backstage.finance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.finance.PledgeGoods;
import com.nongxin.terminal.entity.finance.StandardPlan;
import com.nongxin.terminal.service.finance.PledgeGoodsService;
import com.nongxin.terminal.service.finance.StandardPlanService;
import com.nongxin.terminal.support.BaseException;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/standardPlan")
public class StandardPlanController {

    @Autowired
    private StandardPlanService standardPlanService;

    @PostMapping("/add")
    @ApiOperation("添加规范化种植协议")
    public Result add(@Validated @RequestBody StandardPlan standardPlan) throws BaseException {
        Result result = new Result();
        boolean isSuccess = standardPlanService.add(standardPlan);
        if (isSuccess){
            result.setMessage("添加规范化种植协议成功");
        }else {
            result.setMessage("添加规范化种植协议失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除规范化种植协议")
    public Result delete(Integer id){
        Result result = new Result();
        boolean isSuccess = standardPlanService.delete(id);
        if (isSuccess){
            result.setMessage("删除规范化种植协议成功");
        }else {
            result.setMessage("删除规范化种植协议失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改规范化种植协议")
    public Result update(@RequestBody StandardPlan standardPlan) throws BaseException {
        Result result = new Result();
        boolean isSuccess = standardPlanService.update(standardPlan);
        if (isSuccess){
            result.setMessage("修改规范化种植协议成功");
        }else {
            result.setMessage("修改规范化种植协议失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页查询规范化种植协议")
    public Result<PageInfo> getList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                    @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                    Integer yearId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<StandardPlan> list = standardPlanService.getStandardPlanList(yearId);
        PageInfo pageInfo = new PageInfo(list);
        result.setSuccessResult(pageInfo);
        return result;
    }

}
