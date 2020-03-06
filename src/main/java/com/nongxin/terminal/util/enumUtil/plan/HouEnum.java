package com.nongxin.terminal.util.enumUtil.plan;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum HouEnum implements BaseEnum<HouEnum, Short>, IEnum<Short> {

    ONE(new Short("1"),"ONE","第一侯"),
    TWO(new Short("2"),"TWO","第二侯"),
    THREE(new Short("3"),"THREE","第三侯");

    private Short value;
    private String code;
    private String displayName;

    HouEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static HouEnum getByValue(Short value){
        HouEnum baseTypeEnums[] = HouEnum.values();
        for(HouEnum baseTypeEnum : baseTypeEnums){
            if(baseTypeEnum.getValue().equals(value)){
                return baseTypeEnum;
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
