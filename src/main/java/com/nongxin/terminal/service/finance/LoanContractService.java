package com.nongxin.terminal.service.finance;

import com.nongxin.terminal.entity.finance.LoanContract;

import java.util.List;
import java.util.Map;

public interface LoanContractService {

    boolean add(LoanContract loanContract);

    boolean delete(Integer id);

    boolean update(LoanContract loanContract);

    List<LoanContract> getLoanContractList(Integer yearId);

    //获取金融看板贷款数据
    List<Map<String,Object>> getBoardLoanContract();

}
