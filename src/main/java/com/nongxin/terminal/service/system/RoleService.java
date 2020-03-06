package com.nongxin.terminal.service.system;

import com.nongxin.terminal.entity.system.Role;

import java.util.List;

public interface RoleService {

    boolean add(Role role);

    boolean delete(Integer id);

    boolean update(Role role);

    //分页带条件
    List<Role> getRoleList(Role role);

    //查询所有角色
    List<Role> getAllRoleList();

    //根据用户id查询角色
    List<Role> getRoleByUid(Integer uid);

    //给角色分配权限
    boolean addResourceToRole(Role role);

}
