package com.nongxin.terminal.dao.finance;

import com.nongxin.terminal.entity.finance.FertilizerPurchase;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FertilizerPurchaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FertilizerPurchase record);

    int insertSelective(FertilizerPurchase record);

    FertilizerPurchase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FertilizerPurchase record);

    int updateByPrimaryKey(FertilizerPurchase record);

    List<FertilizerPurchase> getFertilizerPurchase(@Param("yearId") Integer yearId);

    List<Map<String,Object>> getBoardFertilizerPurchase();

}