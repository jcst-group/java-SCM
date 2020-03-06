package com.nongxin.terminal.controller.scfinance.detection;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.dao.scfinance.detection.DetectOrderMapper;
import com.nongxin.terminal.entity.scfinance.insurance.DetectFeeItem;
import com.nongxin.terminal.entity.scfinance.insurance.DetectOrder;
import com.nongxin.terminal.service.scfinance.detection.impl.DetectFeeItemServiceImpl;
import com.nongxin.terminal.service.scfinance.detection.impl.DetectOrderServiceImpl;
import com.nongxin.terminal.service.scfinance.insurance.impl.InsuranceOrderMessageServiceImpl;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.scfinance.*;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finance/detect/")
public class DetectionController {

    @Autowired
    private DetectOrderMapper orderMapper;

    @Autowired
    private DetectOrderServiceImpl detectOrderService;

    @Autowired
    private InsuranceOrderMessageServiceImpl orderMessageService;

    @Autowired
    private DetectFeeItemServiceImpl feeItemService;

    @GetMapping("/listToOrderUser")
    @ApiOperation(value = "订单企业查询自己的检测订单信息", notes = "订单企业查询自己的检测订单信息")
    public Result queryCoopApplyList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                     @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                     DetectOrder detectOrder){
        Result result = new Result();
        Page<DetectOrder> page = new Page<>(pageNo, pageSize);
        QueryWrapper<DetectOrder> wrapper = new QueryWrapper<>();

        Integer fnanceUserId = JwtUtil.queryFnanceUserId();
        wrapper.eq("order_user_id", fnanceUserId);

        warpperQuery(wrapper,detectOrder);

        IPage<DetectOrder> detectOrderIPage = orderMapper.orderList(page, wrapper);

        result.setSuccessResult(detectOrderIPage);
        return result;
    }

    @GetMapping("/listToDetectUser")
    @ApiOperation(value = "检测机构查询检测订单信息", notes = "检测机构查询检测订单信息")
    public Result listToDetectUser(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                    DetectOrder detectOrder){
        Result result = new Result();
        Page<DetectOrder> page = new Page<>(pageNo, pageSize);
        QueryWrapper<DetectOrder> wrapper = new QueryWrapper<>();

        Integer fnanceUserId = JwtUtil.queryFnanceUserId();
        wrapper.eq("detect_user_id", fnanceUserId);
        wrapper.ne("detect_status", InsuranceStatusEnum.SAVE.getValue().intValue());

        warpperQuery(wrapper,detectOrder);

        IPage<DetectOrder> detectOrderIPage = orderMapper.orderList(page, wrapper);

        result.setSuccessResult(detectOrderIPage);
        return result;
    }

    @GetMapping("/listToFinanceUser")
    @ApiOperation(value = "合作社企业查询检测订单信息", notes = "合作社企业查询检测订单信息")
    public Result listToFinanceUser(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                     @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                     DetectOrder detectOrder){
        Result result = new Result();
        Page<DetectOrder> page = new Page<>(pageNo, pageSize);
        QueryWrapper<DetectOrder> wrapper = new QueryWrapper<>();

        Integer fnanceUserId = JwtUtil.queryFnanceUserId();
        wrapper.eq("finance_user_id", fnanceUserId);
        wrapper.ne("detect_status", InsuranceStatusEnum.SAVE.getValue().intValue());
        warpperQuery(wrapper,detectOrder);

        IPage<DetectOrder> detectOrderIPage = orderMapper.orderList(page, wrapper);

        result.setSuccessResult(detectOrderIPage);
        return result;
    }

    private void warpperQuery(QueryWrapper<DetectOrder> queryWrapper, DetectOrder detectOrder ){

        DetectionTypeEnum insuranceType = detectOrder.getInsuranceType();
        if(insuranceType!=null){
            queryWrapper.eq("insurance_type",insuranceType.getValue().intValue());
        }
        DetectionStatusEnum detectStatus = detectOrder.getDetectStatus();
        if(detectStatus!=null){
            queryWrapper.eq("detect_status",detectStatus.getValue().intValue());
        }
        List<DetectionStatusEnum> statusEnums = detectOrder.getStatusEnums();
        if(statusEnums!=null){
            queryWrapper.and(wrapper->{
                statusEnums.forEach(e->wrapper.or().eq("detect_status",e.getValue().intValue()));
            });
        }

        queryWrapper.orderByDesc("id");

    }
    @PostMapping("/saveOrUpdate")
    @ApiOperation(value = "添加或修改贷款申请单",notes = "添加或修改贷款申请单")
    public Result saveOrUpdate(@RequestBody DetectOrder detectOrder){
        Result result = new Result<>();
        String message = "";
        boolean save = false;

        try {
            Integer id = detectOrder.getId();
            save = detectOrderService.saveOrUpdateApply(detectOrder);
            if(id==null){
                id = detectOrder.getId();
                orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.DETECTION_APPLY, MessageStatusEnum.DETECT_SAVE, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            save = false;
            message = e.getMessage();
        }
        if(save){
            result.setMessage("保存检测申请单成功");
        }else{
            message = message == ""?"保存检测申请单失败":message;
            result.setMessage(message);
        }
        result.setSuccess(save);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除检测申请",notes = "删除检测申请")
    public Result deleteDetectApply(@RequestParam Integer id){
        Result result = new Result<>();
        boolean delete = false;

        String message = "";
        try {
            DetectOrder detectOrder = detectOrderService.getById(id);
            if(detectOrder==null){
                message = "检测申请不存在";

            }else{
                DetectionStatusEnum detectStatus = detectOrder.getDetectStatus();
                //状态为保存，拒绝，或取消，可删除订单
                if(detectStatus == DetectionStatusEnum.SAVE
                        || detectStatus == DetectionStatusEnum.CANCEL
                        || detectStatus == DetectionStatusEnum.FAIL_APPLY){
                    //级联删除
                    delete = detectOrderService.removeById(id);
                } else{
                    message = "检测申请状态不为保存、拒绝或取消状态，不允许删除";
                }
            }

        } catch (Exception e) {
            delete = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }

        if(delete){
            result.setMessage("删除检测申请单成功");
        }else{
            if(message.equals("")){
                message = "删除检测申请单失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(delete);
        return result;
    }

    @GetMapping("/apply")
    @ApiOperation(value = "检测申请发起申请",notes = "检测申请发起申请")
    public Result applyLoan(@RequestParam Integer id){
        Result result = new Result<>();
        boolean deal = false;

        String message = "";
        try {
            DetectOrder detectOrder = detectOrderService.getById(id);
            if(detectOrder==null){
                message = "该贷款申请不存在";

            }else{
                DetectionStatusEnum detectStatus = detectOrder.getDetectStatus();
                //保存或退回状态可以发起申请
                if(detectStatus == DetectionStatusEnum.SAVE
                        || detectStatus == DetectionStatusEnum.FAIL_APPLY
                        || detectStatus == DetectionStatusEnum.CANCEL){

                    detectOrder.setDetectStatus(DetectionStatusEnum.DETECT_CONFIRM);

                    deal = detectOrderService.saveOrUpdate(detectOrder);

                    MessageStatusEnum messageNextStatu = MessageStatusEnum.DETECT_CONFIRM_APPLY;
                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.DETECTION_APPLY, messageNextStatu, null);

                } else{
                    message = "检测申请状态不为保存、拒绝或取消状态，不允许发起申请";
                }
            }
        } catch (Exception e) {
            deal = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(deal){
            result.setMessage("检测申请发起申请成功");
        }else{
            if(message.equals("")){
                message = "检测申请发起申请失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(deal);
        return result;
    }

    @PostMapping("/detectAccept")
    @ApiOperation(value = "检测方确认检测申请",notes = "检测方确认检测申请")
    public Result detectAccept(@RequestBody DetectOrder order){
        Result result = new Result<>();
        boolean deal = false;
        Integer id = order.getId();
        String message = "";
        String dealMessage = order.getDealMessage();
        try {
            DetectOrder detectOrder = detectOrderService.getById(id);
            List<DetectFeeItem> feeItems = order.getFeeItems();
            if(detectOrder==null){
                message = "该检测申请不存在";
            }else if(feeItems==null || feeItems.size()==0){
                message = "该检测申请费用项不能为空";
            }else{
                DetectionStatusEnum detectStatus = detectOrder.getDetectStatus();
                //检测机构待检测状态可以处理
                if(detectStatus == DetectionStatusEnum.DETECT_CONFIRM){
                    detectOrder.setDetectStatus(DetectionStatusEnum.COOP_CONFIRM);
                    deal = detectOrderService.saveOrUpdate(detectOrder);

                    for(DetectFeeItem feeItem:feeItems){
                        feeItem.setDetectOrderId(detectOrder.getId());
                        feeItemService.save(feeItem);
                    }

                    MessageStatusEnum messageNextStatu = MessageStatusEnum.DETECT_CONFIRM_PASS;
                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.DETECTION_APPLY, messageNextStatu, dealMessage);

                } else{
                    message = "检测申请状态不为检测机构确认状态，不允许发起操作";
                }
            }
        } catch (Exception e) {
            deal = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(deal){
            result.setMessage("检测机构确认检测发起成功");
        }else{
            if(message.equals("")){
                message = "检测机构确认检测发起失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(deal);
        return result;
    }

    @GetMapping("/coopAccept")
    @ApiOperation(value = "合作社认检测申请",notes = "合作社认检测申请")
    public Result coopAccept(@RequestParam Integer id,@RequestParam(defaultValue = "",name = "dealMessage") String commont){
        Result result = new Result<>();
        boolean deal = false;
        String message = "";
        try {
            DetectOrder detectOrder = detectOrderService.getById(id);
            if(detectOrder==null){
                message = "该检测申请不存在";
            }else{
                DetectionStatusEnum detectStatus = detectOrder.getDetectStatus();
                //检测机构待检测状态可以处理
                if(detectStatus == DetectionStatusEnum.COOP_CONFIRM){
                    detectOrder.setDetectStatus(DetectionStatusEnum.DETECT_DEALING);
                    deal = detectOrderService.saveOrUpdate(detectOrder);

                    MessageStatusEnum messageNextStatu = MessageStatusEnum.DETECT_COOPCONFIRM_PASS;
                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.DETECTION_APPLY, messageNextStatu, commont);

                } else{
                    message = "检测申请状态不为合作社确认状态，不允许发起操作";
                }
            }
        } catch (Exception e) {
            deal = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(deal){
            result.setMessage("合作社确认检测发起成功");
        }else{
            if(message.equals("")){
                message = "合作社确认检测发起失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(deal);
        return result;
    }

    @GetMapping("/finish")
    @ApiOperation(value = "检测机构确认完成订单",notes = "检测机构确认完成订单")
    public Result finishDetect(@RequestParam Integer id,@RequestParam(defaultValue = "",name = "dealMessage") String commont, @RequestParam(defaultValue = "") String dealer){
        Result result = new Result<>();
        boolean deal = false;
        String message = "";
        try {
            DetectOrder detectOrder = detectOrderService.getById(id);
            if(detectOrder==null){
                message = "该检测申请不存在";
            }else{
                DetectionStatusEnum detectStatus = detectOrder.getDetectStatus();
                //检测机构待检测状态可以处理
                if(detectStatus == DetectionStatusEnum.DETECT_DEALING){
                    detectOrder.setDetectStatus(DetectionStatusEnum.FINISH);
                    //检测处理人
                    detectOrder.setCharTwo(dealer);
                    deal = detectOrderService.saveOrUpdate(detectOrder);

                    MessageStatusEnum messageNextStatu = MessageStatusEnum.DETECT_FINISH;
                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.DETECTION_APPLY, messageNextStatu, commont);

                } else{
                    message = "检测申请状态不为检测机构检测中状态，不允许发起操作";
                }
            }
        } catch (Exception e) {
            deal = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(deal){
            result.setMessage("检测机构完成检测发起成功");
        }else{
            if(message.equals("")){
                message = "检测机构完成检测发起失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(deal);
        return result;
    }

    @GetMapping("/reject")
    @ApiOperation(value = "检测申请取消",notes = "检测申请取消")
    public Result detectReject(@RequestParam Integer id,@RequestParam(defaultValue = "",name = "dealMessage") String dealMessage,@RequestParam Integer type){
        Result result = new Result<>();
        boolean deal = false;
        String message = "";
        try {
            DetectOrder detectOrder = detectOrderService.getById(id);
            if(detectOrder==null){
                message = "该检测申请不存在";
            }else{
                DetectionStatusEnum detectStatus = detectOrder.getDetectStatus();
                if(detectStatus != DetectionStatusEnum.SAVE
                        && detectStatus != DetectionStatusEnum.FINISH
                        && detectStatus != DetectionStatusEnum.DETECT_DEALING
                        && detectStatus != DetectionStatusEnum.FAIL_APPLY
                ){
                    //审批不通过，走类型
                    detectOrder.setDetectStatus(DetectionStatusEnum.FAIL_APPLY);
                    deal = detectOrderService.saveOrUpdate(detectOrder);

                    MessageStatusEnum messageNextStatu = null;
                    if(type.equals(1)){
                        messageNextStatu = MessageStatusEnum.DETECT_CONFIRM_REJECT;
                    }else if(type.equals(2)){
                        messageNextStatu = MessageStatusEnum.DETECT_COOPCONFIRM_REJECT;
                    }

                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.DETECTION_APPLY, messageNextStatu, dealMessage);
                } else{
                    message = "检测申请状态不为检测审批状态，不允许处理检测审批";
                }
            }
        } catch (Exception e) {
            deal = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(deal){
            result.setMessage("检测审批处理成功");
        }else{
            if(message.equals("")){
                message = "贷款审批处理失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(deal);
        return result;
    }

    @GetMapping("/cancel")
    @ApiOperation(value = "取消检测申请",notes = "取消检测申请")
    public Result applyCancel(@RequestParam Integer id,@RequestParam(defaultValue = "",name = "dealMessage") String dealMessage){
        Result result = new Result<>();
        boolean deal = false;
        String message = "";
        try {
            DetectOrder detectOrder = detectOrderService.getById(id);
            if(detectOrder==null){
                message = "该检测申请不存在";
            }else{
                DetectionStatusEnum detectStatus = detectOrder.getDetectStatus();
                if(detectStatus != DetectionStatusEnum.DETECT_DEALING
                        && detectStatus != DetectionStatusEnum.FINISH
                ){
                    detectOrder.setDetectStatus(DetectionStatusEnum.CANCEL);
                    deal = detectOrderService.saveOrUpdate(detectOrder);

                    MessageStatusEnum messageNextStatu = MessageStatusEnum.DETECT_CANCEL;

                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.DETECTION_APPLY, messageNextStatu, dealMessage);
                } else{
                    message = "检测申请已处于检测中或检测完成状态，不允许取消";
                }
            }
        } catch (Exception e) {
            deal = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(deal){
            result.setMessage("检测申请取消成功");
        }else{
            if(message.equals("")){
                message = "检测申请取消失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(deal);
        return result;
    }
}
