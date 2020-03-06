package com.nongxin.terminal.util.notify;

import com.nongxin.terminal.entity.scfinance.insurance.InsuranceOrderMessage;
import com.nongxin.terminal.entity.scfinance.insurance.LoanFinanceApply;
import com.nongxin.terminal.service.scfinance.loan.impl.LoanFinanceApplyServiceImpl;
import com.nongxin.terminal.util.enumUtil.scfinance.LoanApplyStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class LoanFindUserIdStrategy implements FindUserIdStrategy{

    private static final List<LoanApplyStatusEnum> notifyFinanceUserEnum =  new ArrayList<LoanApplyStatusEnum>(Arrays.asList(
            LoanApplyStatusEnum.FINISH,
            LoanApplyStatusEnum.FAIL_APPLY
    ));

    private static final List<LoanApplyStatusEnum> notifyBankUserEnum =  new ArrayList<LoanApplyStatusEnum>(Arrays.asList(
            LoanApplyStatusEnum.LOAN_APPLY,
            LoanApplyStatusEnum.LOAN_APPROVE
    ));

    private static final List<LoanApplyStatusEnum> notifyWarrantUserEnum =  new ArrayList<LoanApplyStatusEnum>(Arrays.asList(
            LoanApplyStatusEnum.WARRANT_APPLY,
            LoanApplyStatusEnum.WARRANT_APPROVE
    ));



    @Autowired
    private LoanFinanceApplyServiceImpl loanFinanceApplyService;

    @Override
    public List<Integer> getUserId(InsuranceOrderMessage message) {
        List<Integer> notifyIds = new ArrayList<>();

        Integer relateId = Optional.ofNullable(message.getRelateId()).orElse(0);
        LoanFinanceApply loanFinanceApply = loanFinanceApplyService.getById(relateId);
        if (loanFinanceApply!=null) {
            LoanApplyStatusEnum status = loanFinanceApply.getStatus();
            if(notifyFinanceUserEnum.contains(status)){
                notifyIds.add(Optional.ofNullable(loanFinanceApply.getFinanceUserId()).orElse(SearchUserIdContext.UNNITIFY_CODE));
            }
            if(notifyBankUserEnum.contains(status)){
                notifyIds.add(Optional.ofNullable(loanFinanceApply.getBankId()).orElse(SearchUserIdContext.UNNITIFY_CODE));
            }
            if(notifyWarrantUserEnum.contains(status)){
                notifyIds.add(Optional.ofNullable(loanFinanceApply.getGuaranteeId()).orElse(SearchUserIdContext.UNNITIFY_CODE));
            }
        }
        return notifyIds;
    }
}
