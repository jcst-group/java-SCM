package com.nongxin.terminal.service.system;

import com.nongxin.terminal.entity.system.ConstantStorage;
import com.nongxin.terminal.util.enumUtil.system.ConstantTypeEnum;

public interface ConstantStorageService {

    ConstantStorage selectByType(ConstantTypeEnum type);

}
