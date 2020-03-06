package com.nongxin.terminal.util.enumUtil.scfinance;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum InsuranceTypeEnum implements IEnum<Short> {
    PLANT_INSURANCE(new Short("1"),"PLANT_INSURANCE","种植险"),
    PRICE_INSURANCE(new Short("2"),"PRICE_INSURANCE","价格险");

    private Short value;
    private String code;
    private String displayName;

    InsuranceTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static InsuranceTypeEnum getByValue(Short value){
        InsuranceTypeEnum enums[] = InsuranceTypeEnum.values();
        for(InsuranceTypeEnum e : enums){
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
