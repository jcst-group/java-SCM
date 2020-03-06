package com.nongxin.terminal.dao.push;

import com.nongxin.terminal.entity.push.PushRel;

import java.util.List;

public interface PushRelMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByUidAndCid(PushRel record);

    int insert(PushRel record);

    int insertSelective(PushRel record);

    PushRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PushRel record);

    int updateByPrimaryKey(PushRel record);

    PushRel selectByUidAndCid(PushRel pushRel);

    List<String> getCidListByUserId(Integer userId);
}