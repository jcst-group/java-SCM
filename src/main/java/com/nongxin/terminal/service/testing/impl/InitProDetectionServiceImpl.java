package com.nongxin.terminal.service.testing.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.testing.DetectionRelMapper;
import com.nongxin.terminal.dao.testing.InitproDetRelMapper;
import com.nongxin.terminal.dao.testing.InitproDetectionMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.testing.*;
import com.nongxin.terminal.service.testing.InitProDetectionService;
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
public class InitProDetectionServiceImpl implements InitProDetectionService {

    @Autowired(required = false)
    private InitproDetectionMapper initproDetectionMapper;
    @Autowired(required = false)
    private DetectionRelMapper detectionRelMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired(required = false)
    private InitproDetRelMapper initproDetRelMapper;
    @Autowired(required = false)
    private ImgUpload imgUpload;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(InitproDetection initproDetection) {
        try {
            initproDetectionMapper.insertSelective(initproDetection);
            //添加检测数据
            for (DetectionRel detectionRel : initproDetection.getDetectionRelList()) {
                detectionRel.setRelationId(initproDetection.getId());
                //设置类型为初加工检测
                detectionRel.setType(DetectionStageEnum.INIPRO);
                detectionRelMapper.insertSelective(detectionRel);
            }
            //添加检测图片
            PictureInfo detectionPic = initproDetection.getDetectionPic();
            if (detectionPic != null){
                detectionPic.setRelationId(initproDetection.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(detectionPic);
            }
            //添加初加工批次
            for (InitproDetRel initproDetRel : initproDetection.getInitproDetRelList()) {
                initproDetRel.setInitproDetId(initproDetection.getId());
                initproDetRelMapper.insertSelective(initproDetRel);
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
            PictureInfo detectionPic = pictureInfoMapper.getInitProDetectionPic(id);
            if (detectionPic != null){
                File file = new File(imgUpload.getPath(detectionPic.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(detectionPic.getId());
            }
            detectionRelMapper.deleteByRelation(id,DetectionStageEnum.INIPRO);
            return initproDetectionMapper.deleteByPrimaryKey(id)==1;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(InitproDetection initproDetection) {
        try {
            initproDetectionMapper.updateByPrimaryKeySelective(initproDetection);
            List<DetectionRel> detectionRels = initproDetection.getDetectionRelList();
            if (detectionRels != null && !detectionRels.isEmpty()){
                detectionRelMapper.deleteByRelation(initproDetection.getId(),DetectionStageEnum.INIPRO);
                for (DetectionRel detectionRel : detectionRels) {
                    detectionRel.setRelationId(initproDetection.getId());
                    //设置类型为初加工检测
                    detectionRel.setType(DetectionStageEnum.INIPRO);
                    detectionRelMapper.insertSelective(detectionRel);
                }
            }

            PictureInfo detectionPic = initproDetection.getDetectionPic();
            if (detectionPic != null){
                PictureInfo oldPic = pictureInfoMapper.getInitProDetectionPic(initproDetection.getId());
                if (oldPic != null){
                    File file = new File(imgUpload.getPath(oldPic.getPictureUrl()));
                    file.delete();
                    pictureInfoMapper.deleteByPrimaryKey(oldPic.getId());
                }
                detectionPic.setRelationId(initproDetection.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(detectionPic);
            }

            //添加初加工批次
            List<InitproDetRel> initproDetRelList = initproDetection.getInitproDetRelList();
            if (initproDetRelList != null && !initproDetRelList.isEmpty()){
                initproDetRelMapper.deleteByInitproDetId(initproDetection.getId());
                for (InitproDetRel initproDetRel :initproDetRelList ) {
                    initproDetRel.setInitproDetId(initproDetection.getId());
                    initproDetRelMapper.insertSelective(initproDetRel);
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
    public List<InitproDetection> getInitproDetection(Integer planId, Date startTime, Date endTime) {
        return initproDetectionMapper.getInitproDetection(planId,startTime,endTime);
    }

    @Override
    public String getInitDetectionPic(Integer batchId) {
        return initproDetectionMapper.getInitDetectionPic(batchId);
    }
}
