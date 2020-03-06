package com.nongxin.terminal.util.enumUtil.base;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum BaseTypeEnum implements BaseEnum<BaseTypeEnum, Short>, IEnum<Short> {

    GAP_BASE(new Short("1"),"GAP_BASE","GAP基地"),
    COOPERATION_BASE(new Short("2"),"COOPERATION_BASE","合作基地"),
    SELF_BASE(new Short("3"),"SELF_BASE","自营基地"),
    INSEPARABLE_BASE(new Short("4"),"INSEPARABLE_BASE","紧密合作基地"),
    LOOSE_BASE(new Short("5"),"LOOSE_BASE","松散合作基地"),
    ORDER_BASE(new Short("6"),"ORDER_BASE","订单基地"),
    COOPERATIVE(new Short("7"),"COOPERATIVE","合作社"),
    FAMILY_FARM(new Short("8"),"FAMILY_FARM","家庭农场");

    private Short value;
    private String code;
    private String displayName;

    BaseTypeEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static BaseTypeEnum getByValue(Short value){
        BaseTypeEnum baseTypeEnums[] = BaseTypeEnum.values();
        for(BaseTypeEnum baseTypeEnum : baseTypeEnums){
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
