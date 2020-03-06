package com.nongxin.terminal.dao.system;

import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.util.enumUtil.system.RoleTypeEnum;
import com.nongxin.terminal.vo.lookboard.BaseUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //分页带条件
    List<User> getUserList(User user);

    List<User> getAllUser();

    User getUserByUserName(@Param("username") String username, @Param("status") Integer status);

    int updateUserStatus(Integer id);

    List<User> getUserByBaseId(Integer baseId);

    List<User> getUserAndRole(@Param("realName") String realName);

    User getIdAndName(Integer id);

    //根据用户名查询用户和角色
    User getUserAndRoleByUserName(String username);

    BaseUserVo getBaseUser(Integer baseId);

    List<User> getFarmer(@Param("type")RoleTypeEnum type,@Param("realName")String realName);

    User checkUser(@Param("username") String username,@Param("phone") String phone);

    User getUserAndHeadPic(Integer uid);

    Map<String,Object> getUserCount();

    List<Map<String,Object>> getRoleAndUserCount();

    List<User> getOrderExecutor(@Param("orderId")Integer orderId);
}