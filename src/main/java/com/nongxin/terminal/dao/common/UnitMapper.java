package com.nongxin.terminal.dao.common;

import com.nongxin.terminal.entity.common.Unit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnitMapper {
    int deleteByPrimaryKey(Integer value);

    int insert(Unit record);

    int insertSelective(Unit record);

    Unit selectByPrimaryKey(Integer value);

    int updateByPrimaryKeySelective(Unit record);

    int updateByPrimaryKey(Unit record);

    List<Unit> getUnit(@Param("displayName")String displayName);

    Unit selectByDisplayName(@Param("displayName")String displayName);
}