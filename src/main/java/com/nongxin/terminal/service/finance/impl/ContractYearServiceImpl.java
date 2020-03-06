package com.nongxin.terminal.service.finance.impl;

import com.nongxin.terminal.dao.finance.ContractYearMapper;
import com.nongxin.terminal.entity.finance.ContractYear;
import com.nongxin.terminal.service.finance.ContractYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractYearServiceImpl implements ContractYearService {

    @Autowired(required = false)
    private ContractYearMapper contractYearMapper;

    @Override
    public List<ContractYear> getContractYear() {
        return contractYearMapper.getContractYear();
    }
}
