package com.nongxin.terminal.service.crop;

import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.util.enumUtil.crop.BatchStatusEnum;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.batch.BatchVo;
import com.nongxin.terminal.vo.workorder.BusinessReportVo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CropBatchService {

    Result add(CropBatch cropBatch);

    Result delete(Integer id);

    Result update(CropBatch cropBatch);

    List<CropBatch> getCropBatchList(CropBatch cropBatch);

    List<CropBatch> getAllCropBatch(Integer baseId,Integer planId,String batchName);

    CropBatch selectByPrimaryKey(Integer id);

    boolean updateStatus(Integer id, BatchStatusEnum statusEnum);

    //查询批次是否对某条临时农事创建临时工单
    List<BatchVo> getBatchVo(Integer farming,String batchName,BatchStatusEnum status,Integer planId,String isEstablish);

    //根据种植计划查询批次
    List<CropBatch> getBatchByPlanId(Integer planId,Integer startYear);

    //查询批次经营报表
    List<BusinessReportVo> getBusinessReport(CropBatch batch);

    //app端，根据用户id查询批次
    List<CropBatch> getBatchByUid(Integer uid);

    //根据基地查询批次id和name
    List<Map<String,Object>> selectByBaseId(Integer baseId);

    //查询采收批次（合并同一种植批次的采收批次）
    List<CropBatch> getBatchAndRecovery(Integer batchId,Date startTime, Date endTime);

}
