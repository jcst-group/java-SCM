package com.nongxin.terminal.service.system;

import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.util.enumUtil.system.RoleTypeEnum;

import java.util.List;
import java.util.Map;

public interface UserService {

    boolean add(User user);

    boolean delete(Integer id);

    boolean update(User user);

    //分页带条件
    List<User> getUserList(User user);

    List<User> getAllUser();

    //根据用户名查询用户
    User getUserByUserName(String userName,Integer status);

    //给用户添加角色
    boolean addRoleToUser(User user);

    //修改用户状态
    boolean updateUserStatus(Integer id);

    //查询用户和角色
    List<User> getUserAndRole(String realName);

    //根据用户名查询用户和角色
    User getUserAndRoleByUserName(String username);

    //查询角色为农户的用户
    List<User> getFarmer(RoleTypeEnum type,String realName);

    //检验用户名或手机号是否存在
    User checkUser(String userName,String phone);

    //查询用户总数
    Map<String,Object> getUserCount();

    //查询各个角色类型对应人数
    List<Map<String,Object>> getRoleAndUserCount();

}
