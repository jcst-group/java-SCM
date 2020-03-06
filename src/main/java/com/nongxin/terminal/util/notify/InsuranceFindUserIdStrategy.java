package com.nongxin.terminal.util.notify;

import com.nongxin.terminal.entity.scfinance.insurance.InsuranceOrder;
import com.nongxin.terminal.entity.scfinance.insurance.InsuranceOrderMessage;
import com.nongxin.terminal.service.scfinance.insurance.impl.InsuranceOrderServiceImpl;
import com.nongxin.terminal.util.enumUtil.scfinance.InsuranceStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class InsuranceFindUserIdStrategy implements FindUserIdStrategy{

    @Autowired
    private InsuranceOrderServiceImpl insuranceOrderService;

    private static final List<InsuranceStatusEnum> notifyFinanceUserEnum =  new ArrayList<InsuranceStatusEnum>(Arrays.asList(
            InsuranceStatusEnum.REJECT,
            InsuranceStatusEnum.FINISH,
            InsuranceStatusEnum.ACCEPT,
            InsuranceStatusEnum.EXPIRE
    ));

    private static final List<InsuranceStatusEnum> notifyInsuranceUserEnum =  new ArrayList<InsuranceStatusEnum>(Arrays.asList(
            InsuranceStatusEnum.APPLYING
    ));

    @Override
    public List<Integer> getUserId(InsuranceOrderMessage message) {
        List<Integer> notifyIds = new ArrayList<>();

        Integer relateId = Optional.ofNullable(message.getRelateId()).orElse(0);
        InsuranceOrder insuranceOrder = insuranceOrderService.getById(relateId);

        if(insuranceOrder!=null){
            InsuranceStatusEnum orderStatus = insuranceOrder.getOrderStatus();
            if(notifyFinanceUserEnum.contains(orderStatus)){
                notifyIds.add(Optional.ofNullable(insuranceOrder.getFinanceUserId()).orElse(SearchUserIdContext.UNNITIFY_CODE));
            }
            if(notifyInsuranceUserEnum.contains(orderStatus)){
                notifyIds.add(Optional.ofNullable(insuranceOrder.getInsuranceId()).orElse(SearchUserIdContext.UNNITIFY_CODE));
            }
        }

        return notifyIds;
    }
}
