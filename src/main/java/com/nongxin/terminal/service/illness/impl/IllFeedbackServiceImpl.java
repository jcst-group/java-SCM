package com.nongxin.terminal.service.illness.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.illness.IllFeedbackMapper;
import com.nongxin.terminal.dao.illness.IllFeedbackPlanMapper;
import com.nongxin.terminal.dao.illness.IllnessMapper;
import com.nongxin.terminal.dao.illness.TreatmentPlanMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.illness.IllFeedback;
import com.nongxin.terminal.entity.illness.IllFeedbackPlan;
import com.nongxin.terminal.entity.illness.Illness;
import com.nongxin.terminal.entity.illness.TreatmentPlan;
import com.nongxin.terminal.service.illness.IllFeedbackService;
import com.nongxin.terminal.util.ImgUpload;
import com.nongxin.terminal.util.enumUtil.illness.IllFeedbackStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

@Service
public class IllFeedbackServiceImpl implements IllFeedbackService {

    @Autowired(required = false)
    private IllFeedbackMapper illFeedbackMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired
    private ImgUpload imgUpload;
    @Autowired(required = false)
    private IllnessMapper illnessMapper;
    @Autowired(required = false)
    private TreatmentPlanMapper treatmentPlanMapper;
    @Autowired(required = false)
    private IllFeedbackPlanMapper illFeedbackPlanMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(IllFeedback illFeedback) {
        illFeedbackMapper.insertSelective(illFeedback);
        List<PictureInfo> list = illFeedback.getPictureInfoList();
        if (list != null && !list.isEmpty()){
            for (PictureInfo pictureInfo : list){
                pictureInfo.setRelationId(illFeedback.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
            }
        }
        return true;
    }

    @Override
    public boolean update(IllFeedback illFeedback) {
        return illFeedbackMapper.updateByPrimaryKeySelective(illFeedback)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        illFeedbackMapper.deleteByPrimaryKey(id);
        List<PictureInfo> list = pictureInfoMapper.getIllFeedbackPic(id);
        if (list != null && !list.isEmpty()){
            for (PictureInfo pictureInfo : list) {
                File pictureInfoFile = new File(imgUpload.getPath(pictureInfo.getPictureUrl()));
                pictureInfoFile.delete();
                pictureInfoMapper.deleteByPrimaryKey(pictureInfo.getId());
            }
        }
        return true;
    }

    @Override
    public List<IllFeedback> getIllFeedbackList(Integer baseId,IllFeedbackStatusEnum status) {
        return illFeedbackMapper.getIllFeedbackList(baseId,status);
    }

    @Override
    public List<IllFeedback> getUserIllFeedback(Integer userId, Integer baseId) {
        return illFeedbackMapper.getUserIllFeedback(userId,baseId);
    }

    public void addTreatmentPlan(Integer illnessId,String planName,String method){
        TreatmentPlan treatmentPlan = new TreatmentPlan();
        treatmentPlan.setIllId(illnessId);
        treatmentPlan.setPlanName(planName);
        treatmentPlan.setMethod(method);
        treatmentPlanMapper.insertSelective(treatmentPlan);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean processFeedback(IllFeedback illFeedback) {
        List<IllFeedbackPlan> feedbackPlans = illFeedback.getIllFeedbackPlans();
        illFeedbackPlanMapper.deleteByFeedbackId(illFeedback.getId());
        if (feedbackPlans != null && !feedbackPlans.isEmpty()){
            for (IllFeedbackPlan feedbackPlan : feedbackPlans) {
                //判断病虫害是否存在
                Illness illness = illnessMapper.selectByIllnessName(feedbackPlan.getIllName());
                if (illness == null){
                    illness = new Illness();
                    illness.setIllnessName(feedbackPlan.getIllName());
                    illnessMapper.insertSelective(illness);
                    //病虫害不存在时，治疗方案不用判断，直接新增
                    addTreatmentPlan(illness.getId(),feedbackPlan.getPlanName(),feedbackPlan.getMethod());
                }else{
                    //病虫害存在时，判断治疗方案是否存在，存在则覆盖，不存在则新增
                    TreatmentPlan treatmentPlan = treatmentPlanMapper.selectByPlanName(feedbackPlan.getPlanName(),illness.getId());
                    if (treatmentPlan == null){
                        addTreatmentPlan(illness.getId(),feedbackPlan.getPlanName(),feedbackPlan.getMethod());
                    }else{
                        treatmentPlan.setMethod(feedbackPlan.getMethod());
                        treatmentPlanMapper.updateByPrimaryKeySelective(treatmentPlan);
                    }
                }
                feedbackPlan.setIllId(illness.getId());
                feedbackPlan.setFeedbackId(illFeedback.getId());
                illFeedbackPlanMapper.insertSelective(feedbackPlan);
            }
        }
        illFeedback.setStatus(IllFeedbackStatusEnum.PROCESSED);
        return illFeedbackMapper.updateByPrimaryKeySelective(illFeedback)==1;
    }
}
