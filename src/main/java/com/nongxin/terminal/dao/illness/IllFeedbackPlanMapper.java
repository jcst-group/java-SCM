package com.nongxin.terminal.dao.illness;

import com.nongxin.terminal.entity.illness.IllFeedbackPlan;

import java.util.List;

public interface IllFeedbackPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IllFeedbackPlan record);

    int insertSelective(IllFeedbackPlan record);

    IllFeedbackPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IllFeedbackPlan record);

    int updateByPrimaryKey(IllFeedbackPlan record);

    List<IllFeedbackPlan> selectByFeedbackId(Integer feedbackId);

    int deleteByFeedbackId(Integer feedbackId);
}