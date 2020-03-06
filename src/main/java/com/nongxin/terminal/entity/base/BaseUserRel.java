package com.nongxin.terminal.entity.base;

import com.nongxin.terminal.entity.system.User;

import javax.validation.constraints.NotNull;
import java.util.List;

public class BaseUserRel {

    @NotNull(message = "基地id不能为空")
    private Integer baseId;

    //@NotNull(message = "用户id不能为空")
    private Integer userId;

    private BaseInfo baseInfo;

    private List<User> userList;

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public void setBaseId(Integer baseId) {
        this.baseId = baseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}