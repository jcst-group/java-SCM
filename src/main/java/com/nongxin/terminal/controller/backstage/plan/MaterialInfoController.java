package com.nongxin.terminal.controller.backstage.plan;

import com.nongxin.terminal.entity.plant.MaterialInfo;
import com.nongxin.terminal.service.plan.MaterialInfoService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materialInfo")
public class MaterialInfoController {

    @Autowired
    private MaterialInfoService materialInfoService;

    @PostMapping("/add")
    @ApiOperation("添加物料信息")
    public Result addMaterialInfo(@Validated @RequestBody MaterialInfo materialInfo){
        Result result = new Result();
        boolean isSuccess = materialInfoService.add(materialInfo);
        if (isSuccess){
            result.setMessage("添加物料信息成功");
        }else {
            result.setMessage("添加物料信息失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除物料信息")
    public Result deleteMaterialInfo(Integer id){
        Result result = new Result();
        boolean isSuccess = materialInfoService.delete(id);
        if (isSuccess){
            result.setMessage("删除物料信息成功");
        }else {
            result.setMessage("删除物料信息失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改物料信息")
    public Result updateMaterialInfo(@RequestBody MaterialInfo materialInfo){
        Result result = new Result();
        boolean isSuccess = materialInfoService.update(materialInfo);
        if (isSuccess){
            result.setMessage("修改物料信息成功");
        }else {
            result.setMessage("修改物料信息失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询物料信息",notes = "根据农事活动id查询物料信息")
    public Result<List<MaterialInfo>> getMaterialInfoList(Integer farmingId){
        Result<List<MaterialInfo>> result = new Result<>();
        result.setSuccessResult(materialInfoService.selectByFarmingId(farmingId));
        return result;
    }

}
