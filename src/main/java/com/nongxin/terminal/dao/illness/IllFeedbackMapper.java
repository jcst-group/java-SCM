package com.nongxin.terminal.dao.illness;

import com.nongxin.terminal.entity.illness.IllFeedback;
import com.nongxin.terminal.util.enumUtil.illness.IllFeedbackStatusEnum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IllFeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IllFeedback record);

    int insertSelective(IllFeedback record);

    IllFeedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IllFeedback record);

    int updateByPrimaryKey(IllFeedback record);

    List<IllFeedback> getIllFeedbackList(@Param("baseId")Integer baseId, @Param("status")IllFeedbackStatusEnum status);

    List<IllFeedback> getUserIllFeedback(@Param("userId")Integer userId,@Param("baseId")Integer baseId);
}