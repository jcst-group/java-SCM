package com.nongxin.terminal.dao.illness;

import com.nongxin.terminal.entity.illness.Illness;

import java.util.List;

public interface IllnessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Illness record);

    int insertSelective(Illness record);

    Illness selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Illness record);

    int updateByPrimaryKey(Illness record);

    //List<Illness> selectByFeedbackId(Integer feedbackId);

    List<Illness> getAll(String illnessName);

    Illness selectByIllnessName(String illnessName);
}