package com.nongxin.terminal.service.system.impl;

import com.nongxin.terminal.dao.system.RoleAppResourceMapper;
import com.nongxin.terminal.dao.system.RoleMapper;
import com.nongxin.terminal.dao.system.RoleResourceMapper;
import com.nongxin.terminal.dao.system.RoleShowResourceMapper;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {

    @Autowired(required = false)
    private RoleMapper roleMapper;
    @Autowired(required = false)
    private RoleResourceMapper roleResourceMapper;
    @Autowired(required = false)
    private RoleAppResourceMapper roleAppResourceMapper;
    @Autowired(required = false)
    private RoleShowResourceMapper roleShowResourceMapper;


    @Override
    public boolean add(Role role) {
        return roleMapper.insertSelective(role)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return roleMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role)==1;
    }

    @Override
    public List<Role> getRoleList(Role role) {
        return roleMapper.getRoleList(role);
    }

    @Override
    public List<Role> getAllRoleList() {
        return roleMapper.getAllRoleList();
    }

    @Override
    public List<Role> getRoleByUid(Integer uid) {
        return roleMapper.getRoleByUid(uid);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addResourceToRole(Role role) {
        try {
            List resourceList = role.getResourceList();
            if (resourceList != null){
                roleResourceMapper.deleteByRoleId(role.getId());
                if (!resourceList.isEmpty()){
                    roleResourceMapper.addRoleResource(resourceList,role.getId());
                }
            }

            List appResourceList = role.getAppResourceList();
            if (appResourceList != null){
                roleAppResourceMapper.deleteByRoleId(role.getId());
                if (!appResourceList.isEmpty()){
                    roleAppResourceMapper.addRoleAppResource(appResourceList,role.getId());
                }
            }

            List showResourceList = role.getShowResourceList();
            if (showResourceList != null){
                roleShowResourceMapper.deleteByRoleId(role.getId());
                if (!showResourceList.isEmpty()){
                    roleShowResourceMapper.addRoleShowResource(showResourceList,role.getId());
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }
}
