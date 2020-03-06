package com.nongxin.terminal.service.envmonitor.impl;

import com.nongxin.terminal.dao.envmonitor.EnvMonitorMapper;
import com.nongxin.terminal.entity.envmonitor.EnvMonitor;
import com.nongxin.terminal.service.envmonitor.EnvMonitorService;
import com.nongxin.terminal.vo.QueryParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EnvMonitorServiceImpl implements EnvMonitorService {

    @Autowired
    private EnvMonitorMapper dao;

    @Override
    public boolean delete(Integer id) {
        return dao.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public List<EnvMonitor> getEnvMonitorList(Integer equipmentId,Integer baseId, Date startTime, Date endTime) {
        return dao.getEnvMonitorList(equipmentId,baseId,startTime,endTime);
    }

    @Override
    public List<EnvMonitor> getEnvChart(Integer equipmentId, Integer baseId, Date startTime, Date endTime) {
        return dao.getEnvChart(equipmentId,baseId,startTime,endTime);
    }


    @Override
    public List<EnvMonitor> getTodayEnv(Integer baseId) {
        return dao.getTodayEnv(baseId);
    }
}
