package com.nongxin.terminal.dao.finance;

import com.nongxin.terminal.entity.finance.BasePurchase;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface BasePurchaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasePurchase record);

    int insertSelective(BasePurchase record);

    BasePurchase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasePurchase record);

    int updateByPrimaryKey(BasePurchase record);

    List<BasePurchase> getBasePurchase(@Param("yearId")Integer yearId);

    BigDecimal getAcreageSum(@Param("baseId") Integer baseId);

}