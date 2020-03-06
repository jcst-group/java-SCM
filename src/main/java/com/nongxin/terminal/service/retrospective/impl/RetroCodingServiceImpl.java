package com.nongxin.terminal.service.retrospective.impl;

import com.nongxin.terminal.dao.batch.InitialProBatchMapper;
import com.nongxin.terminal.dao.recovery.RecoveryBatchMapper;
import com.nongxin.terminal.dao.retrospective.RetroCodeInfoMapper;
import com.nongxin.terminal.dao.retrospective.RetroCodingMapper;
import com.nongxin.terminal.dao.retrospective.RetroOutputRelMapper;
import com.nongxin.terminal.entity.batch.InitialProBatch;
import com.nongxin.terminal.entity.recovery.RecoveryBatch;
import com.nongxin.terminal.entity.retrospective.RetroCodeInfo;
import com.nongxin.terminal.entity.retrospective.RetroCoding;
import com.nongxin.terminal.entity.retrospective.RetroOutputRel;
import com.nongxin.terminal.service.retrospective.RetroCodingService;
import com.nongxin.terminal.util.CodeUtil;
import com.nongxin.terminal.util.enumUtil.common.CodeEnum;
import com.nongxin.terminal.util.enumUtil.common.CodingStatusEnum;
import com.nongxin.terminal.util.enumUtil.common.UnitEnum;
import com.nongxin.terminal.util.enumUtil.retrospective.RetroCodingTypeEnum;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.traceability.PictureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RetroCodingServiceImpl implements RetroCodingService {

    @Autowired(required = false)
    private RetroCodingMapper retroCodingMapper;
    @Autowired(required = false)
    private RetroCodeInfoMapper codeInfoMapper;
    @Autowired(required = false)
    private RecoveryBatchMapper recoveryBatchMapper;
    @Autowired(required = false)
    private InitialProBatchMapper initialMapper;
    @Autowired(required = false)
    private RetroOutputRelMapper outputRelMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized Result add(RetroCoding retroCoding) {
        Result result = new Result();
        try {
            //追溯码信息
            RetroCodeInfo codeInfo = retroCoding.getRetroCodeInfo();
            //根据采收批次查询产地和产量
            Map<String,Object> map = recoveryBatchMapper.getProvenanceById(codeInfo.getRecoId());
            //本次打码使用产量
            BigDecimal consumption = codeInfo.getNetWeight().multiply(new BigDecimal(retroCoding.getCodeQuantity())).
                    multiply(new BigDecimal(codeInfo.getUnit().getRadix()));

            RetroOutputRel retroOutputRel = new RetroOutputRel();
            //剩余产量
            BigDecimal residualOutput = retroCoding.getResidualOutput();
            //判断剩余产量是否足够打码
            if(residualOutput.compareTo(consumption) > -1){
                retroOutputRel.setResidualOutput(residualOutput.subtract(consumption));
                retroOutputRel.setRelationType(retroCoding.getRetroCodeInfo().getType());
                if (retroCoding.getRetroCodeInfo().getType()==RetroCodingTypeEnum.RECO_BATCH){
                    retroOutputRel.setRelationId(retroCoding.getRetroCodeInfo().getRecoId());
                    RecoveryBatch recoveryBatch = new RecoveryBatch();
                    recoveryBatch.setId(retroCoding.getRetroCodeInfo().getRecoId());
                    recoveryBatch.setStatus(CodingStatusEnum.CODED);
                    recoveryBatchMapper.updateByPrimaryKeySelective(recoveryBatch);
                }else{
                    InitialProBatch initialProBatch = new InitialProBatch();
                    initialProBatch.setId(retroCoding.getRetroCodeInfo().getInitId());
                    initialProBatch.setStatus(CodingStatusEnum.CODED);
                    initialMapper.updateByPrimaryKeySelective(initialProBatch);
                    retroOutputRel.setRelationId(retroCoding.getRetroCodeInfo().getInitId());
                }
                outputRelMapper.deleteByRelationId(retroOutputRel.getRelationId(),retroOutputRel.getRelationType());
                outputRelMapper.insertSelective(retroOutputRel);
            }else{
                result.setMessage("剩余产量不够，打码失败!!");
                result.setSuccess(false);
                return result;
            }

            //添加追溯码信息
            codeInfo.setProvenance(map.get("provenance").toString());
            codeInfoMapper.insertSelective(codeInfo);

            //添加追溯码
            Integer num = retroCoding.getCodeQuantity();
            retroCoding.setCodeInfoId(codeInfo.getId());
            for (Integer i = 0; i < num; i++) {
                retroCoding.setRetroCode(CodeUtil.getCode(CodeEnum.RETROCODING));
                retroCoding.setSerialNum(i+1);
                retroCodingMapper.insertSelective(retroCoding);
            }
            result.setSuccess(true);
            result.setMessage("添加追溯码成功!!");
            return result;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return result;
    }

    @Override
    public List<RetroCoding> getRetroCoding(RetroCodingTypeEnum type, String relationCode, String retroCode) {
        return retroCodingMapper.getRetroCoding(type,relationCode,retroCode);
    }

    @Override
    public List<Map<String, Object>> getBatchByType(RetroCodingTypeEnum type,String condition) {
        List<Map<String, Object>> list = null;
        if (type == RetroCodingTypeEnum.RECO_BATCH){
            list = recoveryBatchMapper.getRecoveryByOutput(condition);
        }else{
            list = initialMapper.getInitialProByOutput(condition);
        }
        return list;
    }

    @Override
    public Object getResidualOutput(Integer id, RetroCodingTypeEnum type) {
        //查询剩余产量表是否有数据,有就直接使用
        RetroOutputRel retroOutputRel = outputRelMapper.selectByRelationId(id,type);
        if (type == RetroCodingTypeEnum.RECO_BATCH){
            Map<String, Object> map = recoveryBatchMapper.getProvenanceById(id);
            if (retroOutputRel != null){
                map.put("yield",retroOutputRel.getResidualOutput());
            }else{
                BigDecimal yield = ((BigDecimal)map.get("yield")).multiply(new BigDecimal(((UnitEnum)map.get("unit")).getRadix()));
                map.put("yield",yield);
            }
            return map;
        }else{
            InitialProBatch initialProBatch = initialMapper.getResidualOutput(id);
            if (retroOutputRel != null){
                initialProBatch.setYield(retroOutputRel.getResidualOutput());
            }else{
                initialProBatch.setYield(initialProBatch.getYield().multiply(new BigDecimal(initialProBatch.getUnit().getRadix())));
            }
            return initialProBatch;
        }

    }

    @Override
    public PictureVo getRetroPic(String retroCode) {
        return retroCodingMapper.getRetroPic(retroCode);
    }

    @Override
    public List<Map<String, Object>> getRetroByRetroCode(String relationCode,RetroCodingTypeEnum type) {
        return retroCodingMapper.getRetroByRetroCode(relationCode,type);
    }
}
