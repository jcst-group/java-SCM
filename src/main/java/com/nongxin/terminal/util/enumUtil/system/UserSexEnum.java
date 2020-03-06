package com.nongxin.terminal.util.enumUtil.system;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserSexEnum implements BaseEnum<UserSexEnum, Short>, IEnum<Short> {

    MAN(new Short("1"),"MAN","男"),
    WOMAN(new Short("2"),"WOMAN","女");

    private Short value;
    private String code;
    private String displayName;

    UserSexEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static UserSexEnum getByValue(Short value){
        UserSexEnum userSexEnums[] = UserSexEnum.values();
        for(UserSexEnum userSexEnum : userSexEnums){
            if(userSexEnum.getValue().equals(value)){
                return userSexEnum;
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
