package com.nongxin.terminal.dao.base;

import com.nongxin.terminal.entity.base.LotUserRel;

public interface LotUserRelMapper {
    int insert(LotUserRel record);

    int insertSelective(LotUserRel record);
}