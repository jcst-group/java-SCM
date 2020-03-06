package com.nongxin.terminal.entity.plant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.util.enumUtil.plan.PrepareTypeEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class PrepareItem {
    private Integer id;

    private Integer cropBatchId;

    private Integer farmingItemId;

    @NotNull(message = "开始时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startTime;

    @NotNull(message = "结束时间不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endTime;

    private Short minPerson;

    private String materialName;

    private String company;

    private Integer num;

    private BigDecimal budgetCosts;

    @NotNull(message = "到位日期不能为空")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date inplaceTime;

    private FarmingItem farmingItem;

    private Integer workOrderId;

    private PrepareTypeEnum type;

    public PrepareTypeEnum getType() {
        return type;
    }

    public void setType(PrepareTypeEnum type) {
        this.type = type;
    }

    public Integer getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Integer workOrderId) {
        this.workOrderId = workOrderId;
    }

    public FarmingItem getFarmingItem() {
        return farmingItem;
    }

    public void setFarmingItem(FarmingItem farmingItem) {
        this.farmingItem = farmingItem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCropBatchId() {
        return cropBatchId;
    }

    public void setCropBatchId(Integer cropBatchId) {
        this.cropBatchId = cropBatchId;
    }

    public Integer getFarmingItemId() {
        return farmingItemId;
    }

    public void setFarmingItemId(Integer farmingItemId) {
        this.farmingItemId = farmingItemId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Short getMinPerson() {
        return minPerson;
    }

    public void setMinPerson(Short minPerson) {
        this.minPerson = minPerson;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getBudgetCosts() {
        return budgetCosts;
    }

    public void setBudgetCosts(BigDecimal budgetCosts) {
        this.budgetCosts = budgetCosts;
    }

    public Date getInplaceTime() {
        return inplaceTime;
    }

    public void setInplaceTime(Date inplaceTime) {
        this.inplaceTime = inplaceTime;
    }
}