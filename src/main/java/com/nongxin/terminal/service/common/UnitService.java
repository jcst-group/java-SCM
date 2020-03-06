package com.nongxin.terminal.service.common;

import com.nongxin.terminal.entity.common.Unit;

import java.util.List;

public interface UnitService {

    List<Unit> getUnit(String displayName);

}
