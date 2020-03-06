package com.nongxin.terminal.entity.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.util.enumUtil.system.UserSexEnum;
import com.nongxin.terminal.util.enumUtil.system.UserStatusEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

public class User {
    private Integer uid;

    @NotEmpty(message = "用户名不能为空")
    @Length(max=30, message = "用户名长度不得高于30")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(max=50, message = "密码长度不得高于50")
    private String password;

    private String salt;

    @NotEmpty(message = "真实姓名不能为空")
    @Length(max=30, message = "真实姓名长度不得高于30")
    private String realName;

    @NotEmpty(message = "手机号不能为空")
    @Pattern(regexp = "^((13[0-9])|(14[5-9])|(15([0-3]|[5-9]))|(16[56])|(17[0-8])|(18[0-9])|(19[189]))\\d{8}$",
            message = "非法手机号码，请重新输入！！")
    private String phone;

    @Pattern(regexp = "(^\\d{15}$)|(^\\d{17}([0-9]|X)$)",
            message = "非法身份证号，请重新输入！！")
    private String identifyCode;

    private String email;

    @NotNull(message = "性别不能为空")
    private UserSexEnum sex;

    private UserStatusEnum status;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updateTime;

    private Byte createWhere;

    private PictureInfo headPic;

    private PictureInfo hukouPic;

    private PictureInfo identifyCodePic;

    private List<FamilyMenber> familyMenberList;

    private List<Role> roleList;

    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public PictureInfo getIdentifyCodePic() {
        return identifyCodePic;
    }

    public void setIdentifyCodePic(PictureInfo identifyCodePic) {
        this.identifyCodePic = identifyCodePic;
    }

    public List<FamilyMenber> getFamilyMenberList() {
        return familyMenberList;
    }

    public void setFamilyMenberList(List<FamilyMenber> familyMenberList) {
        this.familyMenberList = familyMenberList;
    }

    public PictureInfo getHeadPic() {
        return headPic;
    }

    public void setHeadPic(PictureInfo headPic) {
        this.headPic = headPic;
    }

    public PictureInfo getHukouPic() {
        return hukouPic;
    }

    public void setHukouPic(PictureInfo hukouPic) {
        this.hukouPic = hukouPic;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdentifyCode() {
        return identifyCode;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode == null ? null : identifyCode.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public UserSexEnum getSex() {
        return sex;
    }

    public void setSex(UserSexEnum sex) {
        this.sex = sex;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getCreateWhere() {
        return createWhere;
    }

    public void setCreateWhere(Byte createWhere) {
        this.createWhere = createWhere;
    }
}