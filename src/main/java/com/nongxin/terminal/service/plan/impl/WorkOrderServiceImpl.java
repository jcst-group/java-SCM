package com.nongxin.terminal.service.plan.impl;

import com.nongxin.terminal.dao.base.LotMapper;
import com.nongxin.terminal.dao.crop.CropBatchMapper;
import com.nongxin.terminal.dao.plant.*;
import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.entity.plant.*;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.service.plan.WorkOrderService;
import com.nongxin.terminal.support.BaseException;
import com.nongxin.terminal.util.enumUtil.crop.BatchStatusEnum;
import com.nongxin.terminal.util.enumUtil.plan.FarmingLocationEnum;
import com.nongxin.terminal.util.enumUtil.plan.PrepareTypeEnum;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderStatusEnum;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderTypeEnum;
import com.nongxin.terminal.util.solar.SolarTerms;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.workorder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized boolean add(Integer batchId) throws BaseException {
        CropBatch cropBatch = cropBatchMapper.selectByPrimaryKey(batchId);
        if (cropBatch.getStatus() != BatchStatusEnum.NOT_USED){
            throw new BaseException(500,"请勿重复创建工单。");
        }
        //修改批次状态为使用中
        cropBatchMapper.updateStatus(cropBatch.getId(), BatchStatusEnum.IN_USED);
        //设备准备事项
        PrepareItem prepareItem = new PrepareItem();
        prepareItem.setCropBatchId(batchId);
        //工单
        WorkOrder workOrder = new WorkOrder();
        workOrder.setCropBatchId(batchId);
        List<Farming> farmingList = farmingMapper.getByBatchId(batchId);
        //地块面积
        BigDecimal acreageSum = lotMapper.getAcreageSum(batchId);
        for (Farming farming : farmingList){
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
             * 添加工单
             */
            workOrder.setExecutionTime(Date.from(startDateTime.toInstant()));
            workOrder.setEndTime(Date.from(endDateTime.toInstant()));
            workOrder.setSolarTerm(farming.getSolarTerm());
            workOrder.setCropBatchId(batchId);
            workOrder.setFarmingItemId(farming.getFarmingItemId());
            workOrder.setStatus(WorkOrderStatusEnum.UNEXECUTED);
            workOrder.setType(WorkOrderTypeEnum.ORDINARY);
            workOrder.setFarmingId(farming.getId());
            workOrder.setSequExecute(farming.isSequExecute());
            workOrderMapper.insertSelective(workOrder);

            /**
             * 添加工单对应角色
             */
            if (farming.getRoleList()!=null && !farming.getRoleList().isEmpty()){
                OrderRole orderRole = new OrderRole();
                orderRole.setWorkOrderId(workOrder.getId());
                for (Role role : farming.getRoleList()) {
                    orderRole.setRoleId(role.getId());
                    orderRoleMapper.insertSelective(orderRole);
                }
            }

            /**
             * 计算设备准备事项
             */
            if (deviceInfoList != null && !deviceInfoList.isEmpty()){

                for (DeviceInfo deviceInfo : deviceInfoList) {
                    //开始时间
                    prepareItem.setStartTime(Date.from(startDateTime.toInstant()));
                    //结束时间
                    prepareItem.setEndTime(Date.from(endDateTime.toInstant()));
                    //最小人数
                    prepareItem.setMinPerson(acreageSum.multiply(personnelUnit).
                            divide(new BigDecimal(farming.getFarmingCycle()),0,BigDecimal.ROUND_UP).shortValue());
                    //数量
                    BigDecimal tempNum = acreageSum.multiply(deviceInfo.getUnitMu()).setScale(0,BigDecimal.ROUND_UP);
                    prepareItem.setNum(tempNum.intValue());
                    //费用
                    prepareItem.setBudgetCosts(tempNum.multiply(deviceInfo.getRent()));
                    //到位时间
                    LocalDate inplaceTime = startTime.minusDays(deviceInfo.getPrepareDay());
                    ChronoZonedDateTime<LocalDate> inplaceDateTime = inplaceTime.atStartOfDay(ZoneId.systemDefault());
                    prepareItem.setInplaceTime(Date.from(inplaceDateTime.toInstant()));
                    prepareItem.setMaterialName(deviceInfo.getDeviceName());
                    prepareItem.setCompany(deviceInfo.getCompany());
                    prepareItem.setFarmingItemId(farming.getFarmingItemId());
                    prepareItem.setWorkOrderId(workOrder.getId());
                    prepareItem.setType(PrepareTypeEnum.DEVICE);
                    prepareItemMapper.insertSelective(prepareItem);

                    DeviceAct deviceAct = new DeviceAct(deviceInfo.getDeviceName(),deviceInfo.getCompany(),deviceInfo.getRent(),
                            tempNum.multiply(deviceInfo.getRent()),tempNum,workOrder.getId());
                    deviceActMapper.insertSelective(deviceAct);
                }
            }

            /**
             * 计算物料准备事项
             */
            if (materialInfoList != null && !materialInfoList.isEmpty()){
                for (MaterialInfo materialInfo : materialInfoList) {
                    prepareItem.setStartTime(Date.from(startDateTime.toInstant()));
                    prepareItem.setEndTime(Date.from(endDateTime.toInstant()));
                    prepareItem.setMinPerson(acreageSum.multiply(personnelUnit).
                            divide(new BigDecimal(farming.getFarmingCycle()),0,BigDecimal.ROUND_UP).shortValue());
                    BigDecimal tempNum = acreageSum.multiply(materialInfo.getUnitMu()).setScale(0,BigDecimal.ROUND_UP);
                    prepareItem.setNum(tempNum.intValue());
                    prepareItem.setBudgetCosts(tempNum.multiply(materialInfo.getUnitPrice()));
                    LocalDate inplaceTime = startTime.minusDays(materialInfo.getPrepareDay());
                    ChronoZonedDateTime<LocalDate> inplaceDateTime = inplaceTime.atStartOfDay(ZoneId.systemDefault());
                    prepareItem.setInplaceTime(Date.from(inplaceDateTime.toInstant()));
                    prepareItem.setMaterialName(materialInfo.getMaterialName());
                    prepareItem.setCompany(materialInfo.getCompany());
                    prepareItem.setFarmingItemId(farming.getFarmingItemId());
                    prepareItem.setWorkOrderId(workOrder.getId());
                    prepareItem.setType(PrepareTypeEnum.MATERIAL);
                    prepareItemMapper.insertSelective(prepareItem);

                    MaterialAct materialAct = new MaterialAct(materialInfo.getMaterialName(),materialInfo.getCompany(),materialInfo.getUnitPrice(),tempNum,
                            tempNum.multiply(materialInfo.getUnitPrice()),workOrder.getId());
                    materialActMapper.insertSelective(materialAct);
                }
            }

            /**
             * 计算人员准备事项
             */
            if (personnelInfoList != null && !personnelInfoList.isEmpty()){
                for (PersonnelInfo personnelInfo : personnelInfoList) {
                    prepareItem.setStartTime(Date.from(startDateTime.toInstant()));
                    prepareItem.setEndTime(Date.from(endDateTime.toInstant()));
                    prepareItem.setMinPerson(acreageSum.multiply(personnelUnit).
                            divide(new BigDecimal(farming.getFarmingCycle()),0,BigDecimal.ROUND_UP).shortValue());
                    BigDecimal tempNum = acreageSum.multiply(personnelInfo.getUnitMu()).setScale(0,BigDecimal.ROUND_UP);
                    prepareItem.setNum(tempNum.intValue());
                    prepareItem.setBudgetCosts(tempNum.multiply(personnelInfo.getLaborCosts()));
                    LocalDate inplaceTime = startTime.minusDays(personnelInfo.getPrepareDay());
                    ChronoZonedDateTime<LocalDate> inplaceDateTime = inplaceTime.atStartOfDay(ZoneId.systemDefault());
                    prepareItem.setInplaceTime(Date.from(inplaceDateTime.toInstant()));
                    prepareItem.setMaterialName(personnelInfo.getPersonnelName());
                    prepareItem.setFarmingItemId(farming.getFarmingItemId());
                    prepareItem.setCompany("人");
                    prepareItem.setWorkOrderId(workOrder.getId());
                    prepareItem.setType(PrepareTypeEnum.PERSONNEL);
                    prepareItemMapper.insertSelective(prepareItem);

                    PersonnelAct personnelAct = new PersonnelAct(personnelInfo.getPersonnelName(),personnelInfo.getLaborCosts(),tempNum,
                            tempNum.multiply(personnelInfo.getLaborCosts()),workOrder.getId());
                    personnelActMapper.insertSelective(personnelAct);
                }
            }
        }
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean update(WorkOrder workOrder) {
        return workOrderMapper.updateByPrimaryKeySelective(workOrder)==1;
    }

    @Override
    public boolean revokeWorkOrder(Integer batchId) {
        List<WorkOrder> list = workOrderMapper.getWorkOrderByBatchId(batchId);
        boolean temp = true;
        for (WorkOrder workOrder : list) {
            if (workOrder.getStatus() != WorkOrderStatusEnum.UNEXECUTED){
                temp = false;
                break;
            }
        }
        if (temp){
            //删除工单
            workOrderMapper.deleteByBatchId(batchId,WorkOrderTypeEnum.ORDINARY);
            //删除准备事项
            //prepareItemMapper.deleteByBatchId(batchId);
            //修改批次状态为未使用
            cropBatchMapper.updateStatus(batchId, BatchStatusEnum.NOT_USED);
            return true;
        }
        return false;
    }


    @Override
    public List<WorkOrder> getWorkOrder(OrderConditionVo orderConditionVo) {
        return workOrderMapper.getWorkOrder(orderConditionVo);
    }

    @Override
    public boolean updateStatus(Integer id, WorkOrderStatusEnum status,Date examineTime) {
        return workOrderMapper.updateStatus(id,status,examineTime)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addTemporaryOrder(Integer[] batchIds,Integer farmingId) throws BaseException {
        Farming farming = farmingMapper.selectByPrimaryKey(farmingId);
        List<DeviceInfo> deviceInfoList = farming.getDeviceInfoList();
        List<MaterialInfo> materialInfoList = farming.getMaterialInfoList();
        List<PersonnelInfo> personnelInfoList = farming.getPersonnelInfoList();
        BigDecimal personnelUnit = null;
        //人单位
        if (personnelInfoList!=null && !personnelInfoList.isEmpty()){
            personnelUnit = personnelInfoList.get(0).getUnitMu();
        }else{
            throw new BaseException(500,"人员信息不能为空");
        }
        //开始时间
        Instant instant = farming.getStartTime().toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate startTime = instant.atZone(zoneId).toLocalDate();
        ChronoZonedDateTime<LocalDate> startDateTime = startTime.atStartOfDay(ZoneId.systemDefault());
        //结束时间
        LocalDate endTime = startTime.plusDays(farming.getFarmingCycle());
        ChronoZonedDateTime<LocalDate> endDateTime = endTime.atStartOfDay(ZoneId.systemDefault());

        for (Integer batchId : batchIds) {
            if (workOrderMapper.getOrderByBatchIdAndFarmingId(batchId,farmingId,null)!=null){
                continue;
            }
            FarmingBatchRel farmingBatchRel = new FarmingBatchRel();
            farmingBatchRel.setBatchId(batchId);
            farmingBatchRel.setFarmingId(farmingId);
            farmingBatchRelMapper.insertSelective(farmingBatchRel);

            //设备准备事项
            PrepareItem prepareItem = new PrepareItem();
            prepareItem.setCropBatchId(batchId);
            //工单
            WorkOrder workOrder = new WorkOrder();
            workOrder.setCropBatchId(batchId);
            //地块面积
            BigDecimal acreageSum = lotMapper.getAcreageSum(batchId);

            /**
             * 添加工单
             */
            workOrder.setExecutionTime(Date.from(startDateTime.toInstant()));
            workOrder.setEndTime(Date.from(endDateTime.toInstant()));
            workOrder.setSolarTerm(farming.getSolarTerm());
            workOrder.setCropBatchId(batchId);
            workOrder.setFarmingItemId(farming.getFarmingItemId());
            workOrder.setStatus(WorkOrderStatusEnum.UNEXECUTED);
            workOrder.setType(WorkOrderTypeEnum.TEMPORARY);
            workOrder.setFarmingId(farmingId);
            workOrderMapper.insertSelective(workOrder);

            /**
             * 添加工单对应角色
             */
            if (farming.getRoleList()!=null && !farming.getRoleList().isEmpty()){
                OrderRole orderRole = new OrderRole();
                orderRole.setWorkOrderId(workOrder.getId());
                for (Role role : farming.getRoleList()) {
                    orderRole.setRoleId(role.getId());
                    orderRoleMapper.insertSelective(orderRole);
                }
            }

            /**
             * 计算设备准备事项
             */
            if (deviceInfoList != null && !deviceInfoList.isEmpty()){

                for (DeviceInfo deviceInfo : deviceInfoList) {
                    //开始时间
                    prepareItem.setStartTime(Date.from(startDateTime.toInstant()));
                    //结束时间
                    prepareItem.setEndTime(Date.from(endDateTime.toInstant()));
                    //最小人数
                    prepareItem.setMinPerson(acreageSum.multiply(personnelUnit).
                            divide(new BigDecimal(farming.getFarmingCycle()),0,BigDecimal.ROUND_UP).shortValue());
                    //数量
                    BigDecimal tempNum = acreageSum.multiply(deviceInfo.getUnitMu()).setScale(0,BigDecimal.ROUND_UP);
                    prepareItem.setNum(tempNum.intValue());
                    //费用
                    prepareItem.setBudgetCosts(tempNum.multiply(deviceInfo.getRent()));
                    //到位时间
                    LocalDate inplaceTime = startTime.minusDays(deviceInfo.getPrepareDay());
                    ChronoZonedDateTime<LocalDate> inplaceDateTime = inplaceTime.atStartOfDay(ZoneId.systemDefault());
                    prepareItem.setInplaceTime(Date.from(inplaceDateTime.toInstant()));
                    prepareItem.setMaterialName(deviceInfo.getDeviceName());
                    prepareItem.setCompany(deviceInfo.getCompany());
                    prepareItem.setFarmingItemId(farming.getFarmingItemId());
                    prepareItem.setWorkOrderId(workOrder.getId());
                    prepareItem.setType(PrepareTypeEnum.DEVICE);
                    prepareItemMapper.insertSelective(prepareItem);

                    DeviceAct deviceAct = new DeviceAct(deviceInfo.getDeviceName(),deviceInfo.getCompany(),deviceInfo.getRent(),
                            tempNum.multiply(deviceInfo.getRent()),tempNum,workOrder.getId());
                    deviceActMapper.insertSelective(deviceAct);
                }
            }

            /**
             * 计算物料准备事项
             */
            if (materialInfoList != null && !materialInfoList.isEmpty()){
                for (MaterialInfo materialInfo : materialInfoList) {
                    prepareItem.setStartTime(Date.from(startDateTime.toInstant()));
                    prepareItem.setEndTime(Date.from(endDateTime.toInstant()));
                    prepareItem.setMinPerson(acreageSum.multiply(personnelUnit).
                            divide(new BigDecimal(farming.getFarmingCycle()),0,BigDecimal.ROUND_UP).shortValue());
                    BigDecimal tempNum = acreageSum.multiply(materialInfo.getUnitMu()).setScale(0,BigDecimal.ROUND_UP);
                    prepareItem.setNum(tempNum.intValue());
                    prepareItem.setBudgetCosts(tempNum.multiply(materialInfo.getUnitPrice()));
                    LocalDate inplaceTime = startTime.minusDays(materialInfo.getPrepareDay());
                    ChronoZonedDateTime<LocalDate> inplaceDateTime = inplaceTime.atStartOfDay(ZoneId.systemDefault());
                    prepareItem.setInplaceTime(Date.from(inplaceDateTime.toInstant()));
                    prepareItem.setMaterialName(materialInfo.getMaterialName());
                    prepareItem.setCompany(materialInfo.getCompany());
                    prepareItem.setFarmingItemId(farming.getFarmingItemId());
                    prepareItem.setWorkOrderId(workOrder.getId());
                    prepareItem.setType(PrepareTypeEnum.MATERIAL);
                    prepareItemMapper.insertSelective(prepareItem);

                    MaterialAct materialAct = new MaterialAct(materialInfo.getMaterialName(),materialInfo.getCompany(),materialInfo.getUnitPrice(),tempNum,
                            tempNum.multiply(materialInfo.getUnitPrice()),workOrder.getId());
                    materialActMapper.insertSelective(materialAct);
                }
            }

            /**
             * 计算人员准备事项
             */
            if (personnelInfoList != null && !personnelInfoList.isEmpty()) {
                for (PersonnelInfo personnelInfo : personnelInfoList) {
                    prepareItem.setStartTime(Date.from(startDateTime.toInstant()));
                    prepareItem.setEndTime(Date.from(endDateTime.toInstant()));
                    prepareItem.setMinPerson(acreageSum.multiply(personnelUnit).
                            divide(new BigDecimal(farming.getFarmingCycle()), 0, BigDecimal.ROUND_UP).shortValue());
                    BigDecimal tempNum = acreageSum.multiply(personnelInfo.getUnitMu()).setScale(0, BigDecimal.ROUND_UP);
                    prepareItem.setNum(tempNum.intValue());
                    prepareItem.setBudgetCosts(tempNum.multiply(personnelInfo.getLaborCosts()));
                    LocalDate inplaceTime = startTime.minusDays(personnelInfo.getPrepareDay());
                    ChronoZonedDateTime<LocalDate> inplaceDateTime = inplaceTime.atStartOfDay(ZoneId.systemDefault());
                    prepareItem.setInplaceTime(Date.from(inplaceDateTime.toInstant()));
                    prepareItem.setMaterialName(personnelInfo.getPersonnelName());
                    prepareItem.setFarmingItemId(farming.getFarmingItemId());
                    prepareItem.setCompany("人");
                    prepareItem.setWorkOrderId(workOrder.getId());
                    prepareItem.setType(PrepareTypeEnum.PERSONNEL);
                    prepareItemMapper.insertSelective(prepareItem);

                    PersonnelAct personnelAct = new PersonnelAct(personnelInfo.getPersonnelName(), personnelInfo.getLaborCosts(), tempNum,
                            tempNum.multiply(personnelInfo.getLaborCosts()), workOrder.getId());
                    personnelActMapper.insertSelective(personnelAct);
                }
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result revokeTemporaryOrder(Integer[] batchIds, Integer farmingId) {
        Result result = new Result();
        try {
            for (Integer batchId : batchIds) {
                WorkOrder workOrder = workOrderMapper.getOrderByBatchIdAndFarmingId(batchId,farmingId,WorkOrderTypeEnum.TEMPORARY);
                if (workOrder != null && workOrder.getStatus() != WorkOrderStatusEnum.UNEXECUTED){
                    result.setMessage("工单已开始执行，无法撤销！！");
                    result.setSuccess(false);
                    return result;
                }
                FarmingBatchRel farmingBatchRel = new FarmingBatchRel();
                farmingBatchRel.setBatchId(batchId);
                farmingBatchRel.setFarmingId(farmingId);
                farmingBatchRelMapper.delete(farmingBatchRel);
                workOrderMapper.deleteTemporaryOrder(batchId,farmingId,WorkOrderTypeEnum.TEMPORARY);
            }
            result.setMessage("撤销工单成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        result.setMessage("撤销工单失败！！");
        result.setSuccess(false);
        return result;
    }

    @Override
    public List<WorkOrder> exportWorkOrder(OrderConditionVo orderConditionVo) {
        return workOrderMapper.exportWorkOrder(orderConditionVo);
    }

    @Override
    public List<AppOrderVo> getAppOrderVo(Integer uid, WorkOrderStatusEnum status,Integer batchId) {
        return workOrderMapper.getAppOrderVo(uid,status,batchId);
    }

    @Override
    public List<WorkOrder> getOrderByBatchId(Integer batchId) {
        return workOrderMapper.getOrderByBatchId(batchId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean executingOrder(WorkOrder workOrder){
            //修改工单状态为待审核
            workOrder.setStatus(WorkOrderStatusEnum.NOT_AUDITED);
            int count = workOrderMapper.updateByPrimaryKeySelective(workOrder);
            //添加工单完成信息
            OrderContent orderContent = workOrder.getOrderContent();
            orderContentMapper.deleteByOrderId(workOrder.getId());
            if (orderContent != null && !(orderContent.getContent().equals("") && orderContent.getLatitude()==null && orderContent.getLongitude()==null)){
                orderContent.setOrderId(workOrder.getId());
                orderContentMapper.insertSelective(orderContent);
            }
            //添加人资、物料、设备实际费用
            List<PersonnelAct> personnelActList = workOrder.getPersonnelActList();
            if (personnelActList != null && !personnelActList.isEmpty()){
                for (PersonnelAct personnelAct : personnelActList) {
                    personnelActMapper.updateByPrimaryKeySelective(personnelAct);
                }
            }

            List<MaterialAct> materialActList = workOrder.getMaterialActList();
            if (materialActList != null && !materialActList.isEmpty()){
                for (MaterialAct materialAct : materialActList) {
                    materialActMapper.updateByPrimaryKeySelective(materialAct);
                }
            }

            List<DeviceAct> deviceActList = workOrder.getDeviceActList();
            if (deviceActList != null && !deviceActList.isEmpty()){
                for (DeviceAct deviceAct : deviceActList) {
                    deviceActMapper.updateByPrimaryKeySelective(deviceAct);
                }
            }

            return count==1;

    }

    @Override
    public AppOrderVo getOrderCosts(Integer id) {
        return workOrderMapper.getOrderCosts(id);
    }

    @Override
    public WorkOrder selectByPrimaryKey(Integer id) {
        return workOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<WorkOrder> getOrderByRetroCode(String retroCode) {
        return workOrderMapper.getOrderByRetroCode(retroCode);
    }

    @Override
    public Map<String, Object> getOrderIsLocal(Integer orderId) {
        return workOrderMapper.getOrderIsLocal(orderId);
    }

    @Override
    public LocalVo getOrderLocal(Integer orderId, FarmingLocationEnum isLocal) {
        return workOrderMapper.getOrderLocal(orderId,isLocal);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateOrderRole(Integer[] roleIds, Integer orderId) {
        try {
            orderRoleMapper.deleteByPrimaryKey(orderId);
            orderRoleMapper.addOrderRole(roleIds,orderId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<RealTimeOrder> getRealTimeOrder() {
        return workOrderMapper.getRealTimeOrder();
    }

    @Override
    public List<Map<String, Object>> getCompleteOrder() {
        return workOrderMapper.getCompleteOrder();
    }

    @Override
    public List<Map<String, Object>> getLookOrder() {
        return workOrderMapper.getLookOrder();
    }

    @Override
    public WorkOrder selectById(Integer id) {
        return workOrderMapper.selectById(id);
    }

    @Override
    public Map<String,Object> getSequExecuteOrder(Integer batchId, Integer id) {
        return workOrderMapper.getSequExecuteOrder(batchId,id);
    }

    @Override
    public boolean updateAllowedExecute(Integer id, boolean allowedExecute) {
        return workOrderMapper.updateAllowedExecute(id,allowedExecute)==1;
    }

    @Override
    public List<Map<String, Object>> getOrderByApply(String status) {
        return workOrderMapper.getOrderByApply(status);
    }
}
