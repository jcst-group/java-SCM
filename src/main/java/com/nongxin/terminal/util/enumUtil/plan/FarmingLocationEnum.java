package com.nongxin.terminal.util.enumUtil.plan;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FarmingLocationEnum implements BaseEnum<FarmingLocationEnum, Short>, IEnum<Short> {

    YES(new Short("1"),"YES","是"),
    NO(new Short("2"),"NO","否");

    private Short value;
    private String code;
    private String displayName;

    FarmingLocationEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static FarmingLocationEnum getByValue(Short value){
        FarmingLocationEnum baseTypeEnums[] = FarmingLocationEnum.values();
        for(FarmingLocationEnum baseTypeEnum : baseTypeEnums){
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
