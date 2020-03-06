package com.nongxin.terminal.util.enumUtil.scfinance;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TrueOrFalseEnum implements IEnum<Short> {
    TRUE(new Short("1"),"TRUE","是"),
    FALSE(new Short("2"),"FALSE","否");
    private Short value;
    private String code;
    private String displayName;

    TrueOrFalseEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }


    public static TrueOrFalseEnum getByValue(Short value){
        TrueOrFalseEnum enums[] = TrueOrFalseEnum.values();
        for(TrueOrFalseEnum e : enums){
            if(e.getValue().equals(value)){
                return e;
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
