package com.nongxin.terminal.controller.backstage.plan;

import com.nongxin.terminal.entity.plant.DeviceInfo;
import com.nongxin.terminal.service.plan.DeviceInfoService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deviceInfo")
public class DeviceInfoController {

    @Autowired
    private DeviceInfoService deviceInfoService;

    @PostMapping("/add")
    @ApiOperation("添加设备信息")
    public Result addDeviceInfo(@Validated @RequestBody DeviceInfo deviceInfo){
        Result result = new Result();
        boolean isSuccess = deviceInfoService.add(deviceInfo);
        if (isSuccess){
            result.setMessage("添加设备信息成功");
        }else {
            result.setMessage("添加设备信息失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除设备信息")
    public Result deleteDeviceInfo(Integer id){
        Result result = new Result();
        boolean isSuccess = deviceInfoService.delete(id);
        if (isSuccess){
            result.setMessage("删除设备信息成功");
        }else {
            result.setMessage("删除设备信息失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改设备信息")
    public Result updateDeviceInfo(@RequestBody DeviceInfo deviceInfo){
        Result result = new Result();
        boolean isSuccess = deviceInfoService.update(deviceInfo);
        if (isSuccess){
            result.setMessage("修改设备信息成功");
        }else {
            result.setMessage("修改设备信息失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询设备信息",notes = "根据农事活动id查询设备信息")
    public Result<List<DeviceInfo>> getDeviceInfoList(Integer farmingId){
        Result<List<DeviceInfo>> result = new Result<>();
        result.setSuccessResult(deviceInfoService.selectByFarmingId(farmingId));
        return result;
    }

}
