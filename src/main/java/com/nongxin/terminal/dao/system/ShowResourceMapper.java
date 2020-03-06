package com.nongxin.terminal.dao.system;

import com.nongxin.terminal.entity.system.ShowResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShowResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShowResource record);

    int insertSelective(ShowResource record);

    ShowResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShowResource record);

    int updateByPrimaryKey(ShowResource record);

    //获取用户看板权限
    List<ShowResource> getShowResourceByUid(Integer uid, Integer type);

    //获取角色看板权限
    List<ShowResource> getShowResourceByRoleId(@Param("roleId") String roleId,@Param("roleType")String roleType);

    //获取看板权限
    List<ShowResource> getShowResourceList(@Param("type") Integer type);
}