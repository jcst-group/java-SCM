package com.nongxin.terminal.service.system.impl;

import com.nongxin.terminal.dao.system.ResourceMapper;
import com.nongxin.terminal.entity.system.AppResource;
import com.nongxin.terminal.entity.system.Resource;
import com.nongxin.terminal.service.system.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired(required = false)
    private ResourceMapper resourceMapper;

    @Override
    public boolean add(Resource resource) {
        return resourceMapper.insertSelective(resource)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return resourceMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(Resource resource) {
        return resourceMapper.updateByPrimaryKeySelective(resource)==1;
    }

    @Override
    public List<Resource> getResourceByUid(Integer uid, Integer type) {
        return resourceMapper.getResourceByUid(uid,type);
    }

    @Override
    public List<Resource> getResourceList(Integer type) {
        return resourceMapper.getResourceList(type);
    }

    @Override
    public List<Resource> getAction(Integer parentId, Integer uid) {
        return resourceMapper.getAction(parentId,uid);
    }

    @Override
    public Map<String, Object> selectByCode(String code) {
        return resourceMapper.selectByCode(code);
    }

    @Override
    public Resource getWaitHandleByUid(Integer uid, String code) {
        return resourceMapper.getWaitHandleByUid(uid,code);
    }
}
