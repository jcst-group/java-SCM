package com.nongxin.terminal.entity.plant;

import com.nongxin.terminal.util.enumUtil.plan.PlanYearEnum;

import javax.validation.constraints.NotNull;
import java.util.List;

public class PlanYear {
    private Integer id;

    //@NotNull(message = "年不能为空")
    private PlanYearEnum year;

    @NotNull(message = "种植计划id不能为空")
    private Integer planId;

    private List<Farming> farmingList;

    public List<Farming> getFarmingList() {
        return farmingList;
    }

    public void setFarmingList(List<Farming> farmingList) {
        this.farmingList = farmingList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PlanYearEnum getYear() {
        return year;
    }

    public void setYear(PlanYearEnum year) {
        this.year = year;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }
}