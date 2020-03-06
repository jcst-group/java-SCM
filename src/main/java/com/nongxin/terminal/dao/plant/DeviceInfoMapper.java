package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.DeviceInfo;

import java.util.List;

public interface DeviceInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeviceInfo record);

    int insertSelective(DeviceInfo record);

    DeviceInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeviceInfo record);

    int updateByPrimaryKey(DeviceInfo record);

    List<DeviceInfo> selectByFarmingId(Integer farmingId);
}