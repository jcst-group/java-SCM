package com.nongxin.terminal.service.finance;

import com.nongxin.terminal.entity.finance.OrderContract;

import java.util.List;
import java.util.Map;

public interface OrderContractService {

    boolean add(OrderContract orderContract);

    boolean delete(Integer id);

    boolean update(OrderContract orderContract);

    List<OrderContract> getOrderContractList(Integer yearId);

    //获取金融板块订单采购数据
    List<Map<String,Object>> getBoardOrderContract();

}
