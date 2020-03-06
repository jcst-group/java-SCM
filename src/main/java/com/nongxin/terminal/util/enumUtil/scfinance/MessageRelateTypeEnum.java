package com.nongxin.terminal.util.enumUtil.scfinance;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MessageRelateTypeEnum implements IEnum<Short> {
    ORDER_RELATE(new Short("1"),"ORDER_RELATE","保险保单"),
    BANK_LOAN(new Short("2"),"BANK_LOAN","银行贷款"),
    DETECTION_APPLY(new Short("3"),"DETECTION_APPLY","订单检测");
    private Short value;
    private String code;
    private String displayName;

    MessageRelateTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }


    public static MessageRelateTypeEnum getByValue(Short value){
        MessageRelateTypeEnum enums[] = MessageRelateTypeEnum.values();
        for(MessageRelateTypeEnum e : enums){
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
