package com.nongxin.terminal.service.plan.impl;

import com.nongxin.terminal.dao.plant.PlanYearMapper;
import com.nongxin.terminal.entity.plant.PlanYear;
import com.nongxin.terminal.service.plan.PlanYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanYearServiceImpl implements PlanYearService {

    @Autowired(required = false)
    private PlanYearMapper planYearMapper;

    @Override
    public boolean add(PlanYear planYear) {
        return planYearMapper.insertSelective(planYear)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return planYearMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public List<PlanYear> getPlanYearByPlanId(Integer planId) {
        return planYearMapper.getPlanYearByPlanId(planId);
    }
}
