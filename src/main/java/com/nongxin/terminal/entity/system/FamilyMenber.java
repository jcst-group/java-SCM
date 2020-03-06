package com.nongxin.terminal.entity.system;

import com.nongxin.terminal.util.enumUtil.system.UserSexEnum;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class FamilyMenber {
    private Integer id;

    @NotNull(message = "用户id不能为空")
    private Integer userId;

    @NotEmpty(message = "家庭成员名称不能为空")
    private String memberName;

    @NotNull(message = "关系不能为空")
    private String relation;

    @NotNull(message = "性别不能为空")
    private UserSexEnum sex;

    @Pattern(regexp = "(^\\d{15}$)|(^\\d{17}([0-9]|X)$)",
            message = "非法身份证号，请重新输入！！")
    private String identifyCode;

    private String occupation;

    private String politicCountenance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public UserSexEnum getSex() {
        return sex;
    }

    public void setSex(UserSexEnum sex) {
        this.sex = sex;
    }

    public String getIdentifyCode() {
        return identifyCode;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode == null ? null : identifyCode.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getPoliticCountenance() {
        return politicCountenance;
    }

    public void setPoliticCountenance(String politicCountenance) {
        this.politicCountenance = politicCountenance == null ? null : politicCountenance.trim();
    }
}