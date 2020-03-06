package com.nongxin.terminal.service.finance;

import com.nongxin.terminal.entity.finance.LaborDispatch;

import java.util.List;
import java.util.Map;

public interface LaborDispatchService {

    boolean add(LaborDispatch laborDispatch);

    boolean delete(Integer id);

    boolean update(LaborDispatch laborDispatch);

    List<LaborDispatch> getLaborDispatchList(Integer yearId);

    Map<String,Object> getBoardLaborDispatch();

}
