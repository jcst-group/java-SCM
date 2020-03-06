package com.nongxin.terminal.service.envmonitor.impl;

import com.nongxin.terminal.dao.envmonitor.EnvMonitorDayAvgMapper;
import com.nongxin.terminal.entity.envmonitor.EnvMonitor;
import com.nongxin.terminal.service.envmonitor.EnvDayAvgService;
import com.nongxin.terminal.vo.app.EnvDayAvg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvDayAvgServiceImpl implements EnvDayAvgService {

    @Autowired
    private EnvMonitorDayAvgMapper dao;

    @Override
    public List<EnvMonitor> getWeekEnv(Integer baseId) {
        return dao.getWeekEnv(baseId);
    }

    @Override
    public List<EnvMonitor> getMonthEnv(Integer baseId) {
        return dao.getMonthEnv(baseId);
    }
}
