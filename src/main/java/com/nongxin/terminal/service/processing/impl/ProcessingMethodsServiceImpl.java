package com.nongxin.terminal.service.processing.impl;

import com.nongxin.terminal.dao.processing.ProcessingMethodsMapper;
import com.nongxin.terminal.entity.processing.ProcessingMethods;
import com.nongxin.terminal.service.processing.ProcessingMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessingMethodsServiceImpl implements ProcessingMethodsService {

    @Autowired(required = false)
    private ProcessingMethodsMapper processingMethodsMapper;

    @Override
    public boolean add(ProcessingMethods processingMethods) {
        return processingMethodsMapper.insertSelective(processingMethods)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return processingMethodsMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(ProcessingMethods processingMethods) {
        return processingMethodsMapper.updateByPrimaryKeySelective(processingMethods)==1;
    }

    @Override
    public List<ProcessingMethods> getProcessingMethods(Integer cropId) {
        return processingMethodsMapper.getProcessingMethods(cropId);
    }

    @Override
    public List<ProcessingMethods> getAllProcessingMethods() {
        return processingMethodsMapper.getAllProcessingMethods();
    }

    @Override
    public List<ProcessingMethods> selectByCropId(Integer cropId) {
        return processingMethodsMapper.selectByCropId(cropId);
    }
}
