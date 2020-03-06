package com.nongxin.terminal.dao.finance;

import com.nongxin.terminal.entity.finance.OrderContract;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderContractMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderContract record);

    int insertSelective(OrderContract record);

    OrderContract selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderContract record);

    int updateByPrimaryKey(OrderContract record);

    List<OrderContract> getOrderContract(@Param("yearId")Integer yearId);

    List<Map<String,Object>> getBoardOrderContract();

}