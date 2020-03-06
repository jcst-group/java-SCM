package com.nongxin.terminal.dao.illness;

import com.nongxin.terminal.entity.illness.TreatmentPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TreatmentPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TreatmentPlan record);

    int insertSelective(TreatmentPlan record);

    TreatmentPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TreatmentPlan record);

    int updateByPrimaryKey(TreatmentPlan record);

    List<TreatmentPlan> selectByIllId(TreatmentPlan treatmentPlan);

    TreatmentPlan selectByPlanName(@Param("planName") String planName,@Param("illId") Integer illId);
}