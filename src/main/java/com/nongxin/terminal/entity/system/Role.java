package com.nongxin.terminal.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.system.RoleStatusEnum;
import com.nongxin.terminal.util.enumUtil.system.RoleTypeEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class Role {
    private Integer id;

    @NotEmpty(message = "角色名称不能为空")
    @Length(max = 30,message = "角色名称长度不能高于超过30")
    private String name;

    @NotNull(message = "角色类型不能为空")
    private RoleTypeEnum type;

    private RoleStatusEnum status;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    @Length(max = 255,message = "备注长度不能高于超过255")
    private String remark;

    //后台权限
    private List<Resource> resourceList;

    //app权限
    private List<AppResource> appResourceList;

    //看板权限
    private List<ShowResource> showResourceList;

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    public List<AppResource> getAppResourceList() {
        return appResourceList;
    }

    public void setAppResourceList(List<AppResource> appResourceList) {
        this.appResourceList = appResourceList;
    }

    public List<ShowResource> getShowResourceList() {
        return showResourceList;
    }

    public void setShowResourceList(List<ShowResource> showResourceList) {
        this.showResourceList = showResourceList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public RoleTypeEnum getType() {
        return type;
    }

    public void setType(RoleTypeEnum type) {
        this.type = type;
    }

    public RoleStatusEnum getStatus() {
        return status;
    }

    public void setStatus(RoleStatusEnum status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}