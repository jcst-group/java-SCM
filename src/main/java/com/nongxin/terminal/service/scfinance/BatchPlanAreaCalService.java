package com.nongxin.terminal.service.scfinance;

import com.nongxin.terminal.dao.base.LotMapper;
import com.nongxin.terminal.dao.crop.CropBatchMapper;
import com.nongxin.terminal.dao.plant.*;
import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.entity.plant.*;
import com.nongxin.terminal.entity.scfinance.insurance.LoanFarmItem;
import com.nongxin.terminal.support.BaseException;
import com.nongxin.terminal.util.enumUtil.plan.PrepareTypeEnum;
import com.nongxin.terminal.util.solar.SolarTerms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoZonedDateTime;
import java.util.*;

@Service
public class BatchPlanAreaCalService {


    @Autowired(required = false)
    private WorkOrderMapper workOrderMapper;
    @Autowired(required = false)
    private PrepareItemMapper prepareItemMapper;
    @Autowired(required = false)
    private FarmingMapper farmingMapper;
    @Autowired(required = false)
    private CropBatchMapper cropBatchMapper;
    @Autowired(required = false)
    private LotMapper lotMapper;
    @Autowired(required = false)
    private OrderRoleMapper orderRoleMapper;
    @Autowired(required = false)
    private DeviceActMapper deviceActMapper;
    @Autowired(required = false)
    private MaterialActMapper materialActMapper;
    @Autowired(required = false)
    private PersonnelActMapper personnelActMapper;
    @Autowired(required = false)
    private FarmingBatchRelMapper farmingBatchRelMapper;
    @Autowired(required = false)
    private OrderContentMapper orderContentMapper;


    //根据面积和种植计划，计算花费项
    public Map cal(Integer batchId, BigDecimal area) throws BaseException {
        CropBatch cropBatch = cropBatchMapper.selectByPrimaryKey(batchId);
//        if (cropBatch.getStatus() != BatchStatusEnum.NOT_USED){
//            throw new BaseException(500,"请勿重复创建工单。");
//        }
        //修改批次状态为使用中
       // cropBatchMapper.updateStatus(cropBatch.getId(), BatchStatusEnum.IN_USED);
        //设备准备事项
        //PrepareItem prepareItem = new PrepareItem();
        //prepareItem.setCropBatchId(batchId);



        List<LoanFarmItem> prepareItemVos = new ArrayList<>();
        BigDecimal costCount = BigDecimal.ZERO;

        //工单
        WorkOrder workOrder = new WorkOrder();
        workOrder.setCropBatchId(batchId);
        List<Farming> farmingList = farmingMapper.getDataByBatchId(batchId);
        //地块面积
        //BigDecimal acreageSum = lotMapper.getAcreageSum(batchId);
        BigDecimal acreageSum = area;
        Integer fakerId = 1;
        for (Farming farming : farmingList){
            FarmingItem farmingItem = farming.getFarmingItem();
            List<DeviceInfo> deviceInfoList = farming.getDeviceInfoList();
            List<MaterialInfo> materialInfoList = farming.getMaterialInfoList();
            List<PersonnelInfo> personnelInfoList = farming.getPersonnelInfoList();
            BigDecimal personnelUnit = null;
            //人单位
            if (personnelInfoList!=null && !personnelInfoList.isEmpty()){
                personnelUnit = personnelInfoList.get(0).getUnitMu();
            }else{
                throw new BaseException(500,"该批次所选种植计划人员信息有所缺失，无法创建工单。");
            }
            //开始时间
            LocalDate startTime = SolarTerms.getSolarTermNum(cropBatch.getStartYear()+(farming.getPlanYear().getYear().getValue()-1),farming.getSolarTerm());
            startTime = startTime.plusDays((farming.getHou().getValue()-1)*5);
            ChronoZonedDateTime<LocalDate> startDateTime = startTime.atStartOfDay(ZoneId.systemDefault());
            //结束时间
            LocalDate endTime = startTime.plusDays(farming.getFarmingCycle());
            ChronoZonedDateTime<LocalDate> endDateTime = endTime.atStartOfDay(ZoneId.systemDefault());


            /**
             * 计算设备准备事项
             */
            if (deviceInfoList != null && !deviceInfoList.isEmpty()){

                for (DeviceInfo deviceInfo : deviceInfoList) {

                    LoanFarmItem prepareItem = new LoanFarmItem();

                    //开始时间
                    prepareItem.setStartTime(Date.from(startDateTime.toInstant()));
                    //结束时间
                    prepareItem.setEndTime(Date.from(endDateTime.toInstant()));
                    //最小人数
                    prepareItem.setMinPerson(acreageSum.multiply(personnelUnit).
                            divide(new BigDecimal(farming.getFarmingCycle()),0,BigDecimal.ROUND_UP).intValue());
                    //数量
                    BigDecimal tempNum = acreageSum.multiply(deviceInfo.getUnitMu()).setScale(0,BigDecimal.ROUND_UP);
                    prepareItem.setNum(tempNum.intValue());
                    //费用
                    BigDecimal multiply = tempNum.multiply(deviceInfo.getRent());
                    prepareItem.setBudgetCosts(multiply);
                    costCount = costCount.add(multiply);
                    //到位时间
                    LocalDate inplaceTime = startTime.minusDays(deviceInfo.getPrepareDay());
                    ChronoZonedDateTime<LocalDate> inplaceDateTime = inplaceTime.atStartOfDay(ZoneId.systemDefault());
                    prepareItem.setInplaceTime(Date.from(inplaceDateTime.toInstant()));
                    prepareItem.setMaterialName(deviceInfo.getDeviceName());
                    prepareItem.setCompany(deviceInfo.getCompany());
                    prepareItem.setFarmingItemId(farming.getFarmingItemId());
                    prepareItem.setWorkOrderId(workOrder.getId());
                    prepareItem.setFarmingId(farming.getId());
                    prepareItem.setItemType(PrepareTypeEnum.DEVICE);
                    prepareItem.setFarmingItem(farmingItem);

                    prepareItem.setId(fakerId++);
                    prepareItemVos.add(prepareItem);
                }
            }

            /**
             * 计算物料准备事项
             */
            if (materialInfoList != null && !materialInfoList.isEmpty()){
                for (MaterialInfo materialInfo : materialInfoList) {

                    LoanFarmItem prepareItem = new LoanFarmItem();

                    prepareItem.setStartTime(Date.from(startDateTime.toInstant()));
                    prepareItem.setEndTime(Date.from(endDateTime.toInstant()));
                    prepareItem.setMinPerson(acreageSum.multiply(personnelUnit).
                            divide(new BigDecimal(farming.getFarmingCycle()),0,BigDecimal.ROUND_UP).intValue());
                    BigDecimal tempNum = acreageSum.multiply(materialInfo.getUnitMu()).setScale(0,BigDecimal.ROUND_UP);
                    prepareItem.setNum(tempNum.intValue());


                    BigDecimal multiply = tempNum.multiply(materialInfo.getUnitPrice());
                    prepareItem.setBudgetCosts(multiply);
                    costCount = costCount.add(multiply);

                    LocalDate inplaceTime = startTime.minusDays(materialInfo.getPrepareDay());
                    ChronoZonedDateTime<LocalDate> inplaceDateTime = inplaceTime.atStartOfDay(ZoneId.systemDefault());
                    prepareItem.setInplaceTime(Date.from(inplaceDateTime.toInstant()));
                    prepareItem.setMaterialName(materialInfo.getMaterialName());
                    prepareItem.setCompany(materialInfo.getCompany());
                    prepareItem.setFarmingItemId(farming.getFarmingItemId());
                    prepareItem.setWorkOrderId(workOrder.getId());
                    prepareItem.setFarmingId(farming.getId());
                    prepareItem.setItemType(PrepareTypeEnum.MATERIAL);
                    prepareItem.setFarmingItem(farmingItem);

                    prepareItem.setId(fakerId++);
                    prepareItemVos.add(prepareItem);
                }
            }

            /**
             * 计算人员准备事项
             */
            if (personnelInfoList != null && !personnelInfoList.isEmpty()){
                for (PersonnelInfo personnelInfo : personnelInfoList) {

                    LoanFarmItem prepareItem = new LoanFarmItem();

                    prepareItem.setStartTime(Date.from(startDateTime.toInstant()));
                    prepareItem.setEndTime(Date.from(endDateTime.toInstant()));
                    prepareItem.setMinPerson(acreageSum.multiply(personnelUnit).
                            divide(new BigDecimal(farming.getFarmingCycle()),0,BigDecimal.ROUND_UP).intValue());
                    BigDecimal tempNum = acreageSum.multiply(personnelInfo.getUnitMu()).setScale(0,BigDecimal.ROUND_UP);
                    prepareItem.setNum(tempNum.intValue());

                    BigDecimal multiply = tempNum.multiply(personnelInfo.getLaborCosts());
                    prepareItem.setBudgetCosts(multiply);
                    costCount = costCount.add(multiply);


                    LocalDate inplaceTime = startTime.minusDays(personnelInfo.getPrepareDay());
                    ChronoZonedDateTime<LocalDate> inplaceDateTime = inplaceTime.atStartOfDay(ZoneId.systemDefault());
                    prepareItem.setInplaceTime(Date.from(inplaceDateTime.toInstant()));
                    prepareItem.setMaterialName(personnelInfo.getPersonnelName());
                    prepareItem.setFarmingItemId(farming.getFarmingItemId());
                    prepareItem.setCompany("人");
                    prepareItem.setWorkOrderId(workOrder.getId());
                    prepareItem.setFarmingId(farming.getId());
                    prepareItem.setItemType(PrepareTypeEnum.PERSONNEL);
                    prepareItem.setFarmingItem(farmingItem);

                    prepareItem.setId(fakerId++);
                    prepareItemVos.add(prepareItem);
                }
            }
        }

        Map result = new HashMap();
        result.put("list",prepareItemVos);
        result.put("costCount",costCount);

        return result;
    }
}
