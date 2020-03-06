package com.nongxin.terminal.util.enumUtil.scfinance;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MessageStatusEnum implements IEnum<Short> {

    ORDER_CREATE(new Short("1"),"ORDER_CREATE","保险保单创建"),
    ORDER_APPLY(new Short("2"),"ORDER_APPLY","保险保单申请"),
    ORDER_ACCEPT(new Short("3"),"ORDER_ACCEPT","保险保单受保"),
    ORDER_FINISH(new Short("4"),"ORDER_FINISH","保险保单完成"),
    ORDER_REJECT(new Short("5"),"ORDER_REJECT","保险保单拒保"),
    ORDER_CANCEL(new Short("6"),"ORDER_CANCEL","保险保单取消申请"),


    LOAN_SAVE(new Short("7"),"LOAN_SAVE","贷款申请创建"),
    LOAN_APPLY_SEND(new Short("20"),"LOAN_APPLY_SEND","贷款申请发起"),

    LOAN_WARRANT_APPLY(new Short("8"),"LOAN_WARRANT_APPLY","贷款申请拟担保申请"),
    LOAN_APPLY(new Short("9"),"LOAN_APPLY","贷款申请银行审核"),
    LOAN_WARRANT_APPROVE(new Short("10"),"LOAN_WARRANT_APPROVE","贷款申请担保申请"),
    LOAN_APPROVE(new Short("11"),"LOAN_APPROVE","贷款申请银行审批"),
    LOAN_GRANT(new Short("12"),"LOAN_GRANT","贷款申请贷款发放"),
    LOAN_FINISH(new Short("13"),"LOAN_FINISH","贷款申请完成"),
    LOAN_CANCEL(new Short("14"),"LOAN_CANCEL","贷款申请取消"),
    LOAN_FAIL_APPLY(new Short("15"),"LOAN_FAIL_APPLY","贷款申请申请失败"),

    LOAN_WARRANT_APPLY_FAIL(new Short("16"),"LOAN_WARRANT_APPLY_FAIL","贷款申请拟担保申请失败"),
    LOAN_APPLY_FAIL(new Short("17"),"LOAN_APPLY_FAIL","贷款申请银行审核失败"),
    LOAN_WARRANT_APPROVE_FAIL(new Short("18"),"LOAN_WARRANT_APPROVE_FAIL","贷款申请担保申请失败"),
    LOAN_APPROVE_FAIL(new Short("19"),"LOAN_APPROVE_FAIL","贷款申请银行审批失败"),

    DETECT_CONFIRM_APPLY(new Short("20"),"DETECT_CONFIRM_APPLY","检测机构确认"),
    DETECT_CONFIRM_PASS(new Short("21"),"DETECT_CONFIRM_PASS","检测机构接受委托"),
    DETECT_CONFIRM_REJECT(new Short("22"),"DETECT_CONFIRM_REJECT","检测机构拒绝委托"),
    DETECT_COOPCONFIRM_PASS(new Short("23"),"DETECT_COOPCONFIRM_PASS","合作社接受检测要求"),
    DETECT_COOPCONFIRM_REJECT(new Short("24"),"DETECT_COOPCONFIRM_REJECT","合作社拒绝检测要求"),
    DETECT_FINISH(new Short("25"),"DETECT_FINISH","订单检测申请结束"),
    DETECT_CANCEL(new Short("26"),"DETECT_CANCEL","订单检测取消"),
    DETECT_FAIL(new Short("27"),"DETECT_FAIL","订单检测失败"),
    DETECT_SAVE(new Short("28"),"DETECT_SAVE","检测申请保存");

    private Short value;
    private String code;
    private String displayName;

    MessageStatusEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }


    public static MessageStatusEnum getByValue(Short value){
        MessageStatusEnum enums[] = MessageStatusEnum.values();
        for(MessageStatusEnum e : enums){
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
