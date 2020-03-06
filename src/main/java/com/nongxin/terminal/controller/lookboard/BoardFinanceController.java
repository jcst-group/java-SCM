package com.nongxin.terminal.controller.lookboard;

import com.nongxin.terminal.service.finance.*;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board/finance")
public class BoardFinanceController {

    @Autowired
    private BasePurchaseService basePurchaseService;
    @Autowired
    private StandardPlanService standardPlanService;
    @Autowired
    private PledgeGoodsService pledgeGoodsService;
    @Autowired
    private FertilizerPurchaseService fertilizerPurchaseService;
    @Autowired
    private LaborDispatchService laborDispatchService;
    @Autowired
    private InsuranceContractService insuranceContractService;
    @Autowired
    private OrderContractService orderContractService;
    @Autowired
    private LoanContractService loanContractService;

    @GetMapping("/basePurchase")
    @ApiOperation(value = "基地订单数据",notes = "看板金融板块")
    public Result basePurchase(Integer baseId){
        Result result = new Result();
        result.setSuccessResult(basePurchaseService.boardBasePurchase(baseId));
        return result;
    }

    @GetMapping("/getBoardStandardPlan")
    @ApiOperation(value = "种植规范化协议数据",notes = "看板金融板块")
    public Result getBoardStandardPlan(Integer baseId){
        Result result = new Result();
        result.setSuccessResult(standardPlanService.getBoardStandardPlan(baseId));
        return result;
    }

    @GetMapping("/getBoardPledgeGoods")
    @ApiOperation(value = "质押物权数据",notes = "看板金融板块")
    public Result getBoardPledgeGoods(Integer baseId){
        Result result = new Result();
        result.setSuccessResult(pledgeGoodsService.getBoardPledgeGoods(baseId));
        return result;
    }

    @GetMapping("/getBoardFertilizerPurchase")
    @ApiOperation(value = "物资采购数据",notes = "看板金融板块")
    public Result getBoardFertilizerPurchase(){
        Result result = new Result();
        result.setSuccessResult(fertilizerPurchaseService.getBoardFertilizerPurchase());
        return result;
    }

    @GetMapping("/getBoardLaborDispatch")
    @ApiOperation(value = "劳务派遣数据",notes = "看板金融板块")
    public Result getBoardLaborDispatch(){
        Result result = new Result();
        result.setSuccessResult(laborDispatchService.getBoardLaborDispatch());
        return result;
    }

    @GetMapping("/getBoardInsuranceContract")
    @ApiOperation(value = "保险数据",notes = "看板金融板块")
    public Result getBoardInsuranceContract(Integer baseId){
        Result result = new Result();
        result.setSuccessResult(insuranceContractService.getBoardInsuranceContract(baseId));
        return result;
    }

    @GetMapping("/getBoardOrderContract")
    @ApiOperation(value = "订单采购数据",notes = "看板金融板块")
    public Result getBoardOrderContract(){
        Result result = new Result();
        result.setSuccessResult(orderContractService.getBoardOrderContract());
        return result;
    }

    @GetMapping("/getBoardLoanContract")
    @ApiOperation(value = "贷款数据",notes = "看板金融板块")
    public Result getBoardLoanContract(){
        Result result = new Result();
        result.setSuccessResult(loanContractService.getBoardLoanContract());
        return result;
    }

}
