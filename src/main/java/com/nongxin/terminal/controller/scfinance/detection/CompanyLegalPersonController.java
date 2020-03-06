package com.nongxin.terminal.controller.scfinance.detection;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nongxin.terminal.dao.scfinance.detection.CompanyLegalPersonMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.scfinance.detection.CompanyLegalPerson;
import com.nongxin.terminal.service.scfinance.CommonService;
import com.nongxin.terminal.service.scfinance.detection.ICompanyLegalPersonService;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
public class CompanyLegalPersonController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyLegalPersonController.class);

    @Autowired
    private CompanyLegalPersonMapper legalPersonMapper;

    @Autowired
    private ICompanyLegalPersonService legalPersonService;

    @Autowired
    private CommonService commonService;

    @PostMapping("/legalPerson/saveorupdate")
    @ApiOperation(value="修改公司信息", notes = "POST修改公司信息")
    public Result saveOrUpdate(@Validated @RequestBody CompanyLegalPerson legalPerson){
        Result result = new Result<>();
        Integer financeUserId = JwtUtil.queryFnanceUserId();
        QueryWrapper queryWrapper = new QueryWrapper();

        queryWrapper.eq("finance_user_id",financeUserId);
        CompanyLegalPerson one = legalPersonService.getOne(queryWrapper);
        if(one!=null && legalPerson.getId()!=null && legalPerson.getId()!=one.getId()){
            result.setSuccess(false);
            result.setMessage("该企业已存在法人信息，不允许新增");
            return result;
        }
        //LOGGER.info("financeUserId:"+financeUserId);
        if(legalPerson.getId()==null){
            legalPerson.setCreateTime(new Date());
            legalPerson.setTenantId(financeUserId);
            legalPerson.setFinanceUserId(financeUserId);
        }
        LOGGER.info("legalPerson:"+legalPerson);
        boolean isUpdateSuccess = legalPersonService.saveOrUpdate(legalPerson);
        List<PictureInfo> pictureInfos = legalPerson.getPictureInfos();

        commonService.savePictures(pictureInfos,legalPerson.getId(), ImgRelationTypeEnum.LEGAL_PERSON);
        if(isUpdateSuccess){
            result.setMessage("修改法人信息成功");
        }else{
            result.setMessage("修改法人信息失败");
        }
        result.setSuccess(isUpdateSuccess);
        return result;

    }


    @GetMapping("/legalPerson/query")
    @ApiOperation(value="查询公司基本信息", notes = "get查询公司信息")
    public Result queryLegalPerson(){
        Result result = new Result<>();
        QueryWrapper queryWrapper = new QueryWrapper();
        Integer financeUserId = JwtUtil.queryFnanceUserId();
        queryWrapper.eq("finance_user_id",financeUserId);
        CompanyLegalPerson one = legalPersonMapper.queryLegalPerson(queryWrapper);
        result.setSuccessResult(Optional.ofNullable(one).orElse(new CompanyLegalPerson()));
        return result;

    }

}
