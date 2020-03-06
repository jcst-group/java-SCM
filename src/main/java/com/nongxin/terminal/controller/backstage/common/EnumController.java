package com.nongxin.terminal.controller.backstage.common;

import com.nongxin.terminal.util.enumUtil.test.DetectionCategoryEnum;
import com.nongxin.terminal.util.enumUtil.test.DetectionStageEnum;
import com.nongxin.terminal.service.common.UnitService;
import com.nongxin.terminal.util.enumUtil.base.BaseTypeEnum;
import com.nongxin.terminal.util.enumUtil.base.CategoryEnum;
import com.nongxin.terminal.util.enumUtil.base.EnvStandardsEnum;
import com.nongxin.terminal.util.enumUtil.base.SoilTypeEnum;
import com.nongxin.terminal.util.enumUtil.common.UnitEnum;
import com.nongxin.terminal.util.enumUtil.crop.HarvestedTypeEnum;
import com.nongxin.terminal.util.enumUtil.finance.LoanTypeEnum;
import com.nongxin.terminal.util.enumUtil.illness.IllFeedbackStatusEnum;
import com.nongxin.terminal.util.enumUtil.plan.FarmingLocationEnum;
import com.nongxin.terminal.util.enumUtil.plan.HouEnum;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderStatusEnum;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderTypeEnum;
import com.nongxin.terminal.util.enumUtil.retrospective.RetroCodingTypeEnum;
import com.nongxin.terminal.util.enumUtil.retrospective.RetroUnitEnum;
import com.nongxin.terminal.util.enumUtil.seed.SeedTypeEnum;
import com.nongxin.terminal.util.enumUtil.seed.SelfSpeciesEnum;
import com.nongxin.terminal.util.enumUtil.system.RoleTypeEnum;
import com.nongxin.terminal.util.enumUtil.system.UserSexEnum;
import com.nongxin.terminal.util.enumUtil.solar.SolarTermsEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/enum")
public class EnumController {

    @Autowired
    private UnitService unitService;

    //权限
    @GetMapping("/getRoleTypeEnum")
    @ApiOperation("获取除管理员外其他角色类型枚举")
    public Result getRoleTypeEnum(){
        Result result = new Result();
        List<RoleTypeEnum> typeEnumList = new ArrayList<>(Arrays.asList(RoleTypeEnum.values()));
        typeEnumList.remove(RoleTypeEnum.ADMIN);
        result.setSuccessResult(typeEnumList);
        return result;
    }

    @GetMapping("/getAllRoleTypeEnum")
    @ApiOperation("获取所有角色类型枚举")
    public Result getAllRoleTypeEnum(){
        Result result = new Result();
        result.setSuccessResult(RoleTypeEnum.values());
        return result;
    }

    //用户
    @GetMapping("/getUserSexEnum")
    @ApiOperation("获取用户性别枚举")
    public Result getUserSexEnum(){
        Result result = new Result();
        result.setSuccessResult(UserSexEnum.values());
        return result;
    }

    //基地
    @GetMapping("/getCategoryEnum")
    @ApiOperation("获取基地范畴枚举")
    public Result getCategoryEnum(){
        Result result = new Result();
        result.setSuccessResult(CategoryEnum.values());
        return result;
    }

    @GetMapping("/getBaseTypeEnum")
    @ApiOperation("获取基地类型枚举")
    public Result getBaseTypeEnum(){
        Result result = new Result();
        result.setSuccessResult(BaseTypeEnum.values());
        return result;
    }

    @GetMapping("/getSoilTypeEnum")
    @ApiOperation("获取基地土壤类型枚举")
    public Result getSoilTypeEnum(){
        Result result = new Result();
        result.setSuccessResult(SoilTypeEnum.values());
        return result;
    }

    @GetMapping("/getEnvStandardsEnum")
    @ApiOperation("获取基地环境标准枚举")
    public Result getEnvStandardsEnum(){
        Result result = new Result();
        result.setSuccessResult(EnvStandardsEnum.values());
        return result;
    }

    //种子
    @GetMapping("/getSeedTypeEnum")
    @ApiOperation("获取种子类型枚举")
    public Result getSeedTypeEnum(){
        Result result = new Result();
        result.setSuccessResult(SeedTypeEnum.values());
        return result;
    }

    @GetMapping("/getSelfSpeciesEnum")
    @ApiOperation("获取是否自种枚举")
    public Result getSelfSpeciesEnum(){
        Result result = new Result();
        result.setSuccessResult(SelfSpeciesEnum.values());
        return result;
    }

    //检测标准
    @GetMapping("/getDetectionCategoryEnum")
    @ApiOperation("获取检测项目类别枚举")
    public Result getDetectionCategoryEnum(){
        Result result = new Result();
        result.setSuccessResult(DetectionCategoryEnum.values());
        return result;
    }

    @GetMapping("/getDetectionStageEnum")
    @ApiOperation("获取检测项目阶段枚举")
    public Result getDetectionStageEnum(){
        Result result = new Result();
        result.setSuccessResult(DetectionStageEnum.values());
        return result;
    }

    @GetMapping("/getDetectionUnitEnum")
    @ApiOperation("获取检测单位枚举")
    public Result getDetectionUnitEnum(String displayName){
        Result result = new Result();
        result.setSuccessResult(unitService.getUnit(displayName));
        return result;
    }

    //节气
    @GetMapping("/getSolarTermsEnum")
    @ApiOperation("获取24节气枚举")
    public Result getSolarTermsEnum(){
        Result result = new Result();
        result.setSuccessResult(SolarTermsEnum.values());
        return result;
    }

    @GetMapping("/getHouEnum")
    @ApiOperation("获取侯期枚举")
    public Result getHouEnum(){
        Result result = new Result();
        result.setSuccessResult(HouEnum.values());
        return result;
    }

    @GetMapping("/getLocationEnum")
    @ApiOperation("获取定位枚举")
    public Result getLocationEnum(){
        Result result = new Result();
        result.setSuccessResult(FarmingLocationEnum.values());
        return result;
    }

    //工单
    @GetMapping("/getWorkOrderTypeEnum")
    @ApiOperation("获取工单类型枚举")
    public Result getWorkOrderTypeEnum(){
        Result result = new Result();
        result.setSuccessResult(WorkOrderTypeEnum.values());
        return result;
    }

    @GetMapping("/getWorkOrderStatusEnum")
    @ApiOperation("获取工单状态枚举")
    public Result getWorkOrderStatusEnum(){
        Result result = new Result();
        result.setSuccessResult(WorkOrderStatusEnum.values());
        return result;
    }

    @GetMapping("/getHarvestedTypeEnum")
    @ApiOperation("获取采收品类型枚举")
    public Result getHarvestedTypeEnum(){
        Result result = new Result();
        result.setSuccessResult(HarvestedTypeEnum.values());
        return result;
    }

    //追溯码
    @GetMapping("/getRetroCodingTypeEnum")
    @ApiOperation("获取追溯码类型枚举")
    public Result getRetroCodingTypeEnum(){
        Result result = new Result();
        result.setSuccessResult(RetroCodingTypeEnum.values());
        return result;
    }

    @GetMapping("/getRetroCodingUnitEnum")
    @ApiOperation("获取追溯码单位枚举")
    public Result getRetroCodingUnitEnum(){
        Result result = new Result();
        result.setSuccessResult(RetroUnitEnum.values());
        return result;
    }

    @GetMapping("/getUnitEnum")
    @ApiOperation("获取单位枚举")
    public Result getUnitEnum(){
        Result result = new Result();
        result.setSuccessResult(UnitEnum.values());
        return result;
    }

    @GetMapping("/getIllFeedbackStatusEnum")
    @ApiOperation("获取病虫害反馈状态")
    public Result getIllFeedbackStatusEnum(){
        Result result = new Result();
        result.setSuccessResult(IllFeedbackStatusEnum.values());
        return result;
    }

    @GetMapping("/getLoanTypeEnum")
    @ApiOperation("获取贷款类型")
    public Result getLoanTypeEnum(){
        Result result = new Result();
        result.setSuccessResult(LoanTypeEnum.values());
        return result;
    }

}
