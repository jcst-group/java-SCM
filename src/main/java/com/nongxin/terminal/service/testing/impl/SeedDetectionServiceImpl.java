package com.nongxin.terminal.service.testing.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.testing.DetectionRelMapper;
import com.nongxin.terminal.dao.testing.SeedDetectionMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.testing.DetectionRel;
import com.nongxin.terminal.util.enumUtil.test.DetectionStageEnum;
import com.nongxin.terminal.entity.testing.SeedDetection;
import com.nongxin.terminal.service.testing.SeedDetectionService;
import com.nongxin.terminal.util.ImgUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class SeedDetectionServiceImpl implements SeedDetectionService {

    @Autowired(required = false)
    private SeedDetectionMapper seedDetectionMapper;
    @Autowired(required = false)
    private DetectionRelMapper detectionRelMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired(required = false)
    private ImgUpload imgUpload;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(SeedDetection seedDetection) {
        try {
            seedDetectionMapper.insertSelective(seedDetection);
            for (DetectionRel detectionRel : seedDetection.getDetectionRelList()) {
                detectionRel.setRelationId(seedDetection.getId());
                //设置类型为种子检测
                detectionRel.setType(DetectionStageEnum.SEED);
                detectionRelMapper.insertSelective(detectionRel);
            }
            PictureInfo detectionPic = seedDetection.getDetectionPic();
            if (detectionPic != null){
                detectionPic.setRelationId(seedDetection.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(detectionPic);
            }
            PictureInfo detectionResultPic = seedDetection.getDetectionResultPic();
            if (detectionResultPic != null){
                detectionResultPic.setRelationId(seedDetection.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(detectionResultPic);
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
            PictureInfo detectionPic = pictureInfoMapper.getSeedDetectionPic(id);
            if (detectionPic != null){
                File file = new File(imgUpload.getPath(detectionPic.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(detectionPic.getId());
            }
            PictureInfo detectionResultPic = pictureInfoMapper.getSeedDetectionResultPic(id);
            if (detectionResultPic != null){
                File file = new File(imgUpload.getPath(detectionResultPic.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(detectionResultPic.getId());
            }
            detectionRelMapper.deleteByRelation(id,DetectionStageEnum.SEED);
            return seedDetectionMapper.deleteByPrimaryKey(id)==1;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(SeedDetection seedDetection) {
        try {
            seedDetectionMapper.updateByPrimaryKeySelective(seedDetection);
            List<DetectionRel> detectionRels = seedDetection.getDetectionRelList();
            if (detectionRels != null && !detectionRels.isEmpty()){
                detectionRelMapper.deleteByRelation(seedDetection.getId(),DetectionStageEnum.SEED);
                for (DetectionRel detectionRel : detectionRels) {
                    detectionRel.setRelationId(seedDetection.getId());
                    //设置类型为种子检测
                    detectionRel.setType(DetectionStageEnum.SEED);
                    detectionRelMapper.insertSelective(detectionRel);
                }
            }

            PictureInfo detectionPic = seedDetection.getDetectionPic();
            if (detectionPic != null){
                PictureInfo oldPic = pictureInfoMapper.getSeedDetectionPic(seedDetection.getId());
                if (oldPic != null){
                    File file = new File(imgUpload.getPath(oldPic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldPic.getId());
                }
                detectionPic.setRelationId(seedDetection.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(detectionPic);
            }

            PictureInfo detectionResultPic = seedDetection.getDetectionResultPic();
            if (detectionResultPic != null){
                PictureInfo oldPic = pictureInfoMapper.getSeedDetectionResultPic(seedDetection.getId());
                if (oldPic != null){
                    File file = new File(imgUpload.getPath(oldPic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldPic.getId());
                }
                detectionResultPic.setRelationId(seedDetection.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(detectionResultPic);
            }

            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<SeedDetection> getSeedDetection(Date startTime, Date endTime,Integer baseId) {
        return seedDetectionMapper.getSeedDetection(startTime,endTime,baseId);
    }
}
