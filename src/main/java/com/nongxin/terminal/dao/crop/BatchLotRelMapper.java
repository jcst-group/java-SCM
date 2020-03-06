package com.nongxin.terminal.dao.crop;

import com.nongxin.terminal.entity.crop.BatchLotRel;

public interface BatchLotRelMapper {
    int insert(BatchLotRel record);

    int insertSelective(BatchLotRel record);

    int deleteByBatchId(Integer batchId);
}