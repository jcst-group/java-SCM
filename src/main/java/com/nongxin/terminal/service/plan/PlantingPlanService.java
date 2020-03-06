package com.nongxin.terminal.service.plan;

import com.nongxin.terminal.entity.plant.PlantingPlan;

import java.util.List;

public interface PlantingPlanService {

    boolean add(PlantingPlan plantingPlan);

    boolean delete(Integer id);

    boolean update(PlantingPlan plantingPlan);

    List<PlantingPlan> getPlantingPlanList(String planName, Integer cropId);

    boolean copyPlan(Integer id,String planName);

}
