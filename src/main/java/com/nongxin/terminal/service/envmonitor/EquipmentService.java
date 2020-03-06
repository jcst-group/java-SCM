package com.nongxin.terminal.service.envmonitor;

import com.nongxin.terminal.entity.envmonitor.Equipment;

import java.util.List;

public interface EquipmentService {

    boolean insertSelective(Equipment record);

    boolean deleteByPrimaryKey(Integer id);

    Equipment selectByPrimaryKey(Integer id);

    boolean updateByPrimaryKeySelective(Equipment record);

    List<Equipment> getEquipmentList(Equipment equipment);

    List<Equipment> getEquipmentIdAndNameList();

    Equipment checkId(String equipmentId,String equipmentName);

    String getEquipmentName(Integer id);
}
