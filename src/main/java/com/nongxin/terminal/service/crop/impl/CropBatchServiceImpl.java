package com.nongxin.terminal.service.crop.impl;

import com.nongxin.terminal.dao.base.LotMapper;
import com.nongxin.terminal.dao.crop.BatchLotRelMapper;
import com.nongxin.terminal.dao.crop.CropBatchMapper;
import com.nongxin.terminal.dao.plant.FarmingMapper;
import com.nongxin.terminal.dao.plant.PlanYearMapper;
import com.nongxin.terminal.dao.plant.PlantingPlanMapper;
import com.nongxin.terminal.entity.base.Lot;
import com.nongxin.terminal.entity.crop.BatchLotRel;
import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.entity.plant.Farming;
import com.nongxin.terminal.entity.plant.PlantingPlan;
import com.nongxin.terminal.service.crop.CropBatchService;
import com.nongxin.terminal.util.enumUtil.crop.BatchStatusEnum;
import com.nongxin.terminal.util.enumUtil.plan.FarmingTypeEnum;
import com.nongxin.terminal.util.solar.SolarTerms;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.batch.BatchVo;
import com.nongxin.terminal.vo.workorder.BusinessReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CropBatchServiceImpl implements CropBatchService {

    @Autowired(required = false)
    private CropBatchMapper cropBatchMapper;
    @Autowired(required = false)
    private FarmingMapper farmingMapper;
    @Autowired(required = false)
    private BatchLotRelMapper batchLotRelMapper;
    @Autowired(required = false)
    private PlantingPlanMapper plantingPlanMapper;
    @Autowired(required = false)
    private LotMapper lotMapper;
    @Autowired(required = false)
    private PlanYearMapper planYearMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result add(CropBatch cropBatch) {
        Result result = new Result();
        boolean isSuccess = true;
        List<Lot> lotList = cropBatch.getLotList();

        List<Lot> batchLotList = lotMapper.selectByBaseIdAndYear(cropBatch.getBaseId(),cropBatch.getStartYear().intValue(),null);
        StringBuffer sb = new StringBuffer();
        if (batchLotList != null){
            for (Lot lot : batchLotList) {
                for (Lot lot1 : lotList){
                    if (lot.getId()==lot1.getId()){
                        isSuccess = false;
                        sb.append(lot.getLotName()+"、");
                    }
                }
            }
        }
        if (!isSuccess){
            if (sb.lastIndexOf("、") != -1){
                result.setMessage("当前年份"+sb.substring(0,sb.lastIndexOf("、"))+"已被使用，不可选择！！");
            }else {
                result.setMessage("当前年份"+sb.toString()+"已被使用，不可选择！！");
            }
            result.setSuccess(false);
            return result;
        }

        Integer plantingId = cropBatch.getPlanId();
        PlantingPlan plantingPlan = plantingPlanMapper.selectByPrimaryKey(plantingId);
        cropBatch.setCropId(plantingPlan.getCropId());
        //计算批次开始时间
        Farming firstFarming = farmingMapper.getFirstByPlantingId(plantingId);
        LocalDate startTime = SolarTerms.getSolarTermNum(cropBatch.getStartYear(),firstFarming.getSolarTerm());
        startTime = startTime.plusDays((firstFarming.getHou().getValue()-1)*5);
        ChronoZonedDateTime<LocalDate> startDateTime = startTime.atStartOfDay(ZoneId.systemDefault());
        cropBatch.setStartTime(Date.from(startDateTime.toInstant()));
        //计算批次结束时间
        Farming lastFarming = farmingMapper.getLastByPlantingId(plantingId);
        Integer lastYear = planYearMapper.getLastYearByPlanId(plantingId);
        LocalDate endTime = SolarTerms.getSolarTermNum(cropBatch.getStartYear()+lastYear-1,lastFarming.getSolarTerm());
        endTime = endTime.plusDays((lastFarming.getHou().getValue()-1)*5+lastFarming.getFarmingCycle());
        ChronoZonedDateTime<LocalDate> endDateTime = endTime.atStartOfDay(ZoneId.systemDefault());
        cropBatch.setEndTime(Date.from(endDateTime.toInstant()));
        try {
            cropBatchMapper.insertSelective(cropBatch);
            //添加批次对应地块
            for (Lot lot : lotList){
                BatchLotRel batchLotRel = new BatchLotRel();
                batchLotRel.setCropBatchId(cropBatch.getId());
                batchLotRel.setLotId(lot.getId());
                batchLotRelMapper.insertSelective(batchLotRel);
            }
            result.setSuccess(true);
            result.setMessage("添加种植批次成功");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        result.setSuccess(false);
        result.setMessage("添加种植批次失败");
        return result;
    }

    @Override
    public Result delete(Integer id) {
        Result result = new Result();
        List<Farming> farmingList = farmingMapper.getTemporaryByBatchId(id, FarmingTypeEnum.TEMPORARY);
        if (farmingList != null && !farmingList.isEmpty()){
            result.setMessage("该批次已创建临时工单，无法删除！！");
            result.setSuccess(false);
            return result;
        }
        boolean isSuccess = cropBatchMapper.deleteByPrimaryKey(id)==1;
        if (isSuccess){
            result.setMessage("删除批次成功");
        }else {
            result.setMessage("删除批次失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result update(CropBatch cropBatch) {
        Result result = new Result();
        try {
            List<Lot> lotList = cropBatch.getLotList();
            List<Lot> batchLotList = lotMapper.selectByBaseIdAndYear(cropBatch.getBaseId(),cropBatch.getStartYear().intValue(),cropBatch.getId());
            StringBuffer sb = new StringBuffer();
            boolean isSuccess = true;
            if (batchLotList != null){
                for (Lot lot : batchLotList) {
                    for (Lot lot1 : lotList){
                        if (lot.getId()==lot1.getId()){
                            isSuccess = false;
                            sb.append(lot.getLotName()+"、");
                        }
                    }
                }
            }
            if (!isSuccess){
                if (sb.lastIndexOf("、") != -1){
                    result.setMessage("当前年份"+sb.substring(0,sb.lastIndexOf("、"))+"已被使用，不可选择！！");
                }else {
                    result.setMessage("当前年份"+sb.toString()+"已被使用，不可选择！！");
                }
                result.setSuccess(false);
                return result;
            }

            if (lotList != null && !lotList.isEmpty()){
                //先删除，再添加
                batchLotRelMapper.deleteByBatchId(cropBatch.getId());
                for (Lot lot : cropBatch.getLotList()){
                    BatchLotRel batchLotRel = new BatchLotRel();
                    batchLotRel.setCropBatchId(cropBatch.getId());
                    batchLotRel.setLotId(lot.getId());
                    batchLotRelMapper.insertSelective(batchLotRel);
                }
            }
            Integer plantingId = cropBatch.getPlanId();
            //计算批次开始时间
            Farming firstFarming = farmingMapper.getFirstByPlantingId(plantingId);
            LocalDate startTime = SolarTerms.getSolarTermNum(cropBatch.getStartYear(),firstFarming.getSolarTerm());
            startTime = startTime.plusDays((firstFarming.getHou().getValue()-1)*5);
            ChronoZonedDateTime<LocalDate> startDateTime = startTime.atStartOfDay(ZoneId.systemDefault());
            cropBatch.setStartTime(Date.from(startDateTime.toInstant()));
            //计算批次结束时间
            Farming lastFarming = farmingMapper.getLastByPlantingId(plantingId);
            Integer lastYear = planYearMapper.getLastYearByPlanId(plantingId);
            LocalDate endTime = SolarTerms.getSolarTermNum(cropBatch.getStartYear()+lastYear-1,lastFarming.getSolarTerm());
            endTime = endTime.plusDays((lastFarming.getHou().getValue()-1)*5+lastFarming.getFarmingCycle());
            ChronoZonedDateTime<LocalDate> endDateTime = endTime.atStartOfDay(ZoneId.systemDefault());
            cropBatch.setEndTime(Date.from(endDateTime.toInstant()));
            cropBatchMapper.updateByPrimaryKeySelective(cropBatch);
            result.setSuccess(true);
            result.setMessage("修改种植批次成功");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        result.setSuccess(false);
        result.setMessage("修改种植批次失败");
        return result;
    }

    @Override
    public List<CropBatch> getCropBatchList(CropBatch cropBatch) {
        return cropBatchMapper.getCropBatchList(cropBatch);
    }

    @Override
    public List<CropBatch> getAllCropBatch(Integer baseId,Integer planId,String batchName) {
        return cropBatchMapper.getAllCropBatch(baseId,planId,batchName);
    }

    @Override
    public CropBatch selectByPrimaryKey(Integer id) {
        return cropBatchMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateStatus(Integer id, BatchStatusEnum statusEnum) {
        return cropBatchMapper.updateStatus(id,statusEnum)==1;
    }

    @Override
    public List<BatchVo> getBatchVo(Integer farming,String batchName,BatchStatusEnum status,Integer planId,String isEstablish) {
        return cropBatchMapper.getBatchVo(farming,batchName,status,planId,isEstablish);
    }

    @Override
    public List<CropBatch> getBatchByPlanId(Integer planId, Integer startYear) {
        return cropBatchMapper.getBatchByPlanId(planId,startYear);
    }

    @Override
    public List<BusinessReportVo> getBusinessReport(CropBatch batch) {
        return cropBatchMapper.getBusinessReport(batch);
    }

    @Override
    public List<CropBatch> getBatchByUid(Integer uid) {
        return cropBatchMapper.getBatchByUid(uid);
    }

    @Override
    public List<Map<String, Object>> selectByBaseId(Integer baseId) {
        return cropBatchMapper.selectByBaseId(baseId);
    }

    @Override
    public List<CropBatch> getBatchAndRecovery(Integer batchId, Date startTime, Date endTime) {
        return cropBatchMapper.getBatchAndRecovery(batchId,startTime,endTime);
    }

}
