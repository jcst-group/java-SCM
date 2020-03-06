package com.nongxin.terminal.dao.system;

import com.nongxin.terminal.entity.system.AppResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppResource record);

    int insertSelective(AppResource record);

    AppResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppResource record);

    int updateByPrimaryKey(AppResource record);

    //获取用户app权限
    List<AppResource> getAppResourceByUid(Integer uid,Integer type);

    //获取角色app权限
    List<AppResource> getAppResourceByRoleId(@Param("roleId") String roleId,@Param("roleType")String roleType);

    //获取app权限
    List<AppResource> getAppResourceList(@Param("type") Integer type);

}