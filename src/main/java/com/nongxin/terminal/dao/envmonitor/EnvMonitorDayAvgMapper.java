package com.nongxin.terminal.dao.envmonitor;

import com.nongxin.terminal.entity.envmonitor.EnvMonitor;
import com.nongxin.terminal.entity.envmonitor.EnvMonitorDayAvg;
import com.nongxin.terminal.vo.app.EnvDayAvg;

import java.util.List;

public interface EnvMonitorDayAvgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvMonitorDayAvg record);

    int insertSelective(EnvMonitorDayAvg record);

    EnvMonitorDayAvg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvMonitorDayAvg record);

    int updateByPrimaryKey(EnvMonitorDayAvg record);

    //App环控中心--获取本周监测数据
    List<EnvMonitor> getWeekEnv(Integer baseId);

    //获取本月监测数据
    List<EnvMonitor> getMonthEnv(Integer baseId);
}