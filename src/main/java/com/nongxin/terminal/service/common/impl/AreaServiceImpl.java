package com.nongxin.terminal.service.common.impl;

import com.nongxin.terminal.dao.address.AreaMapper;
import com.nongxin.terminal.entity.address.Area;
import com.nongxin.terminal.service.common.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired(required = false)
    private AreaMapper areaMapper;

    @Override
    public List<Area> getAreaByLevel(Integer level) {
        return areaMapper.getAreaByLevel(level);
    }

    @Override
    public List<Area> getAreaByParentCode(String parentCode) {
        return areaMapper.getAreaByParentCode(parentCode);
    }

    @Override
    public List<Area> getAreaByName(String name) {
        return areaMapper.getAreaByName(name);
    }
}
