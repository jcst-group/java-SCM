package com.nongxin.terminal.dao.recovery;

import com.nongxin.terminal.entity.recovery.RecoveryBatch;
import com.nongxin.terminal.vo.recovery.BaseRecoveryVo;
import com.nongxin.terminal.vo.recovery.RecoveryVo;
import com.nongxin.terminal.vo.recovery.RetroRecovery;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface RecoveryBatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RecoveryBatch record);

    int insertSelective(RecoveryBatch record);

    RecoveryBatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RecoveryBatch record);

    int updateByPrimaryKey(RecoveryBatch record);

    List<RecoveryBatch> getRecoveryBatch(@Param("batchId")Integer batchId, @Param("startTime")Date startTime,@Param("endTime")Date endTime);

    List<RecoveryVo> getRecoveryVo(Integer batchId);

    List<Map<String,Object>> getRecoveryByCropId(@Param("cropId") Integer cropId,@Param("condition") String condition);

    List<BaseRecoveryVo> getRecoveryByPlanId(@Param("planId") Integer planId, @Param("harvestId")Integer harvestId,
                                             @Param("baseId")Integer baseId,@Param("batchName")String batchName);

    List<BaseRecoveryVo> getRecoveryByInitialProId(@Param("initialProId") Integer initialProId);

    List<BaseRecoveryVo> getRecoveryByRecDet(@Param("recDetId") Integer recDetId);

    //看板:由种植批次获得采收批次id
    List<RecoveryBatch> getRecovertBatchId(Integer cropBatchId);

    Map<String,Object> getProvenanceById(Integer id);

    //查询采收批次，若剩余产量为0，则不展示
    List<Map<String, Object>> getRecoveryByOutput(@Param("condition") String condition);

    //根据追溯码查询采收批次
    RetroRecovery getRecoveryByRetroCode(String retroCode);

    List<RecoveryBatch> selectByBatchId(Integer batchId);

    List<Map<String,Object>> getAllRecovery(@Param("recoveryCode") String recoveryCode,@Param("batchName")String batchName);
}