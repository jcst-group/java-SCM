package com.nongxin.terminal.util.notify;

import com.nongxin.terminal.entity.scfinance.insurance.InsuranceOrderMessage;
import com.nongxin.terminal.support.SpringContextHolder;
import com.nongxin.terminal.util.enumUtil.scfinance.MessageRelateTypeEnum;

import java.util.List;


public class SearchUserIdContext implements FindUserIdStrategy{

    /**
     * 0代表不通知
     */
    public static final Integer UNNITIFY_CODE = 0;

    private FindUserIdStrategy strategy;

    public SearchUserIdContext(FindUserIdStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public List<Integer> getUserId(InsuranceOrderMessage message) {
        return strategy.getUserId(message);
    }


    /**
     * 返回 处理的具体策略，如果没有则返回空
     * @param relateTypeEnum
     * @return
     */
    public static FindUserIdStrategy getStrategyByMessageType(MessageRelateTypeEnum relateTypeEnum){

        if(relateTypeEnum.equals(MessageRelateTypeEnum.BANK_LOAN)){
            return SpringContextHolder.getBean(LoanFindUserIdStrategy.class);
            //return LoanFindUserIdStrategy();
        }

        if(relateTypeEnum.equals(MessageRelateTypeEnum.ORDER_RELATE)){
            return SpringContextHolder.getBean(InsuranceFindUserIdStrategy.class);
            //return new InsuranceFindUserIdStrategy();
        }

        if(relateTypeEnum.equals(MessageRelateTypeEnum.DETECTION_APPLY)){
            return SpringContextHolder.getBean(DetectFindUserIdStrategy.class);
            //return new DetectFindUserIdStrategy();
        }
        return null;
    }

}
