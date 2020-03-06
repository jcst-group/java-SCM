package com.nongxin.terminal.service.recovery.impl;

import com.nongxin.terminal.dao.batch.SeedBatchMapper;
import com.nongxin.terminal.dao.crop.HarvestedProductMapper;
import com.nongxin.terminal.dao.recovery.RecoveryBatchMapper;
import com.nongxin.terminal.dao.recovery.RecoveryLotMapper;
import com.nongxin.terminal.entity.batch.SeedBatch;
import com.nongxin.terminal.entity.crop.HarvestedProduct;
import com.nongxin.terminal.entity.recovery.RecoveryBatch;
import com.nongxin.terminal.entity.recovery.RecoveryLot;
import com.nongxin.terminal.service.recovery.RecoveryBatchService;
import com.nongxin.terminal.util.CodeUtil;
import com.nongxin.terminal.util.enumUtil.common.CodeEnum;
import com.nongxin.terminal.util.enumUtil.crop.HarvestedTypeEnum;
import com.nongxin.terminal.util.enumUtil.seed.SeedTypeEnum;
import com.nongxin.terminal.util.enumUtil.seed.SelfSpeciesEnum;
import com.nongxin.terminal.vo.recovery.BaseRecoveryVo;
import com.nongxin.terminal.vo.recovery.RecoveryVo;
import com.nongxin.terminal.vo.recovery.RetroRecovery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class RecoveryBatchServiceImpl implements RecoveryBatchService {

    @Autowired(required = false)
    private RecoveryBatchMapper recoveryBatchMapper;
    @Autowired(required = false)
    private RecoveryLotMapper recoveryLotMapper;
    @Autowired(required = false)
    private HarvestedProductMapper harvestedProductMapper;
    @Autowired(required = false)
    private SeedBatchMapper seedBatchMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(RecoveryBatch recoveryBatch) {
        try {
            recoveryBatchMapper.insertSelective(recoveryBatch);
            HarvestedProduct harvestedProduct = harvestedProductMapper.selectByPrimaryKey(recoveryBatch.getHarvestedId());
            if (harvestedProduct.getType() == HarvestedTypeEnum.SEEDLING){
                SeedBatch seedBatch = new SeedBatch();
                seedBatch.setType(SeedTypeEnum.SEEDLING);
                seedBatch.setSelfSpecies(SelfSpeciesEnum.YES);
                seedBatch.setSeedCode(CodeUtil.getCode(CodeEnum.SEED));
                seedBatch.setCropId(recoveryBatch.getCropId());
                seedBatch.setSupplier("四川代代为本农业科技有限公司");
                seedBatch.setRegistrationTime(new Date());
                seedBatch.setRecoveryId(recoveryBatch.getId());
                seedBatchMapper.insertSelective(seedBatch);
            }
            for (RecoveryLot recoveryLot : recoveryBatch.getRecoveryLotList()) {
                recoveryLot.setRecoveryBatchId(recoveryBatch.getId());
                recoveryLotMapper.insertSelective(recoveryLot);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return recoveryBatchMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(RecoveryBatch recoveryBatch) {
        try {
            for (RecoveryLot recoveryLot : recoveryBatch.getRecoveryLotList()) {
                recoveryLot.setUnit(recoveryBatch.getUnit());
                recoveryLotMapper.updateByPrimaryKeySelective(recoveryLot);
            }
            recoveryBatchMapper.updateByPrimaryKeySelective(recoveryBatch);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<RecoveryBatch> getRecoveryBatch(Integer batchId, Date startTime, Date endTime) {
        return recoveryBatchMapper.getRecoveryBatch(batchId,startTime,endTime);
    }

    @Override
    public List<RecoveryVo> getRecoveryVo(Integer batchId) {
        return recoveryBatchMapper.getRecoveryVo(batchId);
    }

    @Override
    public List<Map<String,Object>> getRecoveryByCropId(Integer cropId, String condition) {
        return recoveryBatchMapper.getRecoveryByCropId(cropId,condition);
    }

    @Override
    public List<BaseRecoveryVo> getRecoveryByPlanId(Integer planId, Integer harvestId,Integer baseId,String batchName) {
        return recoveryBatchMapper.getRecoveryByPlanId(planId,harvestId,baseId,batchName);
    }

    @Override
    public RetroRecovery getRecoveryByRetroCode(String retroCode) {
        return recoveryBatchMapper.getRecoveryByRetroCode(retroCode);
    }

    @Override
    public List<Map<String, Object>> getAllRecovery(String recoveryCode,String batchName) {
        return recoveryBatchMapper.getAllRecovery(recoveryCode,batchName);
    }
}
