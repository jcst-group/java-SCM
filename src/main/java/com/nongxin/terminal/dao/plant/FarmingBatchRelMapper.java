package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.FarmingBatchRel;

public interface FarmingBatchRelMapper {
    int insert(FarmingBatchRel record);

    int insertSelective(FarmingBatchRel record);

    int delete(FarmingBatchRel farmingBatchRel);
}