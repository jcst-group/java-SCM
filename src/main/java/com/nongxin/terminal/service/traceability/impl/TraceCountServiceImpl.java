package com.nongxin.terminal.service.traceability.impl;

import com.nongxin.terminal.dao.traceability.TraceCountMapper;
import com.nongxin.terminal.entity.traceability.TraceCount;
import com.nongxin.terminal.service.traceability.TraceCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraceCountServiceImpl implements TraceCountService {

    @Autowired
    private TraceCountMapper dao;

    @Override
    public boolean insert(String retroCode) {
        return dao.insert(retroCode) == 1;
    }

    @Override
    public boolean updateCount(String retroCode) {
        return dao.updateCount(retroCode) == 1;
    }

    @Override
    public boolean isExist(String retroCode) {
        return dao.getCountByRetroCode(retroCode) >0 ? true : false;
    }

    @Override
    public TraceCount getTotalByRetroCode(String retroCode) {
        return dao.getTotalByRetroCode(retroCode);
    }
}
