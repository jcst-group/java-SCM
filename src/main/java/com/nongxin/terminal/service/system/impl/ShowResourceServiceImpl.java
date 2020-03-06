package com.nongxin.terminal.service.system.impl;

import com.nongxin.terminal.dao.system.ShowResourceMapper;
import com.nongxin.terminal.entity.system.ShowResource;
import com.nongxin.terminal.service.system.ShowResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowResourceServiceImpl implements ShowResourceService {

    @Autowired(required = false)
    private ShowResourceMapper showResourceMapper;

    @Override
    public boolean add(ShowResource showResource) {
        return showResourceMapper.insertSelective(showResource)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return showResourceMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(ShowResource showResource) {
        return showResourceMapper.updateByPrimaryKeySelective(showResource)==1;
    }

    @Override
    public List<ShowResource> getShowResourceByUid(Integer uid, Integer type) {
        return showResourceMapper.getShowResourceByUid(uid,type);
    }

    @Override
    public List<ShowResource> getShowResourceList(Integer type) {
        return showResourceMapper.getShowResourceList(type);
    }

}
