package com.nongxin.terminal.util.enumUtil.base;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SoilTypeEnum implements BaseEnum<SoilTypeEnum, Short>, IEnum<Short> {

    BLACK_SOIL(new Short("1"),"BLACK_SOIL","砂质土"),
    LOESS(new Short("2"),"LOESS","黏质土"),
    SANDY_SOIL(new Short("3"),"SANDY_SOIL","壤土");

    private Short value;
    private String code;
    private String displayName;

    SoilTypeEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static SoilTypeEnum getByValue(Short value){
        SoilTypeEnum soilTypeEnums[] = SoilTypeEnum.values();
        for(SoilTypeEnum soilTypeEnum : soilTypeEnums){
            if(soilTypeEnum.getValue().equals(value)){
                return soilTypeEnum;
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
