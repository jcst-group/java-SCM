package com.nongxin.terminal.dao.testing;

import com.nongxin.terminal.entity.testing.InitproDetRel;

public interface InitproDetRelMapper {
    int insert(InitproDetRel record);

    int insertSelective(InitproDetRel record);

    int deleteByInitproDetId(Integer initproDetId);
}