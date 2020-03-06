package com.nongxin.terminal.dao.finance;

import com.nongxin.terminal.entity.finance.PledgeGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PledgeGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PledgeGoods record);

    int insertSelective(PledgeGoods record);

    PledgeGoods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PledgeGoods record);

    int updateByPrimaryKey(PledgeGoods record);

    List<PledgeGoods> getPledgeGoods(@Param("yearId") Integer yearId);

    Map<String,Object> getBoardPledgeGoods(@Param("baseId")Integer baseId);

}