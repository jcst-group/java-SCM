package com.nongxin.terminal.util.enumUtil.crop;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BatchStatusEnum implements BaseEnum<BatchStatusEnum, Short>, IEnum<Short> {

    NOT_USED(new Short("1"),"NOT_USED","未使用"),
    IN_USED(new Short("2"),"IN_USED","使用中"),
    COMPLETED(new Short("3"),"COMPLETED","已完成");

    private Short value;
    private String code;
    private String displayName;

    BatchStatusEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static BatchStatusEnum getByValue(Short value){
        BatchStatusEnum baseTypeEnums[] = BatchStatusEnum.values();
        for(BatchStatusEnum baseTypeEnum : baseTypeEnums){
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
