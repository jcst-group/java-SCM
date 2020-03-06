package com.nongxin.terminal.util.enumUtil.plan;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FarmingTypeEnum implements BaseEnum<FarmingTypeEnum, Short>, IEnum<Short> {

    ORDINARY(new Short("1"),"ORDINARY","普通农事"),
    TEMPORARY(new Short("2"),"TEMPORARY","临时农事");

    private Short value;
    private String code;
    private String displayName;

    FarmingTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static FarmingTypeEnum getByValue(Short value){
        FarmingTypeEnum baseTypeEnums[] = FarmingTypeEnum.values();
        for(FarmingTypeEnum baseTypeEnum : baseTypeEnums){
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
