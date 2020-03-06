package com.nongxin.terminal.controller.backstage.plan;

import com.nongxin.terminal.entity.plant.PersonnelInfo;
import com.nongxin.terminal.service.plan.PersonnelInfoService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnelInfo")
public class PersonnelInfoController {

    @Autowired
    private PersonnelInfoService personnelInfoService;

    @PostMapping("/add")
    @ApiOperation("添加人员信息")
    public Result addFarming(@Validated @RequestBody PersonnelInfo personnelInfo){
        Result result = new Result();
        boolean isSuccess = personnelInfoService.add(personnelInfo);
        if (isSuccess){
            result.setMessage("添加人员信息成功");
        }else {
            result.setMessage("添加人员信息失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除人员信息")
    public Result deleteFarming(Integer id){
        Result result = new Result();
        boolean isSuccess = personnelInfoService.delete(id);
        if (isSuccess){
            result.setMessage("删除人员信息成功");
        }else {
            result.setMessage("删除人员信息失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改人员信息")
    public Result updateFarming(@RequestBody PersonnelInfo personnelInfo){
        Result result = new Result();
        boolean isSuccess = personnelInfoService.update(personnelInfo);
        if (isSuccess){
            result.setMessage("修改人员信息成功");
        }else {
            result.setMessage("修改人员信息失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询人员信息",notes = "根据农事活动id查询人员信息")
    public Result<List<PersonnelInfo>> getFarmingList(Integer farmingId){
        Result<List<PersonnelInfo>> result = new Result<>();
        result.setSuccessResult(personnelInfoService.selectByFarmingId(farmingId));
        return result;
    }

}
