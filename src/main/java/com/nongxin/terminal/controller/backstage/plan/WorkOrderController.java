package com.nongxin.terminal.controller.backstage.plan;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.dao.push.WorkOrderQueryMapper;
import com.nongxin.terminal.entity.plant.WorkOrder;
import com.nongxin.terminal.service.plan.WorkOrderService;
import com.nongxin.terminal.support.BaseException;
import com.nongxin.terminal.util.ExportExcelUtil;
import com.nongxin.terminal.util.enumUtil.plan.FarmingLocationEnum;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderStatusEnum;
import com.nongxin.terminal.util.push.PushUtil;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.push.CIDVo;
import com.nongxin.terminal.vo.workorder.OrderConditionVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/workOrder")
public class WorkOrderController {

    @Autowired
    private WorkOrderService workOrderService;
    @Autowired
    private ExportExcelUtil export;
    @Autowired
    private PushUtil pushUtil;
    @Autowired
    private WorkOrderQueryMapper workOrderQueryMapper;

    @GetMapping("/add")
    @ApiOperation("添加工单")
    public Result addWorkOrder(@RequestParam(required = true) Integer batchId) throws BaseException {
        Result result = new Result();
        boolean isSuccess = workOrderService.add(batchId);
        if (isSuccess){
            result.setMessage("添加工单成功");
        }else {
            result.setMessage("添加工单失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/addTemporaryOrder")
    @ApiOperation("添加临时工单")
    public Result addTemporaryOrder(Integer[] batchIds,Integer farmingId) throws BaseException {
        Result result = new Result();
        boolean isSuccess = workOrderService.addTemporaryOrder(batchIds,farmingId);
        if (isSuccess){
            result.setMessage("添加临时工单成功");
        }else {
            result.setMessage("添加临时工单失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除工单")
    public Result deleteWorkOrder(Integer id){
        Result result = new Result();
        boolean isSuccess = workOrderService.delete(id);
        if (isSuccess){
            result.setMessage("删除工单成功");
        }else {
            result.setMessage("删除工单失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改工单")
    public Result updateWorkOrder(@RequestBody WorkOrder workOrder){
        Result result = new Result();
        boolean isSuccess = workOrderService.update(workOrder);
        if (isSuccess){
            result.setMessage("修改工单成功");
        }else {
            result.setMessage("修改工单失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/updateAllowedExecute")
    @ApiOperation("修改工单时间外执行状态")
    public Result updateWorkOrder(@RequestParam(required = true)Integer id,@RequestParam(required = true)boolean allowedExecute){
        Result result = new Result();
        boolean isSuccess = workOrderService.updateAllowedExecute(id,allowedExecute);
        if (isSuccess){
            result.setMessage("修改成功");
        }else {
            result.setMessage("修改失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/revokeWorkOrder")
    @ApiOperation("撤销工单")
    public Result revokeWorkOrder(@RequestParam(required = true)Integer batchId){
        Result result = new Result();
        boolean isSuccess = workOrderService.revokeWorkOrder(batchId);
        if (isSuccess){
            result.setMessage("撤销工单成功");
        }else {
            result.setMessage("工单已开始执行，无法撤销");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/revokeTemporaryOrder")
    @ApiOperation("撤销临时工单")
    public Result revokeTemporaryOrder(@RequestParam(required = true)Integer[] batchIds,@RequestParam(required = true)Integer farmingId){
        return workOrderService.revokeTemporaryOrder(batchIds,farmingId);
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询工单")
    public Result<PageInfo> getBaseList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                        @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                        OrderConditionVo orderConditionVo){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<WorkOrder> roleList = workOrderService.getWorkOrder(orderConditionVo);
        PageInfo pageInfo = new PageInfo(roleList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/setNotAudited")
    @ApiOperation("退回待审核")
    public Result setNotAudited(@RequestParam(required = true)Integer id){
        Result result = new Result();
        boolean isSuccess = workOrderService.updateStatus(id, WorkOrderStatusEnum.NOT_AUDITED,null);
        if (isSuccess){
            result.setMessage("操作成功");
        }else {
            result.setMessage("操作失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/setAuditFailed")
    @ApiOperation("审核未通过")
    public Result setAuditFailed(@RequestParam(required = true)Integer id){
        Result result = new Result();
        boolean isSuccess = workOrderService.updateStatus(id, WorkOrderStatusEnum.AUDIT_FAILED,new Date());
        if (isSuccess){
            result.setMessage("操作成功");
            CIDVo cidVo = workOrderQueryMapper.getCidByWorkOrderId(id);
            if (cidVo.getCidList() != null) {
                for (int j = 0; j < cidVo.getCidList().size(); j++) {
                    String cid = cidVo.getCidList().get(j);
                    String baseName = cidVo.getBaseName();
                    String farmingName = cidVo.getFarmingName();
                    String date = getDateFormat(cidVo.getExecution_time());
                    pushUtil.push(cid, baseName + ": " + "农事项目" +"'" +farmingName+"'" + " 执行时间为：" + date + " 审核不通过,请查看！");
                }
            }

        }else {
            result.setMessage("操作失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/setAuditApproval")
    @ApiOperation("审核通过")
    public Result setAuditApproval(@RequestParam(required = true)Integer id){
        Result result = new Result();
        boolean isSuccess = workOrderService.updateStatus(id, WorkOrderStatusEnum.AUDIT_APPROVAL,new Date());
        if (isSuccess){
            result.setMessage("操作成功");
        }else {
            result.setMessage("操作失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/export")
    @ApiOperation("导出工单数据为表格")
    public void export(OrderConditionVo orderConditionVo, HttpServletResponse response){
        export.workOrderExport(orderConditionVo,response);
    }

    @GetMapping("/getOrderByBatchId")
    @ApiOperation("获取溯源工单")
    public Result getOrderByBatchId(@RequestParam(required = true)Integer batchId){
        Result result = new Result();
        List<WorkOrder> workOrderList= workOrderService.getOrderByBatchId(batchId);
        result.setSuccessResult(workOrderList);
        return result;
    }

    @GetMapping("/getOrderLocal")
    @ApiOperation("获取工单定位信息")
    public Result getOrderLocal(@RequestParam(required = true)Integer orderId){
        Result result = new Result();
        result.setSuccessResult(workOrderService.getOrderLocal(orderId, FarmingLocationEnum.YES));
        return result;
    }

    @GetMapping("/updateOrderRole")
    @ApiOperation("修改工单执行对应角色")
    public Result updateOrderRole(@RequestParam(required = true)Integer[] roleIds,@RequestParam(required = true)Integer orderId){
        Result result = new Result();
        boolean isSuccess = workOrderService.updateOrderRole(roleIds, orderId);
        if (isSuccess){
            result.setMessage("修改对应角色成功！！");
        }else {
            result.setMessage("修改对应角色失败！！");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    public String getDateFormat(Date date){
        String dateString =null;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        dateString = formatter.format(date);

        return dateString;
    }
}
