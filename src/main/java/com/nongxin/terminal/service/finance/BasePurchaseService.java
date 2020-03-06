package com.nongxin.terminal.service.finance;

import com.nongxin.terminal.entity.finance.BasePurchase;
import com.nongxin.terminal.support.BaseException;

import java.util.List;
import java.util.Map;

public interface BasePurchaseService {

    boolean add(BasePurchase basePurchase);

    boolean delete(Integer id);

    boolean update(BasePurchase basePurchase);

    List<BasePurchase> getBasePurchaseList(Integer yearId);

    //获取看板金融板块基地订单数据
    Map<String,Object> boardBasePurchase(Integer baseId);

}
