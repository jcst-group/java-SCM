package com.nongxin.terminal.util.enumUtil.plan;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum WorkOrderTypeEnum implements BaseEnum<WorkOrderTypeEnum, Short>, IEnum<Short> {

    ORDINARY(new Short("1"),"ORDINARY","普通工单"),
    TEMPORARY(new Short("2"),"TEMPORARY","临时工单");

    private Short value;
    private String code;
    private String displayName;

    WorkOrderTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static WorkOrderTypeEnum getByValue(Short value){
        WorkOrderTypeEnum baseTypeEnums[] = WorkOrderTypeEnum.values();
        for(WorkOrderTypeEnum baseTypeEnum : baseTypeEnums){
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
