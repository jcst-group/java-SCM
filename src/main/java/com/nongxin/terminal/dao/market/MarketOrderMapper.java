package com.nongxin.terminal.dao.market;

import com.nongxin.terminal.entity.market.MarketOrder;
import com.nongxin.terminal.entity.market.MarketOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarketOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MarketOrder record);

    int insertSelective(MarketOrder record);

    List<MarketOrder> selectByExample(MarketOrderExample example);

    MarketOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MarketOrder record, @Param("example") MarketOrderExample example);

    int updateByExample(@Param("record") MarketOrder record, @Param("example") MarketOrderExample example);

    int updateByPrimaryKeySelective(MarketOrder record);

    int updateByPrimaryKey(MarketOrder record);
}