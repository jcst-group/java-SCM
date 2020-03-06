package com.nongxin.terminal.util.enumUtil.scfinance;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LoanApplyTypeEnum implements IEnum<Short> {
    PLANT(new Short("1"),"PLANT","农资贷款"),

    ORDER(new Short("2"),"ORDER","订单贷款"),
    WORKER(new Short("3"),"WORKER","劳务贷款"),
    PLEDGE(new Short("4"),"PLEDGE","仓单质押贷款"),
    TECHNICAL_SERVICE(new Short("5"),"TECHNICAL_SERVICE","技术服务贷款"),
    DETECTION(new Short("6"),"DETECTION","检测费用贷款");
    private Short value;
    private String code;
    private String displayName;

    LoanApplyTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static LoanApplyTypeEnum getByValue(Short value){
        LoanApplyTypeEnum enums[] = LoanApplyTypeEnum.values();
        for(LoanApplyTypeEnum e : enums){
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
