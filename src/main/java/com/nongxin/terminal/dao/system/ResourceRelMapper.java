package com.nongxin.terminal.dao.system;

import com.nongxin.terminal.entity.system.ResourceRel;

import java.util.List;

public interface ResourceRelMapper {
    int insert(ResourceRel record);

    int insertSelective(ResourceRel record);

    List<ResourceRel> selectByResourceId(Integer resourceId);
}