package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.PlanYear;

import java.util.List;

public interface PlanYearMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlanYear record);

    int insertSelective(PlanYear record);

    PlanYear selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlanYear record);

    int updateByPrimaryKey(PlanYear record);

    List<PlanYear> getPlanYearByPlanId(Integer planId);

    List<PlanYear> selectByPlanId(Integer planId);

    Integer getLastYearByPlanId(Integer planId);
}