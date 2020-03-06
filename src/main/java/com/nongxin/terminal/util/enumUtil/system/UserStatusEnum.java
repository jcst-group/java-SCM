package com.nongxin.terminal.util.enumUtil.system;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserStatusEnum implements BaseEnum<UserStatusEnum, Short>, IEnum<Short> {

    ENABLED(new Short("1"),"ENABLED","已启用"),
    PROHIBIT(new Short("2"),"PROHIBIT","未启用");

    private Short value;
    private String code;
    private String displayName;

    UserStatusEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static UserStatusEnum getByValue(Short value){
        UserStatusEnum userStatusEnums[] = UserStatusEnum.values();
        for(UserStatusEnum userStatusEnum : userStatusEnums){
            if(userStatusEnum.getValue().equals(value)){
                return userStatusEnum;
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
