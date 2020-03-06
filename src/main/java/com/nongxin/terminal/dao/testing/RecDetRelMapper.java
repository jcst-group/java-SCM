package com.nongxin.terminal.dao.testing;

import com.nongxin.terminal.entity.testing.RecDetRel;

public interface RecDetRelMapper {
    int insert(RecDetRel record);

    int insertSelective(RecDetRel record);

    int deleteByRecDetectionId(Integer recDetectionId);
}