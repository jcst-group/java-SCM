package com.nongxin.terminal.dao.recovery;

import com.nongxin.terminal.entity.recovery.RecoveryLot;

import java.util.List;

public interface RecoveryLotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecoveryLot record);

    int insertSelective(RecoveryLot record);

    RecoveryLot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecoveryLot record);

    int updateByPrimaryKey(RecoveryLot record);

    List<RecoveryLot> getRecoveryLotByRecoveryBatchId(Integer recoveryBatchId);
}