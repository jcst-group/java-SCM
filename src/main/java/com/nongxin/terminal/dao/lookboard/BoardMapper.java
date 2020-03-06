package com.nongxin.terminal.dao.lookboard;

import com.nongxin.terminal.vo.lookboard.CropBatchVo;
import com.nongxin.terminal.vo.lookboard.DetectionValueVo;
import com.nongxin.terminal.vo.lookboard.RecoveryDataVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BoardMapper {

    List<DetectionValueVo> getDetectionValue(@Param("batchId") Integer batchId, @Param("typeId") Integer typeId);

    List<DetectionValueVo> getDetectionValue1(@Param("lotId") Integer lotId, @Param("typeId") Integer typeId);

    List<RecoveryDataVo> getRecoveryData(@Param("lotId") Integer lotId);

    List<CropBatchVo> getCropBatch(Integer lotId);
}