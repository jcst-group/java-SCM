package com.nongxin.terminal.util.enumUtil.system;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RoleTypeEnum implements BaseEnum<RoleTypeEnum, Short>, IEnum<Short> {

    ADMIN(new Short("1"),"ADMIN","管理员"),
    NOADMIN(new Short("2"),"NOADMIN","普通用户"),
    FARMER(new Short("3"),"FARMER","农户");

    private Short value;
    private String code;
    private String displayName;

    RoleTypeEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static RoleTypeEnum getByValue(Short value){
        RoleTypeEnum roleStatusEnums[] = RoleTypeEnum.values();
        for(RoleTypeEnum roleStatusEnum : roleStatusEnums){
            if(roleStatusEnum.getValue().equals(value)){
                return roleStatusEnum;
            }
        }
        return null;
    }

    public Short getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }

}
