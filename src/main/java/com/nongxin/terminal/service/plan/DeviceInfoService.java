package com.nongxin.terminal.service.plan;

import com.nongxin.terminal.entity.plant.DeviceInfo;
import com.nongxin.terminal.entity.plant.Farming;

import java.util.List;

public interface DeviceInfoService {

    boolean add(DeviceInfo deviceInfo);

    boolean delete(Integer id);

    boolean update(DeviceInfo deviceInfo);

    List<DeviceInfo> selectByFarmingId(Integer farmingId);

}
