package com.nongxin.terminal.controller.scfinance.detection;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nongxin.terminal.dao.scfinance.detection.CompanyRegistInfoMapper;
import com.nongxin.terminal.entity.address.Address;
import com.nongxin.terminal.entity.scfinance.detection.CompanyRegistInfo;
import com.nongxin.terminal.service.scfinance.CommonService;
import com.nongxin.terminal.service.scfinance.detection.ICompanyRegistInfoService;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.common.AddressRelateTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
public class CompanyRegistInfoController {

    @Autowired
    private ICompanyRegistInfoService registInfoService;


    @Autowired
    private CommonService commonService;

    @Autowired
    private CompanyRegistInfoMapper registInfoMapper;

    @PostMapping("/registInfo/saveorupdate")
    @ApiOperation(value="修改公司注册信息", notes = "POST修改公司信息")
    public Result saveOrUpdate(@Validated @RequestBody CompanyRegistInfo registInfo){
        Result result = new Result<>();
        Integer financeUserId = JwtUtil.queryFnanceUserId();
        QueryWrapper queryWrapper = new QueryWrapper();

        queryWrapper.eq("finance_user_id",financeUserId);
        CompanyRegistInfo one = registInfoService.getOne(queryWrapper);

        Boolean existByIdDifferent = one!=null && registInfo.getId()!=null && registInfo.getId()!=one.getId();
        Boolean ExistByAdd = one!=null && registInfo.getId()==null;

        if(existByIdDifferent || ExistByAdd){
            result.setSuccess(false);
            result.setMessage("该企业已存在法人信息，不允许新增");
            return result;
        }
        //LOGGER.info("financeUserId:"+financeUserId);
        if(registInfo.getId()==null){
            registInfo.setCreateTime(new Date());
            registInfo.setTenantId(financeUserId);
            registInfo.setFinanceUserId(financeUserId);
        }
        //LOGGER.info("legalPerson:"+legalPerson);
        boolean isUpdateSuccess = registInfoService.saveOrUpdate(registInfo);
        Address registAddress = registInfo.getRegistAddress();
        Address businessAddress = registInfo.getBusinessAddress();
        commonService.saveOrUpdateAddress(registAddress,registInfo.getId(), AddressRelateTypeEnum.REGIST_ADDRESS);
        commonService.saveOrUpdateAddress(businessAddress,registInfo.getId(), AddressRelateTypeEnum.COMPANY_BUSINESS_ADDRESS);


        if(isUpdateSuccess){
            result.setMessage("修改公司信息成功");
        }else{
            result.setMessage("修改公司信息失败");
        }
        result.setSuccess(isUpdateSuccess);
        return result;

    }


    @GetMapping("/registInfo/query")
    @ApiOperation(value="查询公司注册信息", notes = "get查询公司信息")
    public Result queryLegalPerson(){
        Result result = new Result<>();
        QueryWrapper queryWrapper = new QueryWrapper();
        Integer financeUserId = JwtUtil.queryFnanceUserId();
        queryWrapper.eq("finance_user_id",financeUserId);
        CompanyRegistInfo one = registInfoMapper.queryRegistInfo(queryWrapper);
        result.setSuccessResult(Optional.ofNullable(one).orElse(new CompanyRegistInfo()));
        return result;

    }
}
