package com.nongxin.terminal.service.plan;

import com.nongxin.terminal.entity.plant.WorkOrder;
import com.nongxin.terminal.support.BaseException;
import com.nongxin.terminal.util.enumUtil.plan.FarmingLocationEnum;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderStatusEnum;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.workorder.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface WorkOrderService {

    //添加工单
    boolean add(Integer batchId) throws BaseException;

    boolean delete(Integer id);

    boolean update(WorkOrder workOrder);

    //撤销工单
    boolean revokeWorkOrder(Integer batchId);

    List<WorkOrder> getWorkOrder(OrderConditionVo orderConditionVo);

    //修改工单状态
    boolean updateStatus(Integer id, WorkOrderStatusEnum status, Date examineTime);

    //添加临时工单
    boolean addTemporaryOrder(Integer[] batchIds,Integer farmingId) throws BaseException;

    //撤销临时工单
    Result revokeTemporaryOrder(Integer[] batchIds, Integer farmingId);

    //导出工单为表格
    List<WorkOrder> exportWorkOrder(OrderConditionVo orderConditionVo);

    //根据用户用户对应工单
    List<AppOrderVo> getAppOrderVo(Integer uid, WorkOrderStatusEnum status,Integer batchId);

    //根据批次id获取工单(溯源)
    List<WorkOrder> getOrderByBatchId(Integer batchId);

    //执行工单(app)
    boolean executingOrder(WorkOrder workOrder);

    //查询工单费用
    AppOrderVo getOrderCosts(Integer id);

    //根据工单id查询工单
    WorkOrder selectByPrimaryKey(Integer id);

    //根据追溯码获取工单
    List<WorkOrder> getOrderByRetroCode(String retroCode);

    //获取工单是否需要定位
    Map<String,Object> getOrderIsLocal(Integer orderId);

    //查询工单执行时的定位信息
    LocalVo getOrderLocal(Integer orderId, FarmingLocationEnum isLocal);

    //修改工单执行角色
    boolean updateOrderRole(Integer[] roleIds,Integer orderId);

    //获取实时工单
    List<RealTimeOrder> getRealTimeOrder();

    //获取近三天完成的工单
    List<Map<String,Object>> getCompleteOrder();

    //获取最近20条待审核和审核通过
    List<Map<String,Object>> getLookOrder();

    //根据id查询工单开始结束时间
    WorkOrder selectById(Integer id);

    Map<String,Object> getSequExecuteOrder(Integer batchId,Integer id);

    boolean updateAllowedExecute(Integer id,boolean allowedExecute);

    List<Map<String,Object>> getOrderByApply(String status);

}
