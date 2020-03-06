package com.nongxin.terminal.util.enumUtil.base;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EnvStandardsEnum implements BaseEnum<EnvStandardsEnum, Short>, IEnum<Short> {

    WATER(new Short("1"),"WATER","水源"),
    AIR(new Short("2"),"AIR","空气"),
    SOIL(new Short("3"),"SOIL","土壤");

    private Short value;
    private String code;
    private String displayName;

    EnvStandardsEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static EnvStandardsEnum getByValue(Short value){
        EnvStandardsEnum envStandardsEnums[] = EnvStandardsEnum.values();
        for(EnvStandardsEnum envStandardsEnum : envStandardsEnums){
            if(envStandardsEnum.getValue().equals(value)){
                return envStandardsEnum;
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
