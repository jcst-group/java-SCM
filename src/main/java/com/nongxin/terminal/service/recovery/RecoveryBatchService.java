package com.nongxin.terminal.service.recovery;

import com.nongxin.terminal.entity.recovery.RecoveryBatch;
import com.nongxin.terminal.vo.recovery.BaseRecoveryVo;
import com.nongxin.terminal.vo.recovery.RecoveryVo;
import com.nongxin.terminal.vo.recovery.RetroRecovery;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface RecoveryBatchService {

    boolean add(RecoveryBatch recoveryBatch);

    boolean delete(Integer id);

    boolean update(RecoveryBatch recoveryBatch);

    List<RecoveryBatch> getRecoveryBatch(Integer batchId,Date startTime,Date endTime);

    List<RecoveryVo> getRecoveryVo(Integer batchId);

    List<Map<String,Object>> getRecoveryByCropId(Integer cropId, String condition);

    List<BaseRecoveryVo> getRecoveryByPlanId(Integer planId,Integer harvestId,Integer baseId,String batchName);

    //根据追溯码查询采收批次
    RetroRecovery getRecoveryByRetroCode(String retroCode);

    //获取所有采收批次
    List<Map<String,Object>> getAllRecovery(String recoveryCode,String batchName);

}
