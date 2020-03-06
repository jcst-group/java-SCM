package com.nongxin.terminal.service.feedback;

import com.nongxin.terminal.entity.feedback.Feedback;
import com.nongxin.terminal.util.enumUtil.illness.IllFeedbackStatusEnum;

import java.util.List;

public interface FeedbackService {

    boolean add(Feedback feedback);

    List<Feedback> getFeedBack(Integer baseId, IllFeedbackStatusEnum status,Integer uid);

    boolean update(Feedback feedback);

}
