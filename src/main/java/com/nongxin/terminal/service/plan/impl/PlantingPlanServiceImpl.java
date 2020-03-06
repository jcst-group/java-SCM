package com.nongxin.terminal.service.plan.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.dao.plant.*;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.plant.*;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.service.plan.PlantingPlanService;
import com.nongxin.terminal.util.ImgUpload;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.util.enumUtil.file.ImgTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.util.List;

@Service
public class PlantingPlanServiceImpl implements PlantingPlanService {

    @Autowired(required = false)
    private PlantingPlanMapper plantingPlanMapper;
    @Autowired(required = false)
    private PlanYearMapper planYearMapper;
    @Autowired(required = false)
    private FarmingMapper farmingMapper;
    @Autowired(required = false)
    private FarmingRoleMapper farmingRoleMapper;
    @Autowired(required = false)
    private MaterialInfoMapper materialInfoMapper;
    @Autowired(required = false)
    private DeviceInfoMapper deviceInfoMapper;
    @Autowired(required = false)
    private PersonnelInfoMapper personnelInfoMapper;
    @Autowired(required = false)
    private ImgUpload imgUpload;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;

    @Override
    public boolean add(PlantingPlan plantingPlan) {
        return plantingPlanMapper.insertSelective(plantingPlan)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return plantingPlanMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(PlantingPlan plantingPlan) {
        return plantingPlanMapper.updateByPrimaryKeySelective(plantingPlan)==1;
    }

    @Override
    public List<PlantingPlan> getPlantingPlanList(String planName, Integer cropId) {
        return plantingPlanMapper.getPlantingPlanList(planName,cropId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean copyPlan(Integer id, String planName) {
        try {
            //复制种植计划
            PlantingPlan plantingPlan = plantingPlanMapper.selectByPrimaryKey(id);
            plantingPlan.setPlanName(planName);
            plantingPlanMapper.insertSelective(plantingPlan);
            //复制种植年
            List<PlanYear> planYearList = planYearMapper.selectByPlanId(id);
            if (planYearList != null && !planYearList.isEmpty()){
                for (PlanYear planYear : planYearList) {
                    planYear.setPlanId(plantingPlan.getId());
                    planYearMapper.insertSelective(planYear);
                    //复制农事
                    List<Farming> farmingList = planYear.getFarmingList();
                    if (farmingList != null && !farmingList.isEmpty()){
                        for (Farming farming : farmingList) {
                            farming.setPlanYearId(planYear.getId());
                            farmingMapper.insertSelective(farming);
                            //复制农事对应角色
                            List<Role> roleList = farming.getRoleList();
                            if (roleList != null && !roleList.isEmpty()){
                                for (Role role : roleList) {
                                    FarmingRole farmingRole = new FarmingRole();
                                    farmingRole.setRoleId(role.getId());
                                    farmingRole.setFarmingId(farming.getId());
                                    farmingRoleMapper.insertSelective(farmingRole);
                                }
                            }
                            //复制物料
                            List<MaterialInfo> materialList = farming.getMaterialInfoList();
                            if (materialList != null && !materialList.isEmpty()){
                                for (MaterialInfo materialInfo : materialList) {
                                    materialInfo.setFarmingId(farming.getId());
                                    materialInfoMapper.insertSelective(materialInfo);
                                    PictureInfo pictureInfo = materialInfo.getPictureInfo();
                                    if (pictureInfo != null){
                                        String path = pictureInfo.getPictureUrl();
                                        String suffixName = path.substring(path.lastIndexOf(".")+1);
                                        File file = new File(imgUpload.getPath(path));
                                        if (file.exists()){
                                            String url = (System.currentTimeMillis() +(int)((Math.random()*9+1)*1000)+suffixName);
                                            File saveFile = new File(imgUpload.getPath(url));
                                            FileCopyUtils.copy(file, saveFile);
                                            pictureInfo.setPictureUrl(url);
                                            pictureInfo.setRelationId(materialInfo.getId());
                                            pictureInfo.setRelationType(ImgRelationTypeEnum.MATERIALINFO);
                                            pictureInfo.setType(ImgTypeEnum.LOCAL);
                                            pictureInfoMapper.insertSelective(pictureInfo);
                                        }
                                    }
                                }
                            }
                            //复制设备
                            List<DeviceInfo> deviceInfoList = farming.getDeviceInfoList();
                            if (deviceInfoList != null && !deviceInfoList.isEmpty()){
                                for (DeviceInfo deviceInfo : deviceInfoList) {
                                    deviceInfo.setFarmingId(farming.getId());
                                    deviceInfoMapper.insertSelective(deviceInfo);
                                }
                            }
                            //复制人员
                            List<PersonnelInfo> personnelInfoList = farming.getPersonnelInfoList();
                            if (personnelInfoList != null && !personnelInfoList.isEmpty()){
                                for (PersonnelInfo personnelInfo : personnelInfoList) {
                                    personnelInfo.setFarmingId(farming.getId());
                                    personnelInfoMapper.insertSelective(personnelInfo);
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }
}
