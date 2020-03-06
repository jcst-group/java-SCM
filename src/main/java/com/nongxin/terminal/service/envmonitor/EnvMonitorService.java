package com.nongxin.terminal.service.envmonitor;

import com.nongxin.terminal.entity.envmonitor.EnvMonitor;

import java.util.Date;
import java.util.List;

public interface EnvMonitorService {

    boolean delete(Integer id);

    List<EnvMonitor> getEnvMonitorList(Integer equipmentId,Integer baseId, Date startTime, Date endTime);

    List<EnvMonitor> getEnvChart(Integer equipmentId,Integer baseId, Date startTime,Date endTime);
    //App环控中心
    List<EnvMonitor> getTodayEnv(Integer baseId);
}
