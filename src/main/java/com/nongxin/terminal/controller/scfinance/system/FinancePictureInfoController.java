package com.nongxin.terminal.controller.scfinance.system;

import com.nongxin.terminal.service.file.PictureInfoService;
import com.nongxin.terminal.util.ImgUpload;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/finance/pictureInfo")
public class FinancePictureInfoController {
    @Autowired
    private PictureInfoService pictureInfoService;
    @Autowired
    private ImgUpload imgUpload;

    @GetMapping("/delete")
    @ApiOperation("删除图片")
    public Result deletePic(@RequestParam(required = true)Integer id){
        Result result = new Result();
        boolean isSuccess = pictureInfoService.delete(id);
        if (isSuccess){
            result.setMessage("删除图片成功");
        }else {
            result.setMessage("删除图片失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }


    @PostMapping("/addFinanceBusinessPic")
    @ApiOperation("添加金融管理图片")
    public Result addFinanceBusiness(MultipartFile file){
        Integer recordId = JwtUtil.queryFnanceUserId();
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.FINANCE_BUSINESS);
    }

    @PostMapping("/addLegalPersonPic")
    @ApiOperation("添加法人证件图片")
    public Result addLegalPersonPic(MultipartFile file){
        Integer recordId = JwtUtil.queryFnanceUserId();
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.LEGAL_PERSON);
    }

    @PostMapping("/addMemberHeadPic")
    @ApiOperation("添加社员头像图片")
    public Result addMemberHeadPic(MultipartFile file){
        Integer recordId = JwtUtil.queryFnanceUserId();
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.MEMBER_HEAD);
    }


    @PostMapping("/addMemberIDPic")
    @ApiOperation("添加社员身份图片")
    public Result addMemberIDPic(MultipartFile file){
        Integer recordId = JwtUtil.queryFnanceUserId();
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.MEMBER_CREDIT);
    }

    @PostMapping("/addJoinAssocialPic")
    @ApiOperation("添加入社协议图片")
    public Result addJoinAssocialPic(MultipartFile file){
        Integer recordId = JwtUtil.queryFnanceUserId();
        return pictureInfoService.add(file,recordId, ImgRelationTypeEnum.JOIN_SOCIAL);
    }

    @PostMapping("/addInsuranceOrderPic")
    @ApiOperation("添加保单图片")
    public Result addInsuranceOrderPic(MultipartFile file,@RequestParam Integer orderId){
        //Integer recordId = JwtUtil.queryFnanceUserId();
        return pictureInfoService.add(file,orderId, ImgRelationTypeEnum.INSURANCE_ORDER);
    }

    @PostMapping("/addLoanRelatePic")
    @ApiOperation("添加贷款申请相关图片")
    public Result addLoanRelatePic(MultipartFile file,@RequestParam(defaultValue = "-1") Integer applyId){
        //Integer recordId = JwtUtil.queryFnanceUserId();
        return pictureInfoService.add(file,applyId, ImgRelationTypeEnum.LOAN_RELATE_PICTURE);
    }

    @PostMapping("/addWarrantApplyedPic")
    @ApiOperation("添加拟担保审核通过资料")
    public Result addWarrantApplyedPic(MultipartFile file,@RequestParam(name = "orderId") Integer applyId){
        //Integer recordId = JwtUtil.queryFnanceUserId();
        return pictureInfoService.add(file,applyId, ImgRelationTypeEnum.WARRANT_APPLYED_PIC);
    }

    @PostMapping("/addLoanApplyedPic")
    @ApiOperation("添加贷款审核通过资料")
    public Result addLoanApplyedPic(MultipartFile file,@RequestParam(name = "orderId") Integer applyId){
        //Integer recordId = JwtUtil.queryFnanceUserId();
        return pictureInfoService.add(file,applyId, ImgRelationTypeEnum.LOAN_APPLYED_PIC);
    }

    @PostMapping("/addWarrantApprovedPic")
    @ApiOperation("担保审批通过后资料")
    public Result addWarrantApprovedPic(MultipartFile file,@RequestParam(name = "orderId") Integer applyId){
        //Integer recordId = JwtUtil.queryFnanceUserId();
        return pictureInfoService.add(file,applyId, ImgRelationTypeEnum.WARRANT_APPROVED);
    }

    @PostMapping("/addLoanApprovedPic")
    @ApiOperation("贷款审批通过后资料")
    public Result addLoanApprovedPic(MultipartFile file,@RequestParam(name = "orderId") Integer orderId){
        //Integer recordId = JwtUtil.queryFnanceUserId();
        return pictureInfoService.add(file,orderId, ImgRelationTypeEnum.LOAN_APPROVED);
    }


    @PostMapping("/addDetectRelatePic")
    @ApiOperation("贷款审批通过后资料")
    public Result addDetectRelatePic(MultipartFile file,@RequestParam(name = "orderId") Integer orderId){
        //Integer recordId = JwtUtil.queryFnanceUserId();
        return pictureInfoService.add(file,orderId, ImgRelationTypeEnum.DETETCT_APPLY_PIC);
    }

    @PostMapping("/addDetectResultPic")
    @ApiOperation("贷款审批通过后资料")
    public Result addDetectResultPic(MultipartFile file,@RequestParam(name = "orderId") Integer orderId){
        //Integer recordId = JwtUtil.queryFnanceUserId();
        return pictureInfoService.add(file,orderId, ImgRelationTypeEnum.DETETCT_RESULT_PIC);
    }
}
