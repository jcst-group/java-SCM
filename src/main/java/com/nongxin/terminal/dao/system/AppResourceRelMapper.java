package com.nongxin.terminal.dao.system;

import com.nongxin.terminal.entity.system.AppResourceRel;

import java.util.List;

public interface AppResourceRelMapper {
    int insert(AppResourceRel record);

    int insertSelective(AppResourceRel record);

    List<AppResourceRel> selectByResourceId(Integer resourceId);
}