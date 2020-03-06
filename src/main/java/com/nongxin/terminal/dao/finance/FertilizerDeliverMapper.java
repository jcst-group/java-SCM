package com.nongxin.terminal.dao.finance;

import com.nongxin.terminal.entity.finance.FertilizerDeliver;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface FertilizerDeliverMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FertilizerDeliver record);

    int insertSelective(FertilizerDeliver record);

    FertilizerDeliver selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FertilizerDeliver record);

    int updateByPrimaryKey(FertilizerDeliver record);

    BigDecimal getCount(@Param("fertilizerId") Integer fertilizerId, @Param("id") Integer id);

    List<FertilizerDeliver> getFertilizerDeliver(@Param("fertilizerId") Integer fertilizerId);

}