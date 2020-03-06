package com.nongxin.terminal.dao.system;

import com.nongxin.terminal.entity.system.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);

    int deleteByUid(Integer uid);

}