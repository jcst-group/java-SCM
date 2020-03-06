package com.nongxin.terminal.dao.scfinance.loan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.entity.scfinance.insurance.LoanFinanceApply;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author clover
 * @since 2019-12-18
 */
public interface LoanFinanceApplyMapper extends BaseMapper<LoanFinanceApply> {


    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="finance_user_id",property="financeUserId"),
            @Result(column="guarantee_id",property="guaranteeId"),
            @Result(column="bank_id",property="bankId"),
            //合作社信息
            @Result(property = "coperativeUser",column = "finance_user_id",
                    one = @One(select = "com.nongxin.terminal.dao.scfinance.detection.FinanceUserMapper.queryFinanceUserById")),
            //担保
            @Result(property = "guaranteeUser",column = "guarantee_id",
                    one = @One(select = "com.nongxin.terminal.dao.scfinance.detection.FinanceUserMapper.queryFinanceUserById")),
            //保险公司信息
            @Result(property = "bankUser",column = "bank_id",
                    one = @One(select = "com.nongxin.terminal.dao.scfinance.detection.FinanceUserMapper.queryFinanceUserById")),
            //种植贷款信息
            @Result(property = "loanBatchInfo",column = "id",
            one = @One(select = "com.nongxin.terminal.dao.scfinance.loan.LoanBatchInfoMapper.queryPlantInfoByloanApplyId")),

            //提交的相关材料
            @Result(property = "relatePics",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getLoanRelatePics")),
            //提交的担保审核图片
            @Result(property = "warrantApplyedPics",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getWarrantApplyPics")),
            //贷款银行审核图片
            @Result(property = "loanApplyedPics",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getBankApplyPics")),
            //提交的担保审批图片
            @Result(property = "warrantApprovedPics",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getWarrantApprovePics")),
            //提交的贷款银行审批图片
            @Result(property = "loanApprovedPics",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.file.PictureInfoMapper.getBankApprovePics")),
            @Result(property = "messages",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.insurance.InsuranceOrderMessageMapper.queryLoanApplyRelMessges")),

            @Result(property = "relateFiles",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.system.FinanceFileInfoMapper.getLoanRelate")),

            @Result(property = "warrantApplyFiles",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.system.FinanceFileInfoMapper.getWarrantApply")),

            @Result(property = "loanApplyFiles",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.system.FinanceFileInfoMapper.getLoanApply")),

            @Result(property = "warrantApproveFiles",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.system.FinanceFileInfoMapper.getWarrantApprove")),

            @Result(property = "loanAproveFiles",column = "id",
                    many = @Many(select = "com.nongxin.terminal.dao.scfinance.system.FinanceFileInfoMapper.getLoanApprove")),
    })
    @Select(
            "select * from loan_finance_apply "
                    + "${ew.customSqlSegment}"
    )
    IPage<LoanFinanceApply> applyList(Page page, @Param("ew") QueryWrapper<LoanFinanceApply> wrapper);


    @Results({
            @Result(id = true, column = "id", property = "id"),
            //种植贷款信息
            @Result(property = "loanBatchInfo", column = "id",
                    one = @One(select = "com.nongxin.terminal.dao.scfinance.loan.LoanBatchInfoMapper.queryPlantInfoByloanApplyId"))
    })
    @Select(
            "select * from Loan_finance_apply "
                    + "${ew.customSqlSegment}"
    )
    LoanFinanceApply queryOneForExecuteDetail(QueryWrapper<LoanFinanceApply> wrapper);
}
