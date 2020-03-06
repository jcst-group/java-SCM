package com.nongxin.terminal.dao.finance;

import com.nongxin.terminal.entity.finance.LoanContract;

import java.util.List;
import java.util.Map;

public interface LoanContractMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoanContract record);

    int insertSelective(LoanContract record);

    LoanContract selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanContract record);

    int updateByPrimaryKey(LoanContract record);

    List<LoanContract> getLoanContract(Integer yearId);

    List<Map<String,Object>> getBoardLoanContract();

}