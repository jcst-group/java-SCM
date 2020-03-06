package com.nongxin.terminal.dao.system;

import com.nongxin.terminal.entity.system.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    //分页带条件
    List<Role> getRoleList(Role role);

    //查询所有角色
    List<Role> getAllRoleList();

    List<Role> getRoleByUid(Integer uid);

    List<Role> getRoleByFarmingId(Integer farmingId);

    List<Role> getRoleByOrderId(Integer orderId);

    List<Role> getRoleNotAdmin(Integer uid);
}