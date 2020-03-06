package com.nongxin.terminal.service.plan;

import com.nongxin.terminal.entity.plant.PlanYear;

import java.util.List;

public interface PlanYearService {

    boolean add(PlanYear planYear);

    boolean delete(Integer id);

    List<PlanYear> getPlanYearByPlanId(Integer planId);

}
