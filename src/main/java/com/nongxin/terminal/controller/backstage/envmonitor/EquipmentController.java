package com.nongxin.terminal.controller.backstage.envmonitor;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.envmonitor.Equipment;
import com.nongxin.terminal.mqtt.MqttBasicAuth;
import com.nongxin.terminal.service.envmonitor.EquipmentService;
import com.nongxin.terminal.service.system.ConstantStorageService;
import com.nongxin.terminal.util.enumUtil.system.ConstantTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EquipmentController.class);

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private MqttBasicAuth mqttBasicAuth;
    @Autowired
    private ConstantStorageService storageService;

    @PostMapping("/insert")
    @ApiOperation(value = "新增监测设备", notes = "POST新增一个监测设备")
    public Result<Equipment> insertEquipment(@Validated @RequestBody Equipment equipment) {
        Result<Equipment> result = new Result<>();
        boolean isInsertSuccess = equipmentService.insertSelective(equipment);
        if (isInsertSuccess == true) {
            result.setMessage("新增设备成功");
        } else {
            result.setMessage("新增设备失败");
        }
        result.setSuccess(isInsertSuccess);
        return result;
    }

    @GetMapping("/checkId")
    @ApiOperation(value = "检查监测设备编号是否存在")
    public Result check(String equipmentId,String equipmentName){
        Result result = new Result();
        if(equipmentService.checkId(equipmentId,equipmentName)!=null){
            if(equipmentId!=null){
                result.setMessage("设备编号已存在!");
            }else if(equipmentName!=null){
                result.setMessage("设备名称已存在!");
            }
            result.setSuccess(false);
        }else {
            result.setSuccess(true);
        }
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除监测设备", notes = "POST删除一个监测设备")
    public Result<Equipment> deleteEquipment(@RequestParam Integer id) {
        Result<Equipment> result = new Result<>();
        boolean isDeleteSuccess = equipmentService.deleteByPrimaryKey(id);
        if (isDeleteSuccess == true) {
            result.setMessage("删除设备成功");
        } else {
            result.setMessage("删除设备失败");
        }
        result.setSuccess(isDeleteSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改监测设备", notes = "POST修改一个监测设备")
    public Result<Equipment> updateEquipment(@Validated @RequestBody Equipment equipment) {
        Result<Equipment> result = new Result<>();
        boolean isUpdateSuccess = equipmentService.updateByPrimaryKeySelective(equipment);
        if (isUpdateSuccess) {
            result.setMessage("修改设备成功");
        } else {
            result.setMessage("修改设备失败");
        }
        result.setSuccess(isUpdateSuccess);
        return result;
    }


    @GetMapping("/list")
    @ApiOperation(value = "查询监测设备", notes = "GET分页模糊查询监测设备")
    public Result<PageInfo> getEquipmentList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                             @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                             Equipment equipment) {
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<Equipment> equipmentList = equipmentService.getEquipmentList(equipment);
        PageInfo pageInfo = new PageInfo(equipmentList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getEquipmentIdAndNameList")
    @ApiOperation(value = "查询监测设备", notes = "GET查询监测设备")
    public Result<List<Equipment>> getEquipmentIdAndNameList() {
        Result<List<Equipment>> result = new Result<>();
        List<Equipment> equipmentList = equipmentService.getEquipmentIdAndNameList();
        result.setResult(equipmentList);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getEquipmentStatus")
    @ApiOperation(value = "")
    public Result<String> getStatus(String equipmentId){
        Result<String> result = new Result<>();
        try {
            String response  = mqttBasicAuth.getConnection(equipmentId);
            JSONObject json1 = JSONObject.parseObject(response);
            JSONArray data = json1.getJSONArray("data");
            if(data.size()>0){
                JSONObject json2 = data.getJSONObject(0);
                if(json2.getString("client_id").equals(equipmentId)){
                    result.setMessage("在线");
                    result.setSuccess(true);
                }else {
                    result.setMessage("离线");
                    result.setSuccess(false);
                }
            }else{
                result.setMessage("离线");
                result.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/getBoardUrl")
    @ApiOperation("获取看板地址")
    public Result getBoardUrl(){
        Result result = new Result();
        result.setSuccessResult(storageService.selectByType(ConstantTypeEnum.BOARD_URL));
        return result;
    }

}
