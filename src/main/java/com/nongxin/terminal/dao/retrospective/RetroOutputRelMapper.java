package com.nongxin.terminal.dao.retrospective;

import com.nongxin.terminal.entity.retrospective.RetroOutputRel;
import com.nongxin.terminal.util.enumUtil.retrospective.RetroCodingTypeEnum;
import org.apache.ibatis.annotations.Param;

public interface RetroOutputRelMapper {
    int insert(RetroOutputRel record);

    int insertSelective(RetroOutputRel record);

    RetroOutputRel selectByRelationId(@Param("relationId") Integer relationId, @Param("relationType") RetroCodingTypeEnum type);

    int update(RetroOutputRel record);

    int deleteByRelationId(@Param("relationId") Integer relationId, @Param("relationType") RetroCodingTypeEnum type);
}