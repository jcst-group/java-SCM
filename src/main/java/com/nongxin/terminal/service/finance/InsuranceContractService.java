package com.nongxin.terminal.service.finance;

import com.nongxin.terminal.entity.finance.InsuranceContract;

import java.util.List;
import java.util.Map;

public interface InsuranceContractService {

    boolean add(InsuranceContract insuranceContract);

    boolean delete(Integer id);

    boolean update(InsuranceContract insuranceContract);

    List<InsuranceContract> getInsuranceContractList(Integer yearId);

    //获取金融板块保险数据
    Map<String,Object> getBoardInsuranceContract(Integer baseId);

}
