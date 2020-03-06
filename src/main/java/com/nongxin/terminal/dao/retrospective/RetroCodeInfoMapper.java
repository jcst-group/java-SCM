package com.nongxin.terminal.dao.retrospective;

import com.nongxin.terminal.entity.retrospective.RetroCodeInfo;

public interface RetroCodeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RetroCodeInfo record);

    int insertSelective(RetroCodeInfo record);

    RetroCodeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RetroCodeInfo record);

    int updateByPrimaryKey(RetroCodeInfo record);
}