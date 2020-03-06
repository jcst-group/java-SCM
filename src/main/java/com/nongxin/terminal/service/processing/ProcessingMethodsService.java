package com.nongxin.terminal.service.processing;

import com.nongxin.terminal.entity.processing.ProcessingMethods;

import java.util.List;

public interface ProcessingMethodsService {

    boolean add(ProcessingMethods processingMethods);

    boolean delete(Integer id);

    boolean update(ProcessingMethods processingMethods);

    List<ProcessingMethods> getProcessingMethods(Integer cropId);

    List<ProcessingMethods> getAllProcessingMethods();

    List<ProcessingMethods> selectByCropId(Integer cropId);

}
