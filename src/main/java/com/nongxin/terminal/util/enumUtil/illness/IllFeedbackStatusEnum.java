package com.nongxin.terminal.util.enumUtil.illness;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum IllFeedbackStatusEnum implements BaseEnum<IllFeedbackStatusEnum, Short>, IEnum<Short> {

    UNTREATED(new Short("1"),"UNTREATED","未处理"),
    PROCESSED(new Short("2"),"PROCESSED","已处理");

    private Short value;
    private String code;
    private String displayName;

    IllFeedbackStatusEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static IllFeedbackStatusEnum getByValue(Short value){
        IllFeedbackStatusEnum baseTypeEnums[] = IllFeedbackStatusEnum.values();
        for(IllFeedbackStatusEnum baseTypeEnum : baseTypeEnums){
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
