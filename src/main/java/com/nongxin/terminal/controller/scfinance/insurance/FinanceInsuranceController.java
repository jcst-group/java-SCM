package com.nongxin.terminal.controller.scfinance.insurance;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.dao.scfinance.insurance.InsuranceOrderMapper;
import com.nongxin.terminal.entity.scfinance.insurance.InsuranceOrder;
import com.nongxin.terminal.entity.scfinance.insurance.InsurancePlantInfo;
import com.nongxin.terminal.service.scfinance.insurance.impl.InsuranceOrderMessageServiceImpl;
import com.nongxin.terminal.service.scfinance.insurance.impl.InsuranceOrderServiceImpl;
import com.nongxin.terminal.service.scfinance.insurance.impl.InsurancePlantInfoServiceImpl;
import com.nongxin.terminal.util.FinanceCodeUtil;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.common.CodeEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.InsuranceStatusEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.InsuranceTypeEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.MessageRelateTypeEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.MessageStatusEnum;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.insurance.InsuranceOrderVo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author clover
 * @since 2019-12-16
 */
@RestController
@RequestMapping("/finance")
public class FinanceInsuranceController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceInsuranceController.class);

    @Autowired
    private InsuranceOrderMapper insuranceOrderMapper;

    @Autowired
    private InsuranceOrderServiceImpl insuranceOrderService;

    @Autowired
    private InsurancePlantInfoServiceImpl insurancePlantInfoService;

    @Autowired
    private InsuranceOrderMessageServiceImpl orderMessageService;

    @GetMapping("/order/listToCoop")
    @ApiOperation(value = "社员查询自己的保险申请单信息列表", notes = "GET分页查询社员信息列表")
    public Result getCoopsOrderList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                    InsuranceOrder insuranceOrder) {
        Result result = new Result<>();
        Page<InsuranceOrder> page = new Page<>(pageNo, pageSize);
        QueryWrapper<InsuranceOrder> wrapper = new QueryWrapper<>();
        //金融用户ID代表当前的用户ID
        Integer fnanceUserId = JwtUtil.queryFnanceUserId();
        wrapper.eq("finance_user_id", fnanceUserId);
        wrapper.orderByDesc("id");
        InsuranceStatusEnum orderStatus = insuranceOrder.getOrderStatus();
        if(orderStatus!=null){
            wrapper.eq("order_status", orderStatus.getValue());
        }

        InsuranceTypeEnum insuranceType = insuranceOrder.getInsuranceType();
        if(insuranceType!=null){
            wrapper.eq("insurance_type", insuranceType.getValue());
        }

        IPage<InsuranceOrder> insuranceOrderIPage = insuranceOrderMapper.orderList(page, wrapper);
        //IPage<FinanceMember> page1 = financeMemberMapper.memberList(page,wrapper);
        //List<FinanceMember> financeMemberList = financeMemberMapper.testQueryFinanceCominfo(wrapper);
        result.setSuccessResult(insuranceOrderIPage);
        return result;
    }

    @GetMapping("/order/listToInsurance")
    @ApiOperation(value = "保险公司查询投保公司为本公司的保险申请单信息列表", notes = "GET分页查询社员信息列表")
    public Result getInsurancesOrderList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                         @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                         InsuranceOrder insuranceOrder) {
        Result result = new Result<>();
        Page<InsuranceOrder> page = new Page<>(pageNo, pageSize);
        QueryWrapper<InsuranceOrder> wrapper = new QueryWrapper<>();
        //金融用户ID代表当前的用户ID
        Integer fnanceUserId = JwtUtil.queryFnanceUserId();
        wrapper.eq("insurance_id", fnanceUserId);
        wrapper.orderByDesc("id");
        wrapper.notIn("order_status",
                InsuranceStatusEnum.SAVE);

        InsuranceStatusEnum orderStatus = insuranceOrder.getOrderStatus();
        if(orderStatus!=null){
            wrapper.eq("order_status", orderStatus.getValue());
        }

        InsuranceTypeEnum insuranceType = insuranceOrder.getInsuranceType();
        if(insuranceType!=null){
            wrapper.eq("insurance_type", insuranceType.getValue());
        }

        IPage<InsuranceOrder> insuranceOrderIPage = insuranceOrderMapper.orderList(page, wrapper);
        result.setSuccessResult(insuranceOrderIPage);
        return result;
    }

    @PostMapping("/order/saveOrUpdate")
    @ApiOperation(value = "添加或修改保险申请单",notes = "添加或修改保险申请单")
    public Result saveOrUpdate(@RequestBody InsuranceOrder order){
        Result result = new Result<>();
        String message = "";
        boolean save = false;
        try {
            //填充多租户字段，合作社ID
            Integer orderId = order.getId();
            if( orderId == null ){
                Integer fnanceUserId = JwtUtil.queryFnanceUserId();
                order.setFinanceUserId(fnanceUserId);
                order.setTenantId(fnanceUserId);
                order.setOrderStatus(InsuranceStatusEnum.SAVE);
                order.setInsuranceOrder(FinanceCodeUtil.getCode(CodeEnum.IS));
            }

            //保存保险基本信息
            save = insuranceOrderService.saveOrUpdate(order);

            //根据保险类型，保存不同的保险所需信息
            //种植险保存种植险信息
            LOGGER.info("order.getInsuranceType():"+order.getInsuranceType());
            if(order.getInsuranceType().equals(InsuranceTypeEnum.PLANT_INSURANCE)){
                InsurancePlantInfo plantInfo = order.getPlantInfo();
                if(plantInfo == null){
                    message = "种植信息不能为空";
                    throw new NullPointerException(message);
                }
                plantInfo.setInsuranceId(order.getId());
                insurancePlantInfoService.saveOrUpdatePlantInfo(plantInfo);
            }

            //保存操作信息
            if(orderId==null){
                Integer newOrderId = order.getId();
                boolean b = orderMessageService.insertRelateMessage(newOrderId, MessageRelateTypeEnum.ORDER_RELATE, MessageStatusEnum.ORDER_CREATE, null);
            }

        } catch (Exception e) {
            save = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }

        if(save){
            result.setMessage("保存保单信息成功");
        }else{
            message = message == ""?"保存保单信息失败":message;
            result.setMessage(message);
        }
        result.setSuccess(save);
        return result;
    }

    @GetMapping("/order/delete")
    @ApiOperation(value = "删除贷款订单",notes = "删除贷款订单")
    public Result delete(@RequestParam Integer id){
        Result result = new Result<>();
        boolean delete = false;

        String message = "";
        try {
            InsuranceOrder order = insuranceOrderService.getById(id);
            if(order==null){
                message = "保险申请单不存在";

            }else{
                InsuranceStatusEnum orderStatus = order.getOrderStatus();
                //状态为保存，拒绝，或取消，可删除订单
                if(orderStatus == InsuranceStatusEnum.REJECT
                        || orderStatus == InsuranceStatusEnum.SAVE
                        || orderStatus == InsuranceStatusEnum.CANCEL){
                    //级联删除
                    delete = insuranceOrderService.removeById(id);
                } else{
                    message = "保险申请单状态不为保存、拒绝或取消状态，不允许删除";
                }
            }

        } catch (Exception e) {
            delete = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }

        if(delete){
            result.setMessage("删除保险申请单信息成功");
        }else{
            if(message.equals("")){
                message = "删除保险申请单信息失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(delete);
        return result;
    }

    @GetMapping("/order/applyOrder")
    @ApiOperation(value = "保险订单发起申请",notes = "保险订单发起申请")
    public Result applyOrder(@RequestParam Integer id){
        Result result = new Result<>();
        boolean apply = false;

        String message = "";
        try {
            InsuranceOrder order = insuranceOrderService.getById(id);
            if(order==null){
                message = "保险申请单不存在";

            }else{
                InsuranceStatusEnum orderStatus = order.getOrderStatus();
                //保存或退回状态可以发起申请
                if(orderStatus==InsuranceStatusEnum.SAVE
                        || orderStatus == InsuranceStatusEnum.REJECT
                        || orderStatus == InsuranceStatusEnum.CANCEL){
                    order.setOrderStatus(InsuranceStatusEnum.APPLYING);
                    apply = insuranceOrderService.saveOrUpdate(order);

                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.ORDER_RELATE, MessageStatusEnum.ORDER_APPLY, null);

                } else{
                    message = "保险申请单状态不为保存、拒绝或取消状态，不允许发起申请";
                }
            }

        } catch (Exception e) {
            apply = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(apply){
            result.setMessage("保险申请单发起申请成功");
        }else{
            if(message.equals("")){
                message = "保险申请单发起申请失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(apply);
        return result;
    }

    @GetMapping("/order/cancelOrder")
    @ApiOperation(value = "取消发起的保险申请单申请",notes = "取消发起的保险申请单申请")
    public Result cancelOrder(@RequestParam Integer id, @RequestParam(defaultValue = "") String comment){
        Result result = new Result<>();
        boolean apply = false;

        String message = "";
        try {
            InsuranceOrder order = insuranceOrderService.getById(id);
            if(order==null){
                message = "保险申请单不存在";

            }else{
                InsuranceStatusEnum orderStatus = order.getOrderStatus();
                //发起申请
                if(orderStatus==InsuranceStatusEnum.APPLYING){
                    order.setOrderStatus(InsuranceStatusEnum.CANCEL);
                    apply = insuranceOrderService.saveOrUpdate(order);
                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.ORDER_RELATE, MessageStatusEnum.ORDER_CANCEL, null);
                } else{
                    message = "保险申请单状态不为申请状态，不允许取消申请";
                }
            }

        } catch (Exception e) {
            apply = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(apply){
            result.setMessage("保险申请单取消申请成功");
        }else{
            if(message.equals("")){
                message = "保险申请单取消申请失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(apply);
        return result;
    }

    @GetMapping("/order/acceptOrder")
    @ApiOperation(value = "保险公司接受发起的保险申请单申请",notes = "保险公司接受发起的保险申请单申请")
    public Result acceptOrder(@RequestParam Integer id, @RequestParam String comment){
        Result result = new Result<>();
        boolean apply = false;

        String message = "";
        try {
            InsuranceOrder order = insuranceOrderService.getById(id);
            if(order==null){
                message = "保险申请单不存在";

            }else{
                InsuranceStatusEnum orderStatus = order.getOrderStatus();
                //接受保单
                if(orderStatus==InsuranceStatusEnum.APPLYING){
                    order.setOrderStatus(InsuranceStatusEnum.ACCEPT);
                    apply = insuranceOrderService.saveOrUpdate(order);
                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.ORDER_RELATE, MessageStatusEnum.ORDER_ACCEPT, comment);
                } else{
                    message = "保险申请单状态不为申请状态，不允许接受保单";
                }
            }

        } catch (Exception e) {
            apply = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(apply){
            result.setMessage("保险申请单接受受保申请成功");
        }else{
            if(message.equals("")){
                message = "保险申请单接受受保申请失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(apply);
        return result;
    }

    @GetMapping("/order/rejectOrder")
    @ApiOperation(value = "保险公司拒接受发起的保险申请单申请",notes = "保险公司拒接发起的保险申请单申请")
    public Result rejectOrder(@RequestParam Integer id, @RequestParam String comment){
        Result result = new Result<>();
        boolean apply = false;

        String message = "";
        try {
            InsuranceOrder order = insuranceOrderService.getById(id);
            if(order==null){
                message = "保险申请单不存在";

            }else{
                InsuranceStatusEnum orderStatus = order.getOrderStatus();
                //接受保单
                if(orderStatus==InsuranceStatusEnum.APPLYING){
                    order.setOrderStatus(InsuranceStatusEnum.REJECT);
                    apply = insuranceOrderService.saveOrUpdate(order);
                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.ORDER_RELATE, MessageStatusEnum.ORDER_ACCEPT, comment);
                } else{
                    message = "保险申请单状态不为申请状态，不允许拒接保单";
                }
            }

        } catch (Exception e) {
            apply = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(apply){
            result.setMessage("保险申请单拒绝受保成功");
        }else{
            if(message.equals("")){
                message = "保险申请单拒绝受保失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(apply);
        return result;
    }

    @PostMapping("/order/finishOrder")
    @ApiOperation(value = "保险公司完成保险申请单",notes = "保险公司完成保险申请单")
    public Result finishOrder(@RequestBody InsuranceOrderVo insuranceOrder){

        Integer id = insuranceOrder.getId();

        Date actualStartTime = insuranceOrder.getActualStartTime();
        Date actualEndTime = insuranceOrder.getActualEndTime();

        String comment = insuranceOrder.getMessage();

        Result result = new Result<>();
        boolean apply = false;
        String message = "";
        try {
            if(id==null){
                message = "工单ID不能为空";
                throw new RuntimeException("工单ID不能为空");
            }

            if(actualEndTime==null || actualStartTime == null){
                message = "实际开始时间和实际结束时间不能为空";
                throw new RuntimeException("实际开始时间和实际结束时间不能为空");
            }


            InsuranceOrder order = insuranceOrderService.getById(id);
            if(order==null){
                message = "保险申请单不存在";

            }else{
                InsuranceStatusEnum orderStatus = order.getOrderStatus();
                //接受保单
                if(orderStatus==InsuranceStatusEnum.ACCEPT){
                    order.setActualEndTime(actualEndTime);
                    order.setActualStartTime(actualStartTime);
                    order.setOrderStatus(InsuranceStatusEnum.FINISH);
                    apply = insuranceOrderService.saveOrUpdate(order);
                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.ORDER_RELATE, MessageStatusEnum.ORDER_ACCEPT, comment);
                } else{
                    message = "保险申请单状态不为受保状态，不允许完成保单";
                }
            }

        } catch (Exception e) {
            apply = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(apply){
            result.setMessage("保险申请单完成成功");
        }else{
            if(message.equals("")){
                message = "保险申请单完成失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(apply);
        return result;
    }

}
