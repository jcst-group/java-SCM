package com.nongxin.terminal.controller.scfinance.loan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.dao.scfinance.loan.LoanBatchInfoMapper;
import com.nongxin.terminal.dao.scfinance.loan.LoanFinanceApplyMapper;
import com.nongxin.terminal.entity.scfinance.insurance.LoanFinanceApply;
import com.nongxin.terminal.service.scfinance.insurance.impl.InsuranceOrderMessageServiceImpl;
import com.nongxin.terminal.service.scfinance.loan.impl.LoanBatchInfoServiceImpl;
import com.nongxin.terminal.service.scfinance.loan.impl.LoanFinanceApplyServiceImpl;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.scfinance.*;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/finance")
public class LoanApplyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanApplyController.class);

    @Autowired
    private LoanFinanceApplyMapper loanFinanceApplyMapper;

    @Autowired
    private LoanFinanceApplyServiceImpl loanFinanceApplyService;

    @Autowired
    private LoanBatchInfoServiceImpl loanBatchInfoService;

    @Autowired
    private LoanBatchInfoMapper loanBatchInfoMapper;

    @Autowired
    private InsuranceOrderMessageServiceImpl orderMessageService;


    @GetMapping("/loan/listToCoop")
    @ApiOperation(value = "合作社查询自己的贷款申请单信息列表", notes = "GET分页查询合作社贷款申请信息列表")
    public Result queryCoopApplyList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                     @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                     LoanFinanceApply loanFinanceApply){
        Result result = new Result();
        Page<LoanFinanceApply> page = new Page<>(pageNo, pageSize);
        QueryWrapper<LoanFinanceApply> wrapper = new QueryWrapper<>();

        Integer fnanceUserId = JwtUtil.queryFnanceUserId();
        wrapper.eq("finance_user_id", fnanceUserId);

        warpperQuery(wrapper,loanFinanceApply);

        IPage<LoanFinanceApply> loanFinanceApplyIPage = loanFinanceApplyMapper.applyList(page, wrapper);

        result.setSuccessResult(loanFinanceApplyIPage);
        return result;
    }

    @GetMapping("/loan/listToGuarantee")
    @ApiOperation(value = "合作社查询自己的贷款申请单信息列表", notes = "GET分页查询合作社贷款申请信息列表")
    public Result queryGuaranteeApplyList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                     @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                     LoanFinanceApply loanFinanceApply){
        Result result = new Result();
        Page<LoanFinanceApply> page = new Page<>(pageNo, pageSize);
        QueryWrapper<LoanFinanceApply> wrapper = new QueryWrapper<>();

        Integer fnanceUserId = JwtUtil.queryFnanceUserId();
        wrapper.eq("guarantee_id", fnanceUserId);
        wrapper.eq("ifguarantee",1);
        //担保公司不会看到保存状态的数据
        wrapper.ne("status",InsuranceStatusEnum.SAVE);
        warpperQuery(wrapper,loanFinanceApply);
        IPage<LoanFinanceApply> loanFinanceApplyIPage = loanFinanceApplyMapper.applyList(page, wrapper);
        result.setSuccessResult(loanFinanceApplyIPage);
        return result;
    }

    @GetMapping("/loan/listToBank")
    @ApiOperation(value = "合作社查询自己的贷款申请单信息列表", notes = "GET分页查询合作社贷款申请信息列表")
    public Result queryBankApplyList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                          @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                          LoanFinanceApply loanFinanceApply){
        Result result = new Result();
        Page<LoanFinanceApply> page = new Page<>(pageNo, pageSize);
        QueryWrapper<LoanFinanceApply> wrapper = new QueryWrapper<>();

        Integer fnanceUserId = JwtUtil.queryFnanceUserId();
        wrapper.eq("bank_id", fnanceUserId);
        //担保公司不会看到保存状态的数据
        wrapper.ne("status",InsuranceStatusEnum.SAVE);
        warpperQuery(wrapper,loanFinanceApply);
        IPage<LoanFinanceApply> loanFinanceApplyIPage = loanFinanceApplyMapper.applyList(page, wrapper);
        result.setSuccessResult(loanFinanceApplyIPage);
        return result;
    }

    @GetMapping("/loan/queryWorker")
    @ApiOperation(value = "根据贷款申请ID查询贷款申请情况", notes = "根据贷款申请ID查询贷款申请情况")
    public Result queryBankApplyList(@RequestParam Integer applyId){
        Result result = new Result();
        result.setSuccessResult(loanBatchInfoMapper.queryFarmItemsWithOrder(applyId));
        return result;
    }


    private void warpperQuery(QueryWrapper<LoanFinanceApply> queryWrapper,LoanFinanceApply loanFinanceApply ){

        LoanApplyTypeEnum loadType = loanFinanceApply.getLoadType();
        if(loadType!=null){
            queryWrapper.eq("loadType",loadType.getValue().intValue());
        }
        LoanApplyStatusEnum loanFinanceApplyStatus = loanFinanceApply.getStatus();
        if(loanFinanceApplyStatus!=null){
            queryWrapper.eq("status",loanFinanceApplyStatus.getValue().intValue());
        }

        queryWrapper.orderByDesc("id");

    }

    @PostMapping("/loan/saveOrUpdate")
    @ApiOperation(value = "添加或修改贷款申请单",notes = "添加或修改贷款申请单")
    public Result saveOrUpdate(@RequestBody  LoanFinanceApply loanFinanceApply){
        Result result = new Result<>();
        String message = "";
        boolean save = true;

        try {
            Integer id = loanFinanceApply.getId();
            loanFinanceApplyService.saveOrUpdateLoanApply(loanFinanceApply);
            if(id==null){
                id = loanFinanceApply.getId();

                orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.BANK_LOAN, MessageStatusEnum.LOAN_SAVE, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            save = false;
            message = e.getMessage();
        }

        result.setSuccess(save);
        result.setMessage(message);
        return result;
    }

    @GetMapping("/loan/delete")
    @ApiOperation(value = "删除贷款申请",notes = "删除贷款申请")
    public Result deleteApply(@RequestParam Integer id){
        Result result = new Result<>();
        boolean delete = false;

        String message = "";
        try {
            LoanFinanceApply apply = loanFinanceApplyService.getById(id);
            if(apply==null){
                message = "贷款申请不存在";

            }else{
                LoanApplyStatusEnum status = apply.getStatus();
                //状态为保存，拒绝，或取消，可删除订单
                if(status == LoanApplyStatusEnum.SAVE
                        || status == LoanApplyStatusEnum.CANCEL
                        || status == LoanApplyStatusEnum.FAIL_APPLY){
                    //级联删除
                    delete = loanFinanceApplyService.removeById(id);
                } else{
                    message = "贷款申请状态不为保存、拒绝或取消状态，不允许删除";
                }
            }

        } catch (Exception e) {
            delete = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }

        if(delete){
            result.setMessage("删除贷款申请单信息成功");
        }else{
            if(message.equals("")){
                message = "删除贷款申请单信息失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(delete);
        return result;
    }

//    @GetMapping("/loan/ExecuteDetail")
//    @ApiOperation(value = "传入贷款申请的ID，查询对应的贷款细项的执行情况",notes = "传入贷款申请的ID，查询对应的贷款细项的执行情况")
//    public Result ExecuteDetail(@RequestParam Integer applyId){
//        Result result = new Result<>();
//        boolean query = false;
//
//        String message = "";
//        try {
//            QueryWrapper queryWrapper = new QueryWrapper();
//            queryWrapper.eq("id",applyId);
//            queryWrapper.eq("Load_type",LoanApplyTypeEnum.PLANT.getValue().intValue());
//            LoanFinanceApply apply = loanFinanceApplyService.getOne(queryWrapper);
//            LoanApplyTypeEnum loadType = apply.getLoadType();
//            LoanBatchInfo loanBatchInfo = apply.getLoanBatchInfo();
//            if(apply==null){
//                message = "贷款申请不存在";
//
//            }else{
//                LoanApplyStatusEnum status = apply.getStatus();
//                //状态为保存，拒绝，或取消，可删除订单
//                if(status == LoanApplyStatusEnum.SAVE
//                        || status == LoanApplyStatusEnum.CANCEL
//                        || status == LoanApplyStatusEnum.FAIL_APPLY){
//                    //级联删除
//                    delete = loanFinanceApplyService.removeById(id);
//                } else{
//                    message = "贷款申请状态不为保存、拒绝或取消状态，不允许删除";
//                }
//            }
//
//        } catch (Exception e) {
//            query = false;
//            result.setMessage(e.getMessage());
//            e.printStackTrace();
//        }
//
//        if(query){
//            result.setMessage("删除贷款申请单信息成功");
//        }else{
//            if(message.equals("")){
//                message = "删除贷款申请单信息失败";
//            }
//            result.setMessage(message);
//        }
//        result.setSuccess(query);
//        return result;
//    }

    @GetMapping("/loan/apply")
    @ApiOperation(value = "贷款申请发起申请",notes = "贷款申请发起申请")
    public Result applyLoan(@RequestParam Integer id){
        Result result = new Result<>();
        boolean deal = false;

        String message = "";
        try {
            LoanFinanceApply apply = loanFinanceApplyService.getById(id);
            if(apply==null){
                message = "该贷款申请不存在";

            }else{
                LoanApplyStatusEnum status = apply.getStatus();
                //保存或退回状态可以发起申请
                if(status==LoanApplyStatusEnum.SAVE
                        || status == LoanApplyStatusEnum.FAIL_APPLY
                        || status == LoanApplyStatusEnum.CANCEL){


                    //如果有担保，走担保，没担保，走银行
                    if(apply.getIfguarantee().equals(CommonTrueFalseEnum.TRUE)){
                        apply.setStatus(LoanApplyStatusEnum.WARRANT_APPLY);
                    }else{
                        apply.setStatus(LoanApplyStatusEnum.LOAN_APPLY);
                    }

                    deal = loanFinanceApplyService.saveOrUpdate(apply);

                    MessageStatusEnum messageNextStatu = MessageStatusEnum.LOAN_APPLY_SEND;
                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.BANK_LOAN, messageNextStatu, null);

                } else{
                    message = "贷款申请状态不为保存、拒绝或取消状态，不允许发起申请";
                }
            }

        } catch (Exception e) {
            deal = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(deal){
            result.setMessage("贷款申请发起申请成功");
        }else{
            if(message.equals("")){
                message = "贷款申请发起申请失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(deal);
        return result;
    }

    @GetMapping("/loan/warrantApplyAgree")
    @ApiOperation(value = "担保方同意该贷款的担保申请",notes = "担保方同意该贷款的担保申请")
    public Result warrantApplyAgree(@RequestParam Integer id,@RequestParam String dealMessage){
        Result result = new Result<>();
        boolean deal = false;
        String message = "";
        try {
            LoanFinanceApply apply = loanFinanceApplyService.getById(id);
            if(apply==null){
                message = "该贷款申请不存在";
            }else{
                LoanApplyStatusEnum status = apply.getStatus();
                //保存或退回状态可以发起申请
                if(status==LoanApplyStatusEnum.WARRANT_APPLY){

                    //担保之后走贷款申请
                    apply.setStatus(LoanApplyStatusEnum.LOAN_APPLY);
                    deal = loanFinanceApplyService.saveOrUpdate(apply);

                    MessageStatusEnum messageNextStatu = MessageStatusEnum.LOAN_WARRANT_APPLY;
                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.BANK_LOAN, messageNextStatu, dealMessage);
                } else{
                    message = "贷款申请状态不为拟担保申请状态，不允许完成拟担保申请";
                }
            }

        } catch (Exception e) {
            deal = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(deal){
            result.setMessage("贷款拟担保申请成功");
        }else{
            if(message.equals("")){
                message = "贷款拟担保申请失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(deal);
        return result;
    }

    @GetMapping("/loan/loanApplyAgree")
    @ApiOperation(value = "银行审核贷款申请",notes = "银行审核贷款申请")
    public Result loanApplyAgree(@RequestParam Integer id,@RequestParam String dealMessage){
        Result result = new Result<>();
        boolean deal = false;
        String message = "";
        try {
            LoanFinanceApply apply = loanFinanceApplyService.getById(id);
            if(apply==null){
                message = "该贷款申请不存在";
            }else{
                LoanApplyStatusEnum status = apply.getStatus();
                //保存或退回状态可以发起申请
                if(status==LoanApplyStatusEnum.LOAN_APPLY){

                    //银行审批之后，有担保走担保，没有走银行审批
                    if(apply.getIfguarantee().equals(CommonTrueFalseEnum.TRUE)){
                        apply.setStatus(LoanApplyStatusEnum.WARRANT_APPROVE);
                    }else{
                        apply.setStatus(LoanApplyStatusEnum.LOAN_APPROVE);
                    }
                    deal = loanFinanceApplyService.saveOrUpdate(apply);

                    MessageStatusEnum messageNextStatu = MessageStatusEnum.LOAN_APPLY;
                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.BANK_LOAN, messageNextStatu, dealMessage);
                } else{
                    message = "贷款申请状态不为贷款审批状态，不允许处理贷款审批";
                }
            }

        } catch (Exception e) {
            deal = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(deal){
            result.setMessage("贷款审核成功");
        }else{
            if(message.equals("")){
                message = "贷款审核失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(deal);
        return result;
    }

    @GetMapping("/loan/WarrantApproveAgree")
    @ApiOperation(value = "贷款申请的担保审批",notes = "贷款申请的担保审批")
    public Result WarrantApproveAgree(@RequestParam Integer id,@RequestParam String dealMessage){
        Result result = new Result<>();
        boolean deal = false;
        String message = "";
        try {
            LoanFinanceApply apply = loanFinanceApplyService.getById(id);
            if(apply==null){
                message = "该贷款申请不存在";
            }else{
                LoanApplyStatusEnum status = apply.getStatus();
                //保存或退回状态可以发起申请
                if(status==LoanApplyStatusEnum.WARRANT_APPROVE){
                    //担保审批之后，走银行
                    apply.setStatus(LoanApplyStatusEnum.LOAN_APPROVE);
                    deal = loanFinanceApplyService.saveOrUpdate(apply);

                    MessageStatusEnum messageNextStatu = MessageStatusEnum.LOAN_WARRANT_APPROVE;
                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.BANK_LOAN, messageNextStatu, dealMessage);
                } else{
                    message = "贷款申请状态不为贷款担保审批状态，不允许处理贷款担保审批";
                }
            }

        } catch (Exception e) {
            deal = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(deal){
            result.setMessage("贷款担保审批成功");
        }else{
            if(message.equals("")){
                message = "贷款担保审批失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(deal);
        return result;
    }

    @GetMapping("/loan/loanApproveAgree")
    @ApiOperation(value = "贷款申请的银行审批",notes = "贷款申请的银行审批")
    public Result loanApproveAgree(@RequestParam Integer id,@RequestParam String dealMessage){
        Result result = new Result<>();
        boolean deal = false;
        String message = "";
        try {
            LoanFinanceApply apply = loanFinanceApplyService.getById(id);
            if(apply==null){
                message = "该贷款申请不存在";
            }else{
                LoanApplyStatusEnum status = apply.getStatus();
                if(status==LoanApplyStatusEnum.LOAN_APPROVE){
                    //担保审批之后，走银行
                    apply.setStatus(LoanApplyStatusEnum.FINISH);
                    deal = loanFinanceApplyService.saveOrUpdate(apply);

                    MessageStatusEnum messageNextStatu = MessageStatusEnum.LOAN_FINISH;
                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.BANK_LOAN, messageNextStatu, dealMessage);
                } else{
                    message = "贷款申请状态不为贷款审批状态，不允许处理贷款审批";
                }
            }
        } catch (Exception e) {
            deal = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(deal){
            result.setMessage("贷款审批成功");
        }else{
            if(message.equals("")){
                message = "贷款审批失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(deal);
        return result;
    }

    @GetMapping("/loan/loanreject")
    @ApiOperation(value = "贷款申请的银行审批",notes = "贷款申请的银行审批")
    public Result loanApproveAgree(@RequestParam Integer id,@RequestParam String dealMessage,@RequestParam Integer type){
        Result result = new Result<>();
        boolean deal = false;
        String message = "";
        try {
            LoanFinanceApply apply = loanFinanceApplyService.getById(id);
            if(apply==null){
                message = "该贷款申请不存在";
            }else{
                LoanApplyStatusEnum status = apply.getStatus();
                if(status != LoanApplyStatusEnum.SAVE
                        && status != LoanApplyStatusEnum.FINISH
                        && status != LoanApplyStatusEnum.CANCEL
                        && status != LoanApplyStatusEnum.FAIL_APPLY
                ){
                    //审批不通过，走类型
                    apply.setStatus(LoanApplyStatusEnum.FAIL_APPLY);
                    deal = loanFinanceApplyService.saveOrUpdate(apply);

                    MessageStatusEnum messageNextStatu = null;
                    if(type.equals(1)){
                        messageNextStatu = MessageStatusEnum.LOAN_WARRANT_APPLY_FAIL;
                    }else if(type.equals(2)){
                        messageNextStatu = MessageStatusEnum.LOAN_APPLY_FAIL;
                    }else if(type.equals(3)){
                        messageNextStatu = MessageStatusEnum.LOAN_WARRANT_APPROVE_FAIL;
                    }else if(type.equals(4)){
                        messageNextStatu = MessageStatusEnum.LOAN_APPROVE_FAIL;
                    }

                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.BANK_LOAN, messageNextStatu, dealMessage);
                } else{
                    message = "贷款申请状态不为贷款审批状态，不允许处理贷款审批";
                }
            }
        } catch (Exception e) {
            deal = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(deal){
            result.setMessage("贷款审批成功");
        }else{
            if(message.equals("")){
                message = "贷款审批失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(deal);
        return result;
    }

    @GetMapping("/loan/loanCancel")
    @ApiOperation(value = "取消贷款申请",notes = "取消贷款申请")
    public Result loanCancel(@RequestParam Integer id,@RequestParam(defaultValue = "") String dealMessage){
        Result result = new Result<>();
        boolean deal = false;
        String message = "";
        try {
            LoanFinanceApply apply = loanFinanceApplyService.getById(id);
            if(apply==null){
                message = "该贷款申请不存在";
            }else{
                LoanApplyStatusEnum status = apply.getStatus();
                if(status != LoanApplyStatusEnum.LOAN_GRANT
                        && status != LoanApplyStatusEnum.FINISH
                ){
                    //审批不通过，走类型
                    apply.setStatus(LoanApplyStatusEnum.CANCEL);
                    deal = loanFinanceApplyService.saveOrUpdate(apply);

                    MessageStatusEnum messageNextStatu = MessageStatusEnum.LOAN_CANCEL;

                    orderMessageService.insertRelateMessage(id, MessageRelateTypeEnum.BANK_LOAN, messageNextStatu, dealMessage);
                } else{
                    message = "贷款申请已处于放贷或完成状态，不允许取消";
                }
            }
        } catch (Exception e) {
            deal = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }
        if(deal){
            result.setMessage("贷款申请取消成功");
        }else{
            if(message.equals("")){
                message = "贷款申请取消失败";
            }
            result.setMessage(message);
        }
        result.setSuccess(deal);
        return result;
    }




}
