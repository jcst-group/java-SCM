package com.nongxin.terminal.service.scfinance.insurance.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nongxin.terminal.dao.scfinance.insurance.InsuranceOrderMessageMapper;
import com.nongxin.terminal.entity.scfinance.insurance.InsuranceOrderMessage;
import com.nongxin.terminal.service.scfinance.insurance.IInsuranceOrderMessageService;
import com.nongxin.terminal.service.scfinance.system.impl.FinanceNotifyServiceImpl;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.scfinance.MessageRelateTypeEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.MessageStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clover
 * @since 2019-12-16
 */
@Service
public class InsuranceOrderMessageServiceImpl extends ServiceImpl<InsuranceOrderMessageMapper, InsuranceOrderMessage> implements IInsuranceOrderMessageService {



    @Autowired
    private FinanceNotifyServiceImpl financeNotifyService;

    public boolean insertRelateMessage(Integer relateId,
                                       MessageRelateTypeEnum relateTypeEnum,
                                       MessageStatusEnum statusEnum,
                                       String message){
        InsuranceOrderMessage orderMessage = new InsuranceOrderMessage();
        orderMessage.setRelateUserId(JwtUtil.queryFnanceUserId());
        orderMessage.setRelateId(relateId);
        orderMessage.setMessageStatus(statusEnum);
        orderMessage.setRelateType(relateTypeEnum);
        orderMessage.setCreateTime(new Date());
        orderMessage.setCommont(message);
        boolean save = save(orderMessage);

        try {
            financeNotifyService.saveNotify(orderMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return save;
    }


}
