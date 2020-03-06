package com.nongxin.terminal.util.enumUtil.plan;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PrepareTypeEnum implements BaseEnum<PrepareTypeEnum, Short>, IEnum<Short> {

    PERSONNEL(new Short("1"),"PERSONNEL","人资"),
    MATERIAL(new Short("2"),"MATERIAL","物料"),
    DEVICE(new Short("3"),"DEVICE","设备");

    private Short value;
    private String code;
    private String displayName;

    PrepareTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static PrepareTypeEnum getByValue(Short value){
        PrepareTypeEnum baseTypeEnums[] = PrepareTypeEnum.values();
        for(PrepareTypeEnum baseTypeEnum : baseTypeEnums){
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
