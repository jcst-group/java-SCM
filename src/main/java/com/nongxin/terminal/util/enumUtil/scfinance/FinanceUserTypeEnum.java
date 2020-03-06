package com.nongxin.terminal.util.enumUtil.scfinance;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FinanceUserTypeEnum implements IEnum<Short> {
    COOPERATIVE(new Short("1"),"COOPERATIVE","合作社"),
    INSURANCECOMP(new Short("2"),"INSURANCECOMP","保险公司"),
    BANKCOMP(new Short("3"),"BANKCOMP","银行"),
    DEMANDCOMP(new Short("4"),"DEMANDCOMP","订单企业"),
    WARRANT(new Short("5"),"WARRANT","担保公司"),
    DETETCTION(new Short("6"),"DETETCTION","检测机构");
    private Short value;
    private String code;
    private String displayName;

    FinanceUserTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static FinanceUserTypeEnum getByValue(Short value){
        FinanceUserTypeEnum enums[] = FinanceUserTypeEnum.values();
        for(FinanceUserTypeEnum e : enums){
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
