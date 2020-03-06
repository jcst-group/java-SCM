package com.nongxin.terminal.service.finance;

import com.nongxin.terminal.entity.finance.StandardPlan;
import com.nongxin.terminal.support.BaseException;

import java.util.List;
import java.util.Map;

public interface StandardPlanService {

    boolean add(StandardPlan standardPlan) throws BaseException;

    boolean delete(Integer id);

    boolean update(StandardPlan standardPlan) throws BaseException;

    List<StandardPlan> getStandardPlanList(Integer yearId);

    //获取看板金融板块数据
    Map<String,Object> getBoardStandardPlan(Integer baseId);

}
