package com.nongxin.terminal.entity.plant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.crop.Crop;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.util.enumUtil.plan.FarmingLocationEnum;
import com.nongxin.terminal.util.enumUtil.plan.FarmingTypeEnum;
import com.nongxin.terminal.util.enumUtil.plan.HouEnum;
import com.nongxin.terminal.util.enumUtil.solar.SolarTermsEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class Farming {
    private Integer id;

    private FarmingLocationEnum isLocation;

    private Integer planYearId;

    private SolarTermsEnum solarTerm;

    private HouEnum hou;

    private Integer farmingItemId;

    @NotNull(message = "农事周期不能为空")
    @Min(value = 1,message = "农事周期必须大于0")
    private short farmingCycle;

    private FarmingItem farmingItem;

    private List<Role> roleList;

    private List<DeviceInfo> deviceInfoList;

    private List<MaterialInfo> materialInfoList;

    private List<PersonnelInfo> personnelInfoList;

    private FarmingTypeEnum type;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startTime;

    private PlanYear planYear;

    private String farmingName;

    private String remark;

    private Integer cropId;

    private Crop crop;

    private Integer totalDevice;

    private Integer totalMaterial;

    private Integer totalPersonnel;

    private boolean sequExecute;

    public Integer getTotalDevice() {
        return totalDevice;
    }

    public void setTotalDevice(Integer totalDevice) {
        this.totalDevice = totalDevice;
    }

    public Integer getTotalMaterial() {
        return totalMaterial;
    }

    public void setTotalMaterial(Integer totalMaterial) {
        this.totalMaterial = totalMaterial;
    }

    public Integer getTotalPersonnel() {
        return totalPersonnel;
    }

    public void setTotalPersonnel(Integer totalPersonnel) {
        this.totalPersonnel = totalPersonnel;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }

    public String getFarmingName() {
        return farmingName;
    }

    public void setFarmingName(String farmingName) {
        this.farmingName = farmingName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public PlanYear getPlanYear() {
        return planYear;
    }

    public void setPlanYear(PlanYear planYear) {
        this.planYear = planYear;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public FarmingTypeEnum getType() {
        return type;
    }

    public void setType(FarmingTypeEnum type) {
        this.type = type;
    }

    public List<DeviceInfo> getDeviceInfoList() {
        return deviceInfoList;
    }

    public void setDeviceInfoList(List<DeviceInfo> deviceInfoList) {
        this.deviceInfoList = deviceInfoList;
    }

    public List<MaterialInfo> getMaterialInfoList() {
        return materialInfoList;
    }

    public void setMaterialInfoList(List<MaterialInfo> materialInfoList) {
        this.materialInfoList = materialInfoList;
    }

    public List<PersonnelInfo> getPersonnelInfoList() {
        return personnelInfoList;
    }

    public void setPersonnelInfoList(List<PersonnelInfo> personnelInfoList) {
        this.personnelInfoList = personnelInfoList;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public FarmingItem getFarmingItem() {
        return farmingItem;
    }

    public void setFarmingItem(FarmingItem farmingItem) {
        this.farmingItem = farmingItem;
    }

    public short getFarmingCycle() {
        return farmingCycle;
    }

    public void setFarmingCycle(short farmingCycle) {
        this.farmingCycle = farmingCycle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlanYearId() {
        return planYearId;
    }

    public void setPlanYearId(Integer planYearId) {
        this.planYearId = planYearId;
    }

    public FarmingLocationEnum getIsLocation() {
        return isLocation;
    }

    public void setIsLocation(FarmingLocationEnum isLocation) {
        this.isLocation = isLocation;
    }

    public SolarTermsEnum getSolarTerm() {
        return solarTerm;
    }

    public void setSolarTerm(SolarTermsEnum solarTerm) {
        this.solarTerm = solarTerm;
    }

    public HouEnum getHou() {
        return hou;
    }

    public void setHou(HouEnum hou) {
        this.hou = hou;
    }

    public Integer getFarmingItemId() {
        return farmingItemId;
    }

    public void setFarmingItemId(Integer farmingItemId) {
        this.farmingItemId = farmingItemId;
    }

    public boolean isSequExecute() {
        return sequExecute;
    }

    public void setSequExecute(boolean sequExecute) {
        this.sequExecute = sequExecute;
    }
}