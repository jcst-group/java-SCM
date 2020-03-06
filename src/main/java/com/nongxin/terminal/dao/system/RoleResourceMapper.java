package com.nongxin.terminal.dao.system;

import com.nongxin.terminal.entity.system.Resource;
import com.nongxin.terminal.entity.system.RoleResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleResourceMapper {
    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    //删除角色后台权限
    int deleteByRoleId(Integer roleId);

    //批量添加角色后台权限
    int addRoleResource(@Param("list") List<Resource> list, @Param("roleId")Integer roleId);
}