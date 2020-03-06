package com.nongxin.terminal.service.illness.impl;

import com.nongxin.terminal.dao.illness.TreatmentPlanMapper;
import com.nongxin.terminal.entity.illness.TreatmentPlan;
import com.nongxin.terminal.service.illness.TreatmentPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentPlanServiceImpl implements TreatmentPlanService {

    @Autowired(required = false)
    private TreatmentPlanMapper treatmentPlanMapper;

    @Override
    public List<TreatmentPlan> selectByIllId(TreatmentPlan treatmentPlan) {
        return treatmentPlanMapper.selectByIllId(treatmentPlan);
    }
}
