package com.nongxin.terminal.service.traceability;

import com.nongxin.terminal.entity.traceability.TraceCount;

public interface TraceCountService {

    boolean insert(String retroCode);

    boolean updateCount(String retroCode);

    boolean isExist(String retroCode);

    TraceCount getTotalByRetroCode(String retroCode);
}
