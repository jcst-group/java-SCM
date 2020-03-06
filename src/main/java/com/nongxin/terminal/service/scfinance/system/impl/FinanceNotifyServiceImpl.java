package com.nongxin.terminal.service.scfinance.system.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nongxin.terminal.dao.scfinance.system.FinanceNotifyMapper;
import com.nongxin.terminal.entity.scfinance.insurance.FinanceNotify;
import com.nongxin.terminal.entity.scfinance.insurance.InsuranceOrderMessage;
import com.nongxin.terminal.service.scfinance.system.IFinanceNotifyService;
import com.nongxin.terminal.util.enumUtil.scfinance.MessageRelateTypeEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.TrueOrFalseEnum;
import com.nongxin.terminal.util.notify.FindUserIdStrategy;
import com.nongxin.terminal.util.notify.SearchUserIdContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clover
 * @since 2019-12-31
 */
@Service
public class FinanceNotifyServiceImpl extends ServiceImpl<FinanceNotifyMapper, FinanceNotify> implements IFinanceNotifyService {


    private SearchUserIdContext userIdContext;

    
    public boolean saveNotify(InsuranceOrderMessage message){

        boolean save = false;

        MessageRelateTypeEnum relateType = message.getRelateType();
        FindUserIdStrategy strategyByMessageType = SearchUserIdContext.getStrategyByMessageType(relateType);

        if(strategyByMessageType!=null){
            userIdContext = new SearchUserIdContext(strategyByMessageType);
            List<Integer> userIds = userIdContext.getUserId(message);
            if(userIds!=null && userIds.size()>0){
                for(Integer userId:userIds){
                    FinanceNotify financeNotify = new FinanceNotify();
                    financeNotify.setFinanceUserId(userId);
                    financeNotify.setMessageType(relateType);
                    financeNotify.setTitile(message.getMessageStatus().getDisplayName());
                    financeNotify.setIfRead(TrueOrFalseEnum.FALSE);
                    financeNotify.setContent(Optional.ofNullable(message.getCommont()).orElse(""));
                    financeNotify.setIntOne(message.getRelateId());
                    //financeNotify.setCharOne();
                    save = save(financeNotify);
                }

            }

        }
        return save;
    }

}
