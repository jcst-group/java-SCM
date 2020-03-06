package com.nongxin.terminal.dao.finance;

import com.nongxin.terminal.entity.finance.InsuranceContract;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface InsuranceContractMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InsuranceContract record);

    int insertSelective(InsuranceContract record);

    InsuranceContract selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InsuranceContract record);

    int updateByPrimaryKey(InsuranceContract record);

    List<InsuranceContract> getInsuranceContract(@Param("yearId") Integer yearId);

    Map<String,Object> getBoardInsuranceContract(@Param("baseId")Integer baseId);

}