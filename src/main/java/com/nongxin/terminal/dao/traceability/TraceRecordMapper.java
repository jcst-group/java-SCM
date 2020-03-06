package com.nongxin.terminal.dao.traceability;

import com.nongxin.terminal.entity.traceability.TraceRecord;

public interface TraceRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TraceRecord record);

    int insertSelective(TraceRecord record);

    TraceRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TraceRecord record);

    int updateByPrimaryKey(TraceRecord record);
}