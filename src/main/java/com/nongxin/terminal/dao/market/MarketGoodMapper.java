package com.nongxin.terminal.dao.market;

import com.nongxin.terminal.entity.market.MarketGood;
import com.nongxin.terminal.entity.market.MarketGoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarketGoodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MarketGood record);

    int insertSelective(MarketGood record);

    List<MarketGood> selectByExample(MarketGoodExample example);

    MarketGood selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MarketGood record, @Param("example") MarketGoodExample example);

    int updateByExample(@Param("record") MarketGood record, @Param("example") MarketGoodExample example);

    int updateByPrimaryKeySelective(MarketGood record);

    int updateByPrimaryKey(MarketGood record);
}