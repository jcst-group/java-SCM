package com.nongxin.terminal.util.notify;

import com.nongxin.terminal.entity.scfinance.insurance.InsuranceOrderMessage;

import java.util.List;

public interface FindUserIdStrategy {

    /**
     * 通过一个message对象获得需要的信息，message对象有message通知类型，message通知状态，关联ID
     * @param message
     * @return
     */
    List<Integer> getUserId(InsuranceOrderMessage message);

}
