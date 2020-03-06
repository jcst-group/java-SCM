package com.nongxin.terminal.dao.system;

import com.nongxin.terminal.entity.system.RoleShowResource;
import com.nongxin.terminal.entity.system.ShowResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleShowResourceMapper {
    int insert(RoleShowResource record);

    int insertSelective(RoleShowResource record);

    //删除角色看板权限
    int deleteByRoleId(Integer roleId);

    //批量添加角色看板权限
    int addRoleShowResource(@Param("list") List<ShowResource> list, @Param("roleId")Integer roleId);
}