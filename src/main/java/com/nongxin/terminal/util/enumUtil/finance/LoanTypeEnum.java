package com.nongxin.terminal.util.enumUtil.finance;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LoanTypeEnum implements BaseEnum<LoanTypeEnum, Short>, IEnum<Short> {

    MATERIAL_LOAN(new Short("1"),"MATERIAL_LOAN","物资贷款"),
    HUMAN_LOAN(new Short("2"),"HUMAN_LOAN","人资贷款");

    private Short value;
    private String code;
    private String displayName;

    LoanTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static LoanTypeEnum getByValue(Short value){
        LoanTypeEnum baseTypeEnums[] = LoanTypeEnum.values();
        for(LoanTypeEnum baseTypeEnum : baseTypeEnums){
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
