package com.nongxin.terminal.dao.batch;

import com.nongxin.terminal.entity.batch.ProBatchMethodRel;

import java.util.List;

public interface ProBatchMethodRelMapper {
    int insert(ProBatchMethodRel record);

    int insertSelective(ProBatchMethodRel record);

    int deleteByProBatchId(Integer proBatchId);

    List<Integer> selectByinitproBatchId(Integer initproBatchId);
}