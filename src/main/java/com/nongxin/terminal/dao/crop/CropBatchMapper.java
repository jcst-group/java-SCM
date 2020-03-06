package com.nongxin.terminal.dao.crop;

import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.util.enumUtil.crop.BatchStatusEnum;
import com.nongxin.terminal.vo.batch.BatchVo;
import com.nongxin.terminal.vo.workorder.BusinessReportVo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CropBatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CropBatch record);

    int insertSelective(CropBatch record);

    CropBatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CropBatch record);

    int updateByPrimaryKey(CropBatch record);

    List<CropBatch> getCropBatchList(CropBatch cropBatch);

    List<CropBatch> getAllCropBatch(@Param("baseId") Integer baseId,@Param("planId") Integer planId,@Param("batchName")String batchName);

    int updateStatus(@Param("id") Integer id, @Param("status") BatchStatusEnum status);

    CropBatch getIdAndNameById(Integer id);

    List<BatchVo> getBatchVo(@Param("farming") Integer farming,@Param("batchName") String batchName,
                             @Param("status")BatchStatusEnum status,@Param("planId")Integer planId,@Param("isEstablish")String isEstablish);

    List<CropBatch> getBatchByPlanId(@Param("planId") Integer planId,@Param("startYear")Integer startYear);

    List<CropBatch> getBatchByBaseId(Integer baseId);

    //查询批次经营报表
    List<BusinessReportVo> getBusinessReport(CropBatch batch);

    List<CropBatch> getBatchByUid(Integer uid);

    List<Map<String,Object>> selectByBaseId(Integer baseId);

    CropBatch selectByRecoveryId(Integer recoveryId);

    List<CropBatch> getBatchAndRecovery(@Param("batchId")Integer batchId, @Param("startTime") Date startTime, @Param("endTime")Date endTime);
}