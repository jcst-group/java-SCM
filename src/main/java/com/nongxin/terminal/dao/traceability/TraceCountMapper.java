package com.nongxin.terminal.dao.traceability;

import com.nongxin.terminal.entity.traceability.TraceCount;

public interface TraceCountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(String retroCode);

    int insertSelective(TraceCount record);

    TraceCount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TraceCount record);

    int updateByPrimaryKey(TraceCount record);

    //更新溯源次数
    int updateCount(String retroCode);

    int getCountByRetroCode(String retroCode);

    TraceCount getTotalByRetroCode(String retroCode);
}