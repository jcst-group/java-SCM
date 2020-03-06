package com.nongxin.terminal.service.traceability.impl;

import com.nongxin.terminal.dao.traceability.TraceRecordMapper;
import com.nongxin.terminal.entity.traceability.TraceRecord;
import com.nongxin.terminal.service.traceability.TraceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraceRecordServiceImpl implements TraceRecordService {

    @Autowired(required = false)
    private TraceRecordMapper dao;

    @Override
    public boolean insert(TraceRecord traceRecord) {
        return dao.insert(traceRecord) == 1;
    }
}
