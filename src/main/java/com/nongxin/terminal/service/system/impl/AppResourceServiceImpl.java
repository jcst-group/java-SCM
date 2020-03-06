package com.nongxin.terminal.service.system.impl;

import com.nongxin.terminal.dao.system.AppResourceMapper;
import com.nongxin.terminal.entity.system.AppResource;
import com.nongxin.terminal.service.system.AppResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppResourceServiceImpl implements AppResourceService {

    @Autowired(required = false)
    private AppResourceMapper appResourceMapper;

    @Override
    public boolean add(AppResource appResource) {
        return appResourceMapper.insertSelective(appResource)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return appResourceMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(AppResource appResource) {
        return appResourceMapper.updateByPrimaryKeySelective(appResource)==1;
    }

    @Override
    public List<AppResource> getAppResourceByUid(Integer uid, Integer type) {
        return appResourceMapper.getAppResourceByUid(uid,type);
    }

    @Override
    public List<AppResource> getAppResourceList(Integer type) {
        return appResourceMapper.getAppResourceList(type);
    }

}
