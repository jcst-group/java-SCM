package com.nongxin.terminal.dao.processing;

import com.nongxin.terminal.entity.processing.ProcessingMethods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessingMethodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProcessingMethods record);

    int insertSelective(ProcessingMethods record);

    ProcessingMethods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProcessingMethods record);

    int updateByPrimaryKey(ProcessingMethods record);

    List<ProcessingMethods> getProcessingMethods(@Param("cropId") Integer cropId);

    List<ProcessingMethods> getAllProcessingMethods();

    List<ProcessingMethods> selectByCropId(Integer cropId);

    List<ProcessingMethods> selectByInitPro(Integer initProId);
}