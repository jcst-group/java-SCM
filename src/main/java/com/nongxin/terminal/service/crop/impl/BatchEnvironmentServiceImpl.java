package com.nongxin.terminal.service.crop.impl;

import com.nongxin.terminal.dao.crop.BatchEnvironmentMapper;
import com.nongxin.terminal.entity.crop.BatchEnvironment;
import com.nongxin.terminal.service.crop.BatchEnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class BatchEnvironmentServiceImpl implements BatchEnvironmentService {

    @Autowired(required = false)
    private BatchEnvironmentMapper batchEnvironmentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(BatchEnvironment batchEnvironment) {
        try {
            batchEnvironmentMapper.deleteByBatchId(batchEnvironment.getBatchId());
            return batchEnvironmentMapper.insertSelective(batchEnvironment)==1;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public BatchEnvironment selectByBatchId(Integer batchId) {
        return batchEnvironmentMapper.selectByBatchId(batchId);
    }

    @Override
    public BatchEnvironment selectByRetroCode(String retroCode) {
        return batchEnvironmentMapper.selectByRetroCode(retroCode);
    }
}
