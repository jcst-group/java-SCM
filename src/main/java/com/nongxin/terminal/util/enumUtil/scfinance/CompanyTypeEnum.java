package com.nongxin.terminal.util.enumUtil.scfinance;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CompanyTypeEnum implements IEnum<Short> {
    COUNTRYOWNER(new Short("1"),"COUNTRYOWNER","国有企业"),
    GROUPOWNER(new Short("2"),"GROUPOWNER","集体所有制"),
    PRIVATEOWNER(new Short("3"),"PRIVATEOWNER","私有企业"),
    STACKOWNER(new Short("4"),"STACKOWNER","股份制");
    private Short value;
    private String code;
    private String displayName;


    CompanyTypeEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static CompanyTypeEnum getByValue(Short value){
        CompanyTypeEnum categoryEnums[] = CompanyTypeEnum.values();
        for(CompanyTypeEnum categoryEnum : categoryEnums){
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
