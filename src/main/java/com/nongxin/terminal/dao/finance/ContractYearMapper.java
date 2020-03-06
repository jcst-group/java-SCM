package com.nongxin.terminal.dao.finance;

import com.nongxin.terminal.entity.finance.ContractYear;

import java.util.List;

public interface ContractYearMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContractYear record);

    int insertSelective(ContractYear record);

    ContractYear selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContractYear record);

    int updateByPrimaryKey(ContractYear record);

    List<ContractYear> getContractYear();

    ContractYear selectByYear(String year);
}