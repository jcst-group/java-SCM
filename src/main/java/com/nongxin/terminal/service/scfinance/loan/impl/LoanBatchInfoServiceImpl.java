package com.nongxin.terminal.service.scfinance.loan.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nongxin.terminal.dao.scfinance.loan.LoanBatchInfoMapper;
import com.nongxin.terminal.dao.scfinance.loan.LoanBatchMemberRelMapper;
import com.nongxin.terminal.entity.scfinance.insurance.LoanBatchInfo;
import com.nongxin.terminal.entity.scfinance.insurance.LoanBatchMemberRel;
import com.nongxin.terminal.entity.scfinance.system.FinanceMember;
import com.nongxin.terminal.service.scfinance.loan.ILoanBatchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clover
 * @since 2019-12-18
 */
@Service
public class LoanBatchInfoServiceImpl extends ServiceImpl<LoanBatchInfoMapper, LoanBatchInfo> implements ILoanBatchInfoService {


    @Autowired
    private LoanBatchMemberRelMapper loanBatchMemberRelMapper;


    /**
     * 保存关联信息，以及关联信息和社员对应信息
     * @param loanBatchInfo
     * @return
     */
    public boolean saveOrUpdateLoanBatchInfo(LoanBatchInfo loanBatchInfo){
        boolean success = false;

        if(loanBatchInfo== null){
            throw new RuntimeException("贷款关联信息不能为空");
        }



        List<FinanceMember> financeMembers = loanBatchInfo.getFinanceMembers();
        if(financeMembers == null){
            financeMembers = new ArrayList<>();
        }
        List<Integer> memberIds = financeMembers.stream().map(x -> x.getId()).collect(Collectors.toList());
        //保存关联信息
        success = super.saveOrUpdate(loanBatchInfo);

        Integer infoId = loanBatchInfo.getId();

        /**
         * 删除旧的与社员关联信息
         */
        QueryWrapper<LoanBatchMemberRel> queryWrapper = new QueryWrapper();
        queryWrapper.eq("info_id",infoId);
        int delete = loanBatchMemberRelMapper.delete(queryWrapper);

        /**
         * 保存新的社员关联关系
         */
        for(Integer memberId:memberIds) {
            LoanBatchMemberRel loanBatchMemberRel = new LoanBatchMemberRel();
            loanBatchMemberRel.setInfoId(infoId);
            loanBatchMemberRel.setMemberId(memberId);
            int insert = loanBatchMemberRelMapper.insert(loanBatchMemberRel);
        }
        success = true;

        return success;
    }

//    public boolean saveOrUpdateCalItem(){
//        success
//
//        return
//    }

}
