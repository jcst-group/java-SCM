package com.nongxin.terminal.service.envmonitor;

import com.nongxin.terminal.entity.envmonitor.EnvMonitor;
import com.nongxin.terminal.vo.app.EnvDayAvg;

import java.util.List;

public interface EnvDayAvgService {

    //App环控中心--获取本周监测数据
    List<EnvMonitor> getWeekEnv(Integer baseId);

    //获取本月监测数据
    List<EnvMonitor> getMonthEnv(Integer baseId);
}
