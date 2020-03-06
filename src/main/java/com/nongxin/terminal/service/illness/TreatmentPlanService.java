package com.nongxin.terminal.service.illness;

import com.nongxin.terminal.entity.illness.TreatmentPlan;

import java.util.List;

public interface TreatmentPlanService {

    List<TreatmentPlan> selectByIllId(TreatmentPlan treatmentPlan);

}
