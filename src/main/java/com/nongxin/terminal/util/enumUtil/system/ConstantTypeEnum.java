package com.nongxin.terminal.util.enumUtil.system;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ConstantTypeEnum implements BaseEnum<ConstantTypeEnum, Short>, IEnum<Short> {

    TRACEABILITY(new Short("1"),"TRACEABILITY","溯源地址"),
    ESTIMATED_PRICE(new Short("2"),"ESTIMATED_PRICE","预估价格"),
    OUTPUT_MU(new Short("3"),"OUTPUT_MU","亩产值"),
    BOARD_URL(new Short("4"),"BOARD_URL","看板url"),
    MARKET_SUM(new Short("5"),"MARKET_SUM","市场看板麦冬销售总额"),
    MARKET_TOKEN_SUM(new Short("6"),"MARKET_TOKEN_SUM","市场看板麦冬衍生物销售总额");

    private Short value;
    private String code;
    private String displayName;

    ConstantTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static ConstantTypeEnum getByValue(Short value){
        ConstantTypeEnum userSexEnums[] = ConstantTypeEnum.values();
        for(ConstantTypeEnum userSexEnum : userSexEnums){
            if(userSexEnum.getValue().equals(value)){
                return userSexEnum;
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
