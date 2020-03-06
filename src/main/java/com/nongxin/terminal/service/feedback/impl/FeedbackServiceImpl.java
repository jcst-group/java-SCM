package com.nongxin.terminal.service.feedback.impl;

import com.nongxin.terminal.dao.feedback.FeedbackMapper;
import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.entity.feedback.Feedback;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.service.feedback.FeedbackService;
import com.nongxin.terminal.util.enumUtil.illness.IllFeedbackStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired(required = false)
    private FeedbackMapper feedbackMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(Feedback feedback) {
        try {
            feedbackMapper.insertSelective(feedback);
            List<PictureInfo> list = feedback.getPictureInfoList();
            if (list != null && !list.isEmpty()){
                for (PictureInfo pictureInfo : list){
                    pictureInfo.setRelationId(feedback.getId());
                    pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
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
    public List<Feedback> getFeedBack(Integer baseId, IllFeedbackStatusEnum status,Integer uid) {
        return feedbackMapper.getFeedBack(baseId,status,uid);
    }

    @Override
    public boolean update(Feedback feedback) {
        return feedbackMapper.updateByPrimaryKeySelective(feedback)==1;
    }
}
