package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.DeviceAct;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DeviceActMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeviceAct record);

    int insertSelective(DeviceAct record);

    DeviceAct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeviceAct record);

    int updateByPrimaryKey(DeviceAct record);

    List<DeviceAct> selectByOrderId(Integer orderId);

    //设备预算费用
    List<DeviceAct> budgetDeviceAct(@Param("batchIds")int[] batchIds,@Param("farmingId")Integer farmingId);

    //设备实际费用
    List<Map<String,Object>> getBusinessDeviceAct(Integer batchId);
}