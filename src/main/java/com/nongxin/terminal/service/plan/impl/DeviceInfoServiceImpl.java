package com.nongxin.terminal.service.plan.impl;

import com.nongxin.terminal.dao.plant.DeviceInfoMapper;
import com.nongxin.terminal.entity.plant.DeviceInfo;
import com.nongxin.terminal.service.plan.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoService {

    @Autowired(required = false)
    private DeviceInfoMapper deviceInfoMapper;

    @Override
    public boolean add(DeviceInfo deviceInfo) {
        return deviceInfoMapper.insertSelective(deviceInfo)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return deviceInfoMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(DeviceInfo deviceInfo) {
        return deviceInfoMapper.updateByPrimaryKeySelective(deviceInfo)==1;
    }

    @Override
    public List<DeviceInfo> selectByFarmingId(Integer farmingId) {
        return deviceInfoMapper.selectByFarmingId(farmingId);
    }
}
