package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.WorkOrder;
import com.nongxin.terminal.util.enumUtil.plan.FarmingLocationEnum;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderStatusEnum;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderTypeEnum;
import com.nongxin.terminal.vo.lookboard.WorkOrderVo;
import com.nongxin.terminal.vo.workorder.AppOrderVo;
import com.nongxin.terminal.vo.workorder.LocalVo;
import com.nongxin.terminal.vo.workorder.OrderConditionVo;
import com.nongxin.terminal.vo.workorder.RealTimeOrder;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface WorkOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WorkOrder record);

    int insertSelective(WorkOrder record);

    WorkOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkOrder record);

    int updateByPrimaryKey(WorkOrder record);

    List<WorkOrder> getWorkOrderByBatchId(Integer batchId);

    int deleteByBatchId(@Param("batchId") Integer batchId,@Param("type") WorkOrderTypeEnum type);

    List<WorkOrder> getWorkOrder(OrderConditionVo orderConditionVo);

    //导出工单为表格
    List<WorkOrder> exportWorkOrder(OrderConditionVo orderConditionVo);

    int updateStatus(@Param("id")Integer id, @Param("status")WorkOrderStatusEnum status, @Param("examineTime")Date examineTime);

    int deleteTemporaryOrder(@Param("batchId")Integer batchId,@Param("farmingId") Integer farmingId,@Param("type")WorkOrderTypeEnum type);

    WorkOrder getOrderByBatchIdAndFarmingId(@Param("batchId")Integer batchId,@Param("farmingId") Integer farmingId,@Param("type")WorkOrderTypeEnum type);

    //根据用户用户对应工单
    List<AppOrderVo> getAppOrderVo(@Param("uid") Integer uid,@Param("status")WorkOrderStatusEnum status,@Param("batchId")Integer batchId);

    List<WorkOrder> getOrderByBatchId(Integer batchId);

    AppOrderVo getOrderCosts(Integer id);

    List<WorkOrderVo> getOrderByCropId(Integer cropBatchId);

    //根据追溯码获取工单
    List<WorkOrder> getOrderByRetroCode(String retroCode);

    Map<String,Object> getOrderIsLocal(Integer orderId);

    LocalVo getOrderLocal(@Param("orderId")Integer orderId,@Param("isLocal")FarmingLocationEnum isLocal);

    List<RealTimeOrder> getRealTimeOrder();

    List<Map<String,Object>> getCompleteOrder();

    List<Map<String,Object>> getLookOrder();

    WorkOrder selectById(@Param("id") Integer id);

    Map<String,Object> getSequExecuteOrder(@Param("batchId")Integer batchId,@Param("id")Integer id);

    int updateAllowedExecute(@Param("id")Integer id,@Param("allowedExecute")boolean allowedExecute);

    List<Map<String,Object>> getOrderByApply(@Param("status")String status);


    WorkOrder selectworkerOrderByLoanItemId(Integer loanItemId);
}