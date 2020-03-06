package com.nongxin.terminal.dao.market;

import com.nongxin.terminal.entity.market.MarketPrice;

import java.util.Date;
import java.util.List;

public interface MarketPriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MarketPrice record);

    int insertSelective(MarketPrice record);

    MarketPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MarketPrice record);

    int updateByPrimaryKey(MarketPrice record);


    List<MarketPrice> getDataByParams(Integer breedId, Integer fromType, Integer areaId, Integer specId, Integer dateType, Date startTime, Date endTime);
}