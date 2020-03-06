package com.nongxin.terminal.service.envmonitor;

import com.nongxin.terminal.entity.envmonitor.WarnEnv;

import java.util.List;

public interface WarnEnvService {

    boolean insertSelective(WarnEnv record);

    boolean updateByPrimaryKeySelective(WarnEnv record);

    boolean deleteByPrimaryKey(Integer id);

    List<WarnEnv> getWarnEnvList();

    WarnEnv getWarnEnvByEquipmentId(Integer equipmentId);

    boolean updateStatus(Integer id,Integer status);

    boolean updateByEquipmentId(WarnEnv warnEnv);
}
