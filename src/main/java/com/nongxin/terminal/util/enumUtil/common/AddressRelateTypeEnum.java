package com.nongxin.terminal.util.enumUtil.common;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AddressRelateTypeEnum implements BaseEnum<AddressRelateTypeEnum, Short>, IEnum<Short> {

    BASE_ADDRESS(new Short("1"),"BASE_ADDRESS","基地地址"),
    LOT_ADDRESS(new Short("2"),"LOT_ADDRESS","地块地址"),
    COMPANY_ADDRESS(new Short("3"),"COMPANY_ADDRESS","公司地址"),
    REGIST_ADDRESS(new Short("4"),"REGIST_ADDRESS","公司注册地址"),
    LEGAL_ADDRESS(new Short("5"),"LEGAL_ADDRESS","法人地址"),
    USER_ADDRESS(new Short("6"),"USER_ADDRESS","用户地址"),
    COMPANY_BUSINESS_ADDRESS(new Short("7"),"COMPANY_BUSINESS_ADDRESS","经营地址"),
    MEMBER_ADDRESS(new Short("8"),"MEMBER_ADDRESS","社员地址");

    private Short value;
    private String code;
    private String displayName;

    AddressRelateTypeEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static AddressRelateTypeEnum getByValue(Short value){
        AddressRelateTypeEnum addressRelateTypeEnums[] = AddressRelateTypeEnum.values();
        for(AddressRelateTypeEnum addressRelateTypeEnum : addressRelateTypeEnums){
            if(addressRelateTypeEnum.getValue().equals(value)){
                return addressRelateTypeEnum;
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
