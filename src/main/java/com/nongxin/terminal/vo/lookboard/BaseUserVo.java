package com.nongxin.terminal.vo.lookboard;

import com.nongxin.terminal.entity.system.Role;

import java.util.List;

public class BaseUserVo {

    private Integer uid;

    private String realName;

    private List<Role> roleList;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
