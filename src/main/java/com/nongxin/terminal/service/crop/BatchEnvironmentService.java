package com.nongxin.terminal.service.crop;

import com.nongxin.terminal.entity.crop.BatchEnvironment;

public interface BatchEnvironmentService {

    boolean add(BatchEnvironment batchEnvironment);

    BatchEnvironment selectByBatchId(Integer batchId);

    //根据追溯码查询种植批次环境值
    BatchEnvironment selectByRetroCode(String retroCode);

}
