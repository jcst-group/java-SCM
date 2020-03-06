package com.nongxin.terminal.util.enumUtil.plan;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum WorkOrderStatusEnum implements BaseEnum<WorkOrderStatusEnum, Short>, IEnum<Short> {

    UNEXECUTED(new Short("1"),"UNEXECUTED","未执行"),
    NOT_AUDITED(new Short("2"),"NOT_AUDITED","待审核"),
    AUDIT_FAILED(new Short("3"),"AUDIT_FAILED","审核未通过"),
    AUDIT_APPROVAL(new Short("4"),"AUDIT_APPROVAL","审核已通过");

    private Short value;
    private String code;
    private String displayName;

    WorkOrderStatusEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static WorkOrderStatusEnum getByValue(Short value){
        WorkOrderStatusEnum baseTypeEnums[] = WorkOrderStatusEnum.values();
        for(WorkOrderStatusEnum baseTypeEnum : baseTypeEnums){
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
