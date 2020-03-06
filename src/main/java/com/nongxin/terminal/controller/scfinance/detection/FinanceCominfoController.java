package com.nongxin.terminal.controller.scfinance.detection;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nongxin.terminal.dao.scfinance.detection.FinanceCominfoMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.scfinance.detection.FinanceCominfo;
import com.nongxin.terminal.service.scfinance.CommonService;
import com.nongxin.terminal.service.scfinance.detection.impl.FinanceCominfoServiceImpl;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.util.enumUtil.scfinance.FinanceUserTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author clover
 * @since 2019-12-10
 */
@RestController
@RequestMapping("/finance")
public class FinanceCominfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceCominfoController.class);

    @Autowired
    private FinanceCominfoServiceImpl cominfoService;

    @Autowired
    private FinanceCominfoMapper cominfoMapper;

    @Autowired
    private CommonService commonService;

    @PostMapping("/cominfo/saveorupdate")
    @ApiOperation(value="修改公司信息", notes = "POST修改公司信息")
    public Result saveOrUpdateCominfo(@Validated @RequestBody FinanceCominfo cominfo){
        Result result = new Result<>();
        Integer financeUserId = JwtUtil.queryFnanceUserId();



        QueryWrapper queryWrapper = new QueryWrapper();

        LOGGER.info(cominfo.getPictureInfos().toString());

        queryWrapper.eq("finance_user_id",financeUserId);
        FinanceCominfo one = cominfoService.getOne(queryWrapper);
        Boolean existByIdDifferent = one!=null && cominfo.getId()!=null && cominfo.getId()!=one.getId();
        Boolean ExistByAdd = one!=null && cominfo.getId()==null;
        if(existByIdDifferent || ExistByAdd){
            result.setSuccess(false);
            result.setMessage("该企业已存在企业信息，不允许新增");
            return result;
        }
        LOGGER.info("financeUserId:"+financeUserId);
        if(cominfo.getId()==null){
            cominfo.setCreateTime(new Date());
            cominfo.setTenantId(financeUserId);
            cominfo.setFinanceUserId(financeUserId);
        }

        boolean isUpdateSuccess = cominfoService.saveOrUpdate(cominfo);
        List<PictureInfo> pictureInfos = cominfo.getPictureInfos();
        commonService.savePictures(pictureInfos,cominfo.getId(), ImgRelationTypeEnum.FINANCE_BUSINESS);
        if(isUpdateSuccess){
            result.setMessage("修改公司信息成功");
        }else{
            result.setMessage("修改公司信息失败");
        }
        result.setSuccess(isUpdateSuccess);
        return result;

    }


    @GetMapping("/cominfo/query")
    @ApiOperation(value="查询公司基本信息", notes = "get查询公司信息")
    public Result queryCominfo(){
        Result result = new Result<>();
        QueryWrapper queryWrapper = new QueryWrapper();
            Integer financeUserId = JwtUtil.queryFnanceUserId();
        queryWrapper.eq("finance_user_id",financeUserId);
        FinanceCominfo one = cominfoMapper.queryFinanceCominfo(queryWrapper);
        result.setSuccessResult(Optional.ofNullable(one).orElse(new FinanceCominfo()));
        return result;

    }

    @GetMapping("/cominfo/queryCoopCominfos")
    @ApiOperation(value="查询合作社公司基本信息", notes = "get查询公司信息")
    public Result queryCoopCominfos(){
        Result result = new Result<>();
        QueryWrapper queryWrapper = new QueryWrapper();
        Integer financeUserId = JwtUtil.queryFnanceUserId();
        queryWrapper.eq("finance_user_id",financeUserId);
        Integer userType = FinanceUserTypeEnum.COOPERATIVE.getValue().intValue();
        List<FinanceCominfo> cominfos = cominfoMapper.queryCominfosByUserType(userType);
        result.setSuccessResult(Optional.ofNullable(cominfos).orElse(new ArrayList<>()));
        return result;
    }
    @GetMapping("/cominfo/queryDetectCominfos")
    @ApiOperation(value="查询检测公司基本信息", notes = "get查询公司信息")
    public Result queryDetectCominfos(){
        Result result = new Result<>();
        QueryWrapper queryWrapper = new QueryWrapper();
        Integer financeUserId = JwtUtil.queryFnanceUserId();
        queryWrapper.eq("finance_user_id",financeUserId);
        Integer userType = FinanceUserTypeEnum.DETETCTION.getValue().intValue();
        List<FinanceCominfo> cominfos = cominfoMapper.queryCominfosByUserType(userType);
        result.setSuccessResult(Optional.ofNullable(cominfos).orElse(new ArrayList<>()));
        return result;
    }

    @GetMapping("/cominfo/queryInsuranceCominfos")
    @ApiOperation(value="查询保险公司基本信息", notes = "get查询公司信息")
    public Result queryInsuranceCominfos(){
        Result result = new Result<>();
        QueryWrapper queryWrapper = new QueryWrapper();
        Integer financeUserId = JwtUtil.queryFnanceUserId();
        queryWrapper.eq("finance_user_id",financeUserId);
        Integer userType = FinanceUserTypeEnum.INSURANCECOMP.getValue().intValue();
        List<FinanceCominfo> cominfos = cominfoMapper.queryCominfosByUserType(userType);
        result.setSuccessResult(Optional.ofNullable(cominfos).orElse(new ArrayList<>()));
        return result;
    }

    @GetMapping("/cominfo/queryWarrantCominfos")
    @ApiOperation(value="查询担保公司基本信息", notes = "get查询公司信息")
    public Result queryWarrantCominfos(){
        Result result = new Result<>();
        QueryWrapper queryWrapper = new QueryWrapper();
        Integer financeUserId = JwtUtil.queryFnanceUserId();
        queryWrapper.eq("finance_user_id",financeUserId);
        Integer userType = FinanceUserTypeEnum.WARRANT.getValue().intValue();
        List<FinanceCominfo> cominfos = cominfoMapper.queryCominfosByUserType(userType);
        result.setSuccessResult(Optional.ofNullable(cominfos).orElse(new ArrayList<>()));
        return result;
    }

    @GetMapping("/cominfo/queryBankCominfos")
    @ApiOperation(value="查询银行公司基本信息", notes = "get查询公司信息")
    public Result queryBankCominfos(){
        Result result = new Result<>();
        QueryWrapper queryWrapper = new QueryWrapper();
        Integer financeUserId = JwtUtil.queryFnanceUserId();
        queryWrapper.eq("finance_user_id",financeUserId);
        Integer userType = FinanceUserTypeEnum.BANKCOMP.getValue().intValue();
        List<FinanceCominfo> cominfos = cominfoMapper.queryCominfosByUserType(userType);
        result.setSuccessResult(Optional.ofNullable(cominfos).orElse(new ArrayList<>()));
        return result;
    }
    


}
