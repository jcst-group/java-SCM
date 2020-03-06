package com.nongxin.terminal.util.enumUtil.scfinance;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LoanApplyStatusEnum implements IEnum<Short> {
    SAVE(new Short("1"),"SAVE","已保存"),
    WARRANT_APPLY(new Short("2"),"WARRANT_APPLY","拟担保函确认"),
    LOAN_APPLY(new Short("3"),"LOAN_APPLY","贷款审核"),
    WARRANT_APPROVE(new Short("4"),"WARRANT_APPROVE","担保函确认"),
    LOAN_APPROVE(new Short("5"),"LOAN_APPROVE","贷款审批"),
    LOAN_GRANT(new Short("6"),"LOAN_GRANT","贷款发放"),
    FINISH(new Short("7"),"FINISH","贷款完成"),
    CANCEL(new Short("8"),"CANCEL","贷款取消"),
    FAIL_APPLY(new Short("9"),"FAIL_APPLY","申请失败");
    private Short value;
    private String code;
    private String displayName;

    LoanApplyStatusEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static LoanApplyStatusEnum getByValue(Short value){
        LoanApplyStatusEnum enums[] = LoanApplyStatusEnum.values();
        for(LoanApplyStatusEnum e : enums){
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
