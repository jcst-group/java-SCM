package com.nongxin.terminal.util.enumUtil.file;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.config.BaseEnum;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FileRelationTypeEnum implements BaseEnum<FileRelationTypeEnum, Short>, IEnum<Short> {

    SEED_DETECTION(new Short("1"),"SEED_DETECTION","种子检测文件"),
    MATERIALINFO(new Short("2"),"MATERIALINFO","物料信息文件"),
    WORKORDER(new Short("3"),"WORKORDER","工单音频"),
    VIDEOCOMPANY(new Short("4"),"VIDEOCOMPANY","公司介绍视频"),
    VIDEOPRODUCT(new Short("5"),"VIDEOPRODUCT","产品介绍视频"),
    ORDER_APPLY(new Short("6"),"ORDER_APPLY","工单申请音频"),


    INSURANCE_ORDER(new Short("42"),"INSURANCE_ORDER","保险保单资料"),
    LOAN_RELATE_FILE(new Short("44"),"LOAN_RELATE_FILE","贷款申请相关资料"),
    WARRANT_APPLYED_FILE(new Short("45"),"WARRANT_APPLYED_FILE","拟担保审核通过资料"),
    LOAN_APPLYED_fILE(new Short("46"),"LOAN_APPLYED_fILE","贷款审核通过资料"),
    WARRANT_APPROVED_FILE(new Short("47"),"WARRANT_APPROVED_FILE","担保审批通过后资料"),
    LOAN_APPROVED_FILE(new Short("48"),"LOAN_APPROVED_FILE","贷款审批通过后资料"),

    //检测资料
    DETETCT_APPLY_FILE(new Short("49"),"DETETCT_APPLY_FILE","检测申请资料"),
    DETETCT_RESULT_FILE(new Short("50"),"DETETCT_RESULT_FILE","检测结果资料");

    private Short value;
    private String code;
    private String displayName;

    FileRelationTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static FileRelationTypeEnum getByValue(Short value){
        FileRelationTypeEnum imgRelationTypeEnums[] = FileRelationTypeEnum.values();
        for(FileRelationTypeEnum imgRelationTypeEnum : imgRelationTypeEnums){
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
