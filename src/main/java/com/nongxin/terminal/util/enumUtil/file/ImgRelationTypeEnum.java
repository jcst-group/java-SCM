package com.nongxin.terminal.util.enumUtil.file;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ImgRelationTypeEnum implements BaseEnum<ImgRelationTypeEnum, Short>, IEnum<Short> {

    BASE(new Short("1"),"BASE","基地照片"),
    WATER(new Short("2"),"WATER","水源检测图片"),
    AIR(new Short("3"),"AIR","空气检测图片"),
    SOIL(new Short("4"),"SOIL","土壤检测图片"),
    CROP(new Short("5"),"CROP","作物"),
    EDIBLE_VALUE(new Short("6"),"EDIBLE_VALUE","食用价值"),
    MEDICINAL_VALUE(new Short("7"),"MEDICINAL_VALUE","药用价值"),
    SEED_DETECTION(new Short("8"),"SEED_DETECTION","种子检测图片"),
    FARMING_ITEM(new Short("9"),"FARMING_ITEM","农事项目指导图片"),
    RECOVERY_DETECTION(new Short("10"),"RECOVERY_DETECTION","采收检测"),
    USER_HEAD(new Short("11"),"USER_HEAD","用户头像图片"),
    USER_HUKOU(new Short("12"),"USER_HUKOU","用户户口本图片"),
    IDENTIFY_CODE(new Short("13"),"IDENTIFY_CODE","用户身份证图片"),
    MATERIALINFO(new Short("14"),"MATERIALINFO","物料信息检测图片"),
    FEEDBACK(new Short("15"),"FEEDBACK","巡视反馈图片"),
    WORKORDER(new Short("16"),"WORKORDER","工单图片"),
    SEED_DETECTION_RESULT(new Short("17"),"SEED_DETECTION_RESULT","种子检测结果图片"),
    RECOVERY_DETECTION_RESULT(new Short("18"),"RECOVERY_DETECTION_RESULT","采收检测结果图片"),
    INITPRO_DETECTION(new Short("19"),"INITPRO_DETECTION","初加工检测图片"),
    COMPANY_MANAGER(new Short("20"),"COMPANY_MANAGER","公司管理模式图"),
    COMPANY_HONOR(new Short("21"),"COMPANY_HONOR","公司荣誉模式图"),
    PRO_CROP(new Short("22"),"PRO_CROP","溯源药材图片"),
    PRO_EDIBLE_VALUE(new Short("23"),"PRO_EDIBLE_VALUE","溯源食用价值"),
    PRO_MEDICINAL_VALUE(new Short("24"),"PRO_MEDICINAL_VALUE","溯源药用价值"),
    COMPANY_PROFILE(new Short("25"),"COMPANY_PROFILE","公司简介图"),
    LOT(new Short("26"),"LOT","地块图片"),
    ILL_FEEDBACK(new Short("27"),"ILL_FEEDBACK","病虫害反馈图片"),
    ILL(new Short("28"),"ILL","病虫害图片"),
    TREATMENT_GUI(new Short("29"),"TREATMENT_GUI","病虫害治疗指导图片"),
    BASE_PURCHASE(new Short("30"),"BASE_PURCHASE","订单基地采购合同图片"),
    STANDARD_PLAN(new Short("31"),"STANDARD_PLAN","规范化种植协议图片"),
    FERTILEZER_PURCHASE(new Short("32"),"FERTILEZER_PURCHASE","肥料采购合同图片"),
    LABOR_DISPATCH(new Short("33"),"LABOR_DISPATCH","劳务派遣合同图片"),
    ORDER_CONTRACT(new Short("34"),"ORDER_CONTRACT","订单合同图片"),
    INSURANCE_CONTRACT(new Short("35"),"INSURANCE_CONTRACT","保险合同图片"),
    PLEDGE_GOODS(new Short("36"),"PLEDGE_GOODS","质押物权图片"),
    LOAN_CONTRACT(new Short("37"),"LOAN_CONTRACT","贷款合同图片"),
    FINANCE_BUSINESS(new Short("38"),"FINANCE_BUSINESS","金融营业执照"),
    LEGAL_PERSON(new Short("39"),"LEGAL_PERSON","法人证件"),
    JOIN_SOCIAL(new Short("40"),"JOIN_SOCIAL","入合作社证件"),
    MEMBER_CREDIT(new Short("41"),"MEMBER_CREDIT","社员身份证证件"),
    INSURANCE_ORDER(new Short("42"),"INSURANCE_ORDER","保险保单图片"),
    MEMBER_HEAD(new Short("43"),"MEMBER_HEAD","社员头像图片"),

    LOAN_RELATE_PICTURE(new Short("44"),"LOAN_RELATE_PICTURE","贷款申请相关图片"),
    WARRANT_APPLYED_PIC(new Short("45"),"WARRANT_APPLYED_PIC","拟担保审核通过资料"),
    LOAN_APPLYED_PIC(new Short("46"),"LOAN_APPLYED_PIC","贷款审核通过资料"),
    WARRANT_APPROVED(new Short("47"),"WARRANT_APPROVED","担保审批通过后资料"),
    LOAN_APPROVED(new Short("48"),"LOAN_APPROVED","贷款审批通过后资料"),

    //检测类的图片类型
    DETETCT_APPLY_PIC(new Short("49"),"DETETCT_APPLY_PIC","检测申请图片"),
    DETETCT_RESULT_PIC(new Short("50"),"DETETCT_RESULT_PIC","检测结果图片");

    private Short value;
    private String code;
    private String displayName;

    ImgRelationTypeEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static ImgRelationTypeEnum getByValue(Short value){
        ImgRelationTypeEnum imgRelationTypeEnums[] = ImgRelationTypeEnum.values();
        for(ImgRelationTypeEnum imgRelationTypeEnum : imgRelationTypeEnums){
            if(imgRelationTypeEnum.getValue().equals(value)){
                return imgRelationTypeEnum;
            }
        }
        return null;
    }


    @Override
    public Short getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
