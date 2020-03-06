package com.nongxin.terminal.controller.scfinance.system;

import com.nongxin.terminal.util.enumUtil.scfinance.*;
import com.nongxin.terminal.vo.EnumVo;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/finance/enum/")
public class FinanceEnumController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceEnumController.class);

    //工单
    @GetMapping("/getCompanyTypeEnum")
    @ApiOperation("获取公司类型枚举")
    public Result getWorkOrderTypeEnum(){
        Result result = new Result();
        List listEnum = new ArrayList();
        for(CompanyTypeEnum c:CompanyTypeEnum.values()){
            EnumVo enumVo = new EnumVo(c.getValue(),c.getCode(),c.getDisplayName());
            listEnum.add(enumVo);
        }
        result.setSuccessResult(listEnum);
        return result;
    }

    @GetMapping("/getFinanceUserTypeEnum")
    @ApiOperation("获取金融用户类型枚举")
    public Result getFinanceUserTypeEnum(){
        Result result = new Result();
        result.setSuccessResult(FinanceUserTypeEnum.values());
        return result;
    }

    @GetMapping("/getInsuranceTypeEnum")
    @ApiOperation("获取保险类型枚举")
    public Result getInsuranceTypeEnum(){
        Result result = new Result();
        result.setSuccessResult(InsuranceTypeEnum.values());
        return result;
    }
    @GetMapping("/getInsuranceStatusEnum")
    @ApiOperation("获取保险状态枚举")
    public Result getInsuranceStatusEnum(){
        Result result = new Result();
        result.setSuccessResult(InsuranceStatusEnum.values());
        return result;
    }

    @GetMapping("/getLoanApplyTypeEnum")
    @ApiOperation("获取贷款类型枚举")
    public Result getLoanApplyTypeEnum(){
        Result result = new Result();
        result.setSuccessResult(LoanApplyTypeEnum.values());
        return result;
    }

    @GetMapping("/getLoanApplyStatusEnum")
    @ApiOperation("获取贷款类型枚举")
    public Result getLoanApplyStatusEnum(){
        Result result = new Result();
        result.setSuccessResult(LoanApplyStatusEnum.values());
        return result;
    }

    @GetMapping("/getDetectionTypeEnum")
    @ApiOperation("获取检测类型枚举")
    public Result getDetectionTypeEnum(){
        Result result = new Result();
        result.setSuccessResult(DetectionTypeEnum.values());
        return result;
    }

    @GetMapping("/getDetectionStatusEnum")
    @ApiOperation("获取检测状态枚举")
    public Result getDetectionStatusEnum(@RequestParam(defaultValue = "1")Integer userType,@RequestParam(defaultValue = "1") Integer period){
        Result result = new Result();
        List<DetectionStatusEnum> detectAll = new ArrayList<>();
        List<DetectionStatusEnum> detectApply = new ArrayList<>();
        detectAll.add(DetectionStatusEnum.SAVE);
        detectApply.add(DetectionStatusEnum.SAVE);
        detectApply.add(DetectionStatusEnum.CANCEL);
        detectApply.add(DetectionStatusEnum.FAIL_APPLY);
        DetectionStatusEnum[] values = DetectionStatusEnum.values();
        List<DetectionStatusEnum> detectionStatusEnums = new ArrayList<>(Arrays.asList(values));
        if(userType.equals(2)){
            //非保存的枚举
            detectionStatusEnums.removeAll(detectAll);
        }else if(userType.equals(3)){
            //申请的枚举
            detectionStatusEnums = detectApply;
        }else if(userType.equals(4)){
            //进行中的枚举
            detectionStatusEnums.removeAll(detectApply);
            detectionStatusEnums.remove(DetectionStatusEnum.FINISH);
        }
        result.setSuccessResult(detectionStatusEnums);
        return result;
    }

    @GetMapping("/getLoanApplyStatusEnumToBank")
    @ApiOperation("获取贷款类型枚举")
    public Result getLoanApplyStatusEnumToBank(){
        Result result = new Result();
        List listEnum = new ArrayList();
        List<LoanApplyStatusEnum>  excepts = new ArrayList<>();
        excepts.add(LoanApplyStatusEnum.SAVE);
        excepts.add(LoanApplyStatusEnum.CANCEL);

        for(LoanApplyStatusEnum c:LoanApplyStatusEnum.values()){
            if(!excepts.contains(c)){
                EnumVo enumVo = new EnumVo(c.getValue(),c.getCode(),c.getDisplayName());
                listEnum.add(enumVo);
            }
        }
        result.setSuccessResult(listEnum);
        return result;
    }

    @GetMapping("/getInsStatusEnumToIns")
    @ApiOperation("获取保险状态枚举")
    public Result getInsStatusEnumToIns(){
        Result result = new Result();
        List listEnum = new ArrayList();
        List<InsuranceStatusEnum>  excepts = new ArrayList<>();
        excepts.add(InsuranceStatusEnum.SAVE);
        excepts.add(InsuranceStatusEnum.CANCEL);

        for(InsuranceStatusEnum c:InsuranceStatusEnum.values()){
            if(!excepts.contains(c)){
                EnumVo enumVo = new EnumVo(c.getValue(),c.getCode(),c.getDisplayName());
                listEnum.add(enumVo);
            }
        }
        result.setSuccessResult(listEnum);
        return result;
    }

}
