package com.nongxin.terminal.service.envmonitor.impl;

import com.nongxin.terminal.dao.envmonitor.EquipmentMapper;
import com.nongxin.terminal.entity.envmonitor.Equipment;
import com.nongxin.terminal.service.envmonitor.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentMapper dao;

    @Override
    public boolean insertSelective(Equipment record) {
        return dao.insertSelective(record) == 1 ;
    }

    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public Equipment selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateByPrimaryKeySelective(Equipment record) {
        return dao.updateByPrimaryKeySelective(record) ==1;
    }

    @Override
    public List<Equipment> getEquipmentList(Equipment equipment) {
        return dao.getEquipmentList(equipment);
    }

    @Override
    public List<Equipment> getEquipmentIdAndNameList() {
        return dao.getEquipmentIdAndNameList();
    }

    @Override
    public Equipment checkId(String equipmentId, String equipmentName) {
        return dao.checkId(equipmentId,equipmentName);
    }

    @Override
    public String getEquipmentName(Integer id) {
        return dao.getEquipmentName(id);
    }
}
