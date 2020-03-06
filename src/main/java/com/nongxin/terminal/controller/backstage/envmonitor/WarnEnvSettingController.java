package com.nongxin.terminal.controller.backstage.envmonitor;

import com.nongxin.terminal.entity.envmonitor.Equipment;
import com.nongxin.terminal.entity.envmonitor.WarnEnv;
import com.nongxin.terminal.service.envmonitor.EquipmentService;
import com.nongxin.terminal.service.envmonitor.WarnEnvService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/warnEnv")
public class WarnEnvSettingController {

    @Autowired
    private WarnEnvService warnEnvService;

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/insert")
    @ApiOperation(value = "新增采集设备的预警设置值")
    public Result<WarnEnv> insert(@Validated @RequestBody WarnEnv warnEnv){
        Result<WarnEnv> result = new Result<>();
        boolean isInsertSuccess = true;
        List<String> equipmentName = new ArrayList<>();
        if(warnEnv.getEquipmentIdList()!=null){
            for(Equipment equipment:warnEnv.getEquipmentIdList()){
                if(warnEnvService.getWarnEnvByEquipmentId(Integer.valueOf(equipment.getEquipmentId()))==null){  //不存在该设备的阈值
                    warnEnv.setEquipmentId(Integer.valueOf(equipment.getEquipmentId()));
                    warnEnvService.insertSelective(warnEnv);
                }else{
                    isInsertSuccess = false;
                    equipmentName.add(equipmentService.getEquipmentName(Integer.valueOf(equipment.getEquipmentId())));
                }
            }
        }
        if(isInsertSuccess&&equipmentName.size()==0){
            result.setMessage("设置成功");
        }else{
            result.setMessage("设置失败，设备:"+equipmentName.toString()+" 已存在预警值");
        }
        result.setSuccess(isInsertSuccess);
        return result;
    }

//    @PostMapping("/update")
//    @ApiOperation(value = "修改采集设备的预警设置值")
//    public Result<WarnEnv> update(@Validated @RequestBody WarnEnv warnEnv){
//        Result<WarnEnv> result = new Result<>();
//        boolean isUpdateSuccess = warnEnvService.updateByPrimaryKeySelective(warnEnv);
//        if(isUpdateSuccess){
//            result.setMessage("修改成功");
//        }else{
//            result.setMessage("修改失败");
//        }
//        result.setSuccess(isUpdateSuccess);
//        return result;
//    }

    @PostMapping("/update")
    @ApiOperation(value = "修改采集设备的预警设置值")
    public Result<WarnEnv> update(@Validated @RequestBody WarnEnv warnEnv){
        Result<WarnEnv> result = new Result<>();
        boolean isUpdateSuccess = true;
        List<String> equipmentName = new ArrayList<>();
        for(Equipment equipment:warnEnv.getEquipmentIdList()){
            if(warnEnvService.getWarnEnvByEquipmentId(Integer.valueOf(equipment.getEquipmentId()))==null){  //不存在该设备的阈值
                equipmentName.add(equipmentService.getEquipmentName(Integer.valueOf(equipment.getEquipmentId())));
                isUpdateSuccess = false;
            }else{
                warnEnv.setEquipmentId(Integer.valueOf(equipment.getEquipmentId()));
                warnEnvService.updateByEquipmentId(warnEnv);
            }
        }
        if(isUpdateSuccess){
            result.setMessage("修改成功");
        }else{
            result.setMessage("修改失败,"+equipmentName.toString()+" 无预警设置值");
        }
        result.setSuccess(isUpdateSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除采集设备的预警设置值")
    public Result<WarnEnv> delete(Integer id){
        Result<WarnEnv> result = new Result<>();
        boolean isUpdateSuccess = warnEnvService.deleteByPrimaryKey(id);
        if(isUpdateSuccess){
            result.setMessage("删除成功");
        }else{
            result.setMessage("删除失败");
        }
        result.setSuccess(isUpdateSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取所有设备的预警设置值")
    public Result<List<WarnEnv>> getWarnEnvList(){
        Result<List<WarnEnv>> result = new Result<>();
        List<WarnEnv> list = warnEnvService.getWarnEnvList();
        result.setResult(list);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/updateStatus")
    @ApiOperation(value = "修改设备预警开关状态")
    public Result<String> updateStatus(Integer id,Integer status){
        Result<String> result = new Result<>();
        boolean updateSuccess = warnEnvService.updateStatus(id,status);
        if(updateSuccess){
            result.setMessage("修改状态成功");
        }else{
            result.setMessage("修改状态失败");
        }
        result.setSuccess(updateSuccess);
         return result;
    }
}
