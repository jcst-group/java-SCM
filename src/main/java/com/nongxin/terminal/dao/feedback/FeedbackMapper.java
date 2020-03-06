package com.nongxin.terminal.dao.feedback;

import com.nongxin.terminal.entity.feedback.Feedback;
import com.nongxin.terminal.util.enumUtil.illness.IllFeedbackStatusEnum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);

    List<Feedback> getFeedBack(@Param("baseId") Integer baseId,@Param("status") IllFeedbackStatusEnum status,@Param("uid")Integer uid);

}