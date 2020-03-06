package com.nongxin.terminal.service.illness;

import com.nongxin.terminal.entity.illness.IllFeedback;
import com.nongxin.terminal.util.enumUtil.illness.IllFeedbackStatusEnum;

import java.util.List;

public interface IllFeedbackService {

    boolean add(IllFeedback illFeedback);

    boolean update(IllFeedback illFeedback);

    boolean delete(Integer id);

    //查询所有病虫害
    List<IllFeedback> getIllFeedbackList(Integer baseId,IllFeedbackStatusEnum status);

    //查询用户对应基地病虫害
    List<IllFeedback> getUserIllFeedback(Integer userId,Integer baseId);

    //处理病虫害反馈
    boolean processFeedback(IllFeedback illFeedback);

}
