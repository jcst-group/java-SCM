package com.nongxin.terminal.service.traceability.impl;

import com.nongxin.terminal.dao.traceability.TraceAreaCountMapper;
import com.nongxin.terminal.entity.traceability.TraceAreaCount;
import com.nongxin.terminal.service.traceability.TraceAreaCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraceAreaCountServiceImpl implements TraceAreaCountService {

    @Autowired(required = false)
    private TraceAreaCountMapper dao;

    @Override
    public boolean isExist(String retroCode, String cityId) {
        return dao.getCountByCityId(retroCode,cityId) >0 ? true : false;
    }

    @Override
    public boolean insert(TraceAreaCount traceAreaCount) {
        return dao.insert(traceAreaCount) == 1;
    }

    @Override
    public boolean updateCount(String retroCode, String cityId) {
        return dao.updateCount(retroCode,cityId) == 1;
    }

    @Override
    public List<TraceAreaCount> getByRetroCode(String retroCode) {
        return dao.getAreaCountByRetroCode(retroCode);
    }
}
