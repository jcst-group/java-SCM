package com.nongxin.terminal.util.enumUtil.plan;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AgreeEnum implements BaseEnum<AgreeEnum, Short>, IEnum<Short> {

    Untreated(new Short("1"),"Untreated","未处理"),
    Agree(new Short("2"),"Agree","同意"),
    Disagree(new Short("3"),"Disagree","不同意");

    private Short value;
    private String code;
    private String displayName;

    AgreeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static AgreeEnum getByValue(Short value){
        AgreeEnum baseTypeEnums[] = AgreeEnum.values();
        for(AgreeEnum baseTypeEnum : baseTypeEnums){
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
