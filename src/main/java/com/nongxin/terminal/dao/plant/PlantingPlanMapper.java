package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.PlantingPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlantingPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlantingPlan record);

    int insertSelective(PlantingPlan record);

    PlantingPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlantingPlan record);

    int updateByPrimaryKey(PlantingPlan record);

    List<PlantingPlan> getPlantingPlanList(@Param("planName")String planName,@Param("cropId")Integer cropId);

    PlantingPlan getPlanById(Integer id);
}