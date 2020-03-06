package com.nongxin.terminal.dao.batch;

import com.nongxin.terminal.entity.batch.InitproBatchRel;

import java.util.List;

public interface InitproBatchRelMapper {
    int insert(InitproBatchRel record);

    int insertSelective(InitproBatchRel record);

    int deleteByProBatchId(Integer proBatchId);

    List<Integer>  selectByinitproBatchId(Integer initproBatchId);
}