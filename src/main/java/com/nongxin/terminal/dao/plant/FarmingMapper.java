package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.Farming;
import com.nongxin.terminal.util.enumUtil.plan.FarmingTypeEnum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FarmingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Farming record);

    int insertSelective(Farming record);

    Farming selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Farming record);

    int updateByPrimaryKey(Farming record);

    List<Farming>   getFarmingList(@Param("planYearId") Integer planYearId, @Param("farmingName")String farmingName,
                                 @Param("type")FarmingTypeEnum type);

    Farming getFirstByPlantingId(Integer plantingId);

    Farming getLastByPlantingId(Integer plantingId);

    //根据种植批次id查询农事
    List<Farming> getByBatchId(Integer batchId);

    List<Farming> getDataByBatchId(Integer batchId);

    //根据农事id集合查询农事
    List<Farming> getByFarmingIds(@Param("farmingIds") int[] farmingIds);

    List<Farming> selectByPlanYearId(Integer planYearId);

    //根据种植批次id查询临时农事
    List<Farming> getTemporaryByBatchId(@Param("batchId") Integer batchId,@Param("type") FarmingTypeEnum type);

    int updateSequExecute(@Param("id")Integer id,@Param("sequExecute")boolean sequExecute);
}