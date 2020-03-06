package com.nongxin.terminal.util.enumUtil.scfinance;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CommonTrueFalseEnum implements IEnum<Short> {
    TRUE(new Short("1"),"TRUE","是"),
    FALSE(new Short("0"),"FALSE","否");
    private Short value;
    private String code;
    private String displayName;


    CommonTrueFalseEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static CommonTrueFalseEnum getByValue(Short value){
        CommonTrueFalseEnum categoryEnums[] = CommonTrueFalseEnum.values();
        for(CommonTrueFalseEnum categoryEnum : categoryEnums){
            if(categoryEnum.getValue().equals(value)){
                return categoryEnum;
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
