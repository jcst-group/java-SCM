package com.nongxin.terminal.dao.crop;

import com.nongxin.terminal.entity.crop.BatchEnvironment;

public interface BatchEnvironmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BatchEnvironment record);

    int insertSelective(BatchEnvironment record);

    BatchEnvironment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BatchEnvironment record);

    int updateByPrimaryKey(BatchEnvironment record);

    int deleteByBatchId(Integer batchId);

    BatchEnvironment selectByBatchId(Integer batchId);

    BatchEnvironment selectByRetroCode(String retroCode);
}