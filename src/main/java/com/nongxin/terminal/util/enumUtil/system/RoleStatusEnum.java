package com.nongxin.terminal.util.enumUtil.system;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RoleStatusEnum implements BaseEnum<RoleStatusEnum, Short>, IEnum<Short> {

    ENABLED(new Short("1"),"ENABLED","正常"),
    PROHIBIT(new Short("2"),"PROHIBIT","禁用");

    private Short value;
    private String code;
    private String displayName;

    RoleStatusEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static RoleStatusEnum getByValue(Short value){
        RoleStatusEnum roleStatusEnums[] = RoleStatusEnum.values();
        for(RoleStatusEnum roleStatusEnum : roleStatusEnums){
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
