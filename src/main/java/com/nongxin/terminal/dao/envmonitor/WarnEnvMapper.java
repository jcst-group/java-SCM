package com.nongxin.terminal.dao.envmonitor;

import com.nongxin.terminal.entity.envmonitor.WarnEnv;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarnEnvMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WarnEnv record);

    int insertSelective(WarnEnv record);

    WarnEnv selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WarnEnv record);

    int updateByPrimaryKey(WarnEnv record);

    WarnEnv getWarnEnvByEquipmentId(Integer equipmentId);

    List<WarnEnv> getWarnEnvList();

    //根据预警记录的项找出对应的阈值
    WarnEnv getWarnEnvByItem(Integer item);

    int updateStatus(Integer id,Integer status);

    int updateByEquipmentId(WarnEnv warnEnv);
}