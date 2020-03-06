package com.nongxin.terminal.dao.base;

import com.nongxin.terminal.entity.base.BaseUserRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseUserRelMapper {
    int insert(BaseUserRel record);

    int insertSelective(BaseUserRel record);

    int deleteByBaseId(Integer baseId);

    List<BaseUserRel> getBaseUserRelList(@Param("baseName")String baseName,@Param("userName")String userName);

    int selectByBaseId(@Param("baseId")Integer baseId);
}