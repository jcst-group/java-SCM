package com.nongxin.terminal.service.plan.impl;

import com.nongxin.terminal.dao.plant.PersonnelInfoMapper;
import com.nongxin.terminal.entity.plant.PersonnelInfo;
import com.nongxin.terminal.service.plan.PersonnelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelInfoServiceImpl implements PersonnelInfoService {

    @Autowired(required = false)
    private PersonnelInfoMapper personnelInfoMapper;


    @Override
    public boolean add(PersonnelInfo personnelInfo) {
        return personnelInfoMapper.insertSelective(personnelInfo)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return personnelInfoMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(PersonnelInfo personnelInfo) {
        return personnelInfoMapper.updateByPrimaryKeySelective(personnelInfo)==1;
    }

    @Override
    public List<PersonnelInfo> selectByFarmingId(Integer farmingId) {
        return personnelInfoMapper.selectByFarmingId(farmingId);
    }
}
