package com.nongxin.terminal.service.testing.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.testing.DetectionRelMapper;
import com.nongxin.terminal.dao.testing.RecDetRelMapper;
import com.nongxin.terminal.dao.testing.RecoveryDetectionMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.testing.*;
import com.nongxin.terminal.service.testing.RecoveryDetectionService;
import com.nongxin.terminal.util.ImgUpload;
import com.nongxin.terminal.util.enumUtil.test.DetectionStageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class RecoveryDetectionServiceImpl implements RecoveryDetectionService {

    @Autowired(required = false)
    private RecoveryDetectionMapper recoveryDetectionMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired(required = false)
    private ImgUpload imgUpload;
    @Autowired(required = false)
    private DetectionRelMapper detectionRelMapper;
    @Autowired(required = false)
    private RecDetRelMapper recDetRelMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(RecoveryDetection recoveryDetection) {
        try {
            recoveryDetectionMapper.insertSelective(recoveryDetection);
            //添加检测数据
            for (DetectionRel detectionRel : recoveryDetection.getDetectionRelList()) {
                detectionRel.setRelationId(recoveryDetection.getId());
                //设置类型为采收检测
                detectionRel.setType(DetectionStageEnum.RECOVERY);
                detectionRelMapper.insertSelective(detectionRel);
            }

            //添加检测图片
            PictureInfo detectionPic = recoveryDetection.getDetectionPic();
            if (detectionPic != null){
                detectionPic.setRelationId(recoveryDetection.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(detectionPic);
            }
            PictureInfo detectionResultPic = recoveryDetection.getDetectionResultPic();
            if (detectionResultPic != null){
                detectionResultPic.setRelationId(recoveryDetection.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(detectionResultPic);
            }

            //添加采收批次
            for (RecDetRel recDetRel : recoveryDetection.getRecDetRelList()) {
                recDetRel.setRecDetectionId(recoveryDetection.getId());
                recDetRelMapper.insertSelective(recDetRel);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        try {
            PictureInfo detectionPic = pictureInfoMapper.getRecDetectionPic(id);
            if (detectionPic != null){
                File file = new File(imgUpload.getPath(detectionPic.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(detectionPic.getId());
            }
            PictureInfo detectionResultPic = pictureInfoMapper.getRecDetectionResultPic(id);
            if (detectionResultPic != null){
                File file = new File(imgUpload.getPath(detectionResultPic.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(detectionResultPic.getId());
            }
            detectionRelMapper.deleteByRelation(id,DetectionStageEnum.RECOVERY);
            return recoveryDetectionMapper.deleteByPrimaryKey(id)==1;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(RecoveryDetection recoveryDetection) {
        try {
            recoveryDetectionMapper.updateByPrimaryKeySelective(recoveryDetection);
            List<DetectionRel> detectionRels = recoveryDetection.getDetectionRelList();
            if (detectionRels != null && !detectionRels.isEmpty()){
                detectionRelMapper.deleteByRelation(recoveryDetection.getId(),DetectionStageEnum.RECOVERY);
                for (DetectionRel detectionRel : detectionRels) {
                    detectionRel.setRelationId(recoveryDetection.getId());
                    //设置类型为采收检测
                    detectionRel.setType(DetectionStageEnum.RECOVERY);
                    detectionRelMapper.insertSelective(detectionRel);
                }
            }

            PictureInfo detectionPic = recoveryDetection.getDetectionPic();
            if (detectionPic != null){
                PictureInfo oldPic = pictureInfoMapper.getRecDetectionPic(recoveryDetection.getId());
                if (oldPic != null){
                    File file = new File(imgUpload.getPath(oldPic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldPic.getId());
                }
                detectionPic.setRelationId(recoveryDetection.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(detectionPic);
            }

            PictureInfo detectionResultPic = recoveryDetection.getDetectionResultPic();
            if (detectionResultPic != null){
                PictureInfo oldPic = pictureInfoMapper.getRecDetectionResultPic(recoveryDetection.getId());
                if (oldPic != null){
                    File file = new File(imgUpload.getPath(oldPic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldPic.getId());
                }
                detectionResultPic.setRelationId(recoveryDetection.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(detectionResultPic);
            }

            List<RecDetRel> recDetRelList = recoveryDetection.getRecDetRelList();
            if (recDetRelList != null && !recDetRelList.isEmpty()){
                recDetRelMapper.deleteByRecDetectionId(recoveryDetection.getId());
                for (RecDetRel recDetRel : recDetRelList) {
                    recDetRel.setRecDetectionId(recoveryDetection.getId());
                    recDetRelMapper.insertSelective(recDetRel);
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<RecoveryDetection> getRecoveryDetection(Integer planId,Date startTime, Date endTime) {
        return recoveryDetectionMapper.getRecoveryDetection(planId,startTime,endTime);
    }
}
