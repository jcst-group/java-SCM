package com.nongxin.terminal.dao.system;

import com.nongxin.terminal.entity.system.AppResource;
import com.nongxin.terminal.entity.system.RoleAppResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleAppResourceMapper {
    int insert(RoleAppResource record);

    int insertSelective(RoleAppResource record);

    //删除角色app权限
    int deleteByRoleId(Integer roleId);

    //批量添加角色app权限
    int addRoleAppResource(@Param("list")List<AppResource> list,@Param("roleId")Integer roleId);
}