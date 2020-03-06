package com.nongxin.terminal.controller.scfinance.system;

import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.service.file.FileInfoService;
import com.nongxin.terminal.util.FileUpload;
import com.nongxin.terminal.util.enumUtil.file.FileRelationTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/finance/file")
public class FinanceFileController {

    @Autowired
    private FileUpload fileUpload;

    @Autowired
    private FileInfoService fileInfoService;

    @PostMapping("/uploadInsuranceOrder")
    @ApiOperation("上传保险单资料")
    public Result uploadVideoCompany(@RequestParam("file") MultipartFile file,@RequestParam(name = "orderId",defaultValue = "-1") Integer id){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setStatus((short)1);
        fileInfo.setRelationId(id);
        fileInfo.setRelationType(FileRelationTypeEnum.INSURANCE_ORDER);
        Result result = fileInfoService.insertFile(file,fileInfo);
        return result;
    }


    @PostMapping("/uploadLoanFile")
    @ApiOperation("上传贷款文件")
    public Result uploadLoanFile(@RequestParam("file") MultipartFile file,@RequestParam(name = "orderId",defaultValue = "-1") Integer id){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setStatus((short)1);
        fileInfo.setRelationId(id);
        fileInfo.setRelationType(FileRelationTypeEnum.LOAN_RELATE_FILE);
        Result result = fileInfoService.insertFile(file,fileInfo);
        return result;
    }

    @PostMapping("/uploadLoanWarrantFile")
    @ApiOperation("上传贷款拟担保审核通过资料")
    public Result uploadLoanWarrantFile(@RequestParam("file") MultipartFile file,@RequestParam(name = "orderId",defaultValue = "-1") Integer id){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setStatus((short)1);
        fileInfo.setRelationId(id);
        fileInfo.setRelationType(FileRelationTypeEnum.WARRANT_APPLYED_FILE);
        Result result = fileInfoService.insertFile(file,fileInfo);
        return result;
    }

    @PostMapping("/uploadLoanApplyedFile")
    @ApiOperation("上传贷款审核通过资料")
    public Result uploadLoanApplyedFile(@RequestParam("file") MultipartFile file,@RequestParam(name = "orderId",defaultValue = "-1") Integer id){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setStatus((short)1);
        fileInfo.setRelationId(id);
        fileInfo.setRelationType(FileRelationTypeEnum.LOAN_APPLYED_fILE);
        Result result = fileInfoService.insertFile(file,fileInfo);
        return result;
    }

    @PostMapping("/uploadWarrantApprovedFile")
    @ApiOperation("上传贷款审核通过资料")
    public Result uploadWarrantApprovedFile(@RequestParam("file") MultipartFile file,@RequestParam(name = "orderId",defaultValue = "-1") Integer id){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setStatus((short)1);
        fileInfo.setRelationId(id);
        fileInfo.setRelationType(FileRelationTypeEnum.WARRANT_APPROVED_FILE);
        Result result = fileInfoService.insertFile(file,fileInfo);
        return result;
    }

    @PostMapping("/uploadLoanApprovedFile")
    @ApiOperation("上传贷款审核通过资料")
    public Result uploadLoanApprovedFile(@RequestParam("file") MultipartFile file,@RequestParam(name = "orderId",defaultValue = "-1") Integer id){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setStatus((short)1);
        fileInfo.setRelationId(id);
        fileInfo.setRelationType(FileRelationTypeEnum.LOAN_APPROVED_FILE);
        Result result = fileInfoService.insertFile(file,fileInfo);
        return result;
    }

    @PostMapping("/uploadDetectApplyFile")
    @ApiOperation("上传贷款审核通过资料")
    public Result uploadDetectApplyFile(@RequestParam("file") MultipartFile file,@RequestParam(name = "orderId",defaultValue = "-1") Integer id){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setStatus((short)1);
        fileInfo.setRelationId(id);
        fileInfo.setRelationType(FileRelationTypeEnum.DETETCT_APPLY_FILE);
        Result result = fileInfoService.insertFile(file,fileInfo);
        return result;
    }

    @PostMapping("/uploadDetectResultFile")
    @ApiOperation("上传贷款审核通过资料")
    public Result uploadDetectResultFile(@RequestParam("file") MultipartFile file,@RequestParam(name = "orderId",defaultValue = "-1") Integer id){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setStatus((short)1);
        fileInfo.setRelationId(id);
        fileInfo.setRelationType(FileRelationTypeEnum.DETETCT_RESULT_FILE);
        Result result = fileInfoService.insertFile(file,fileInfo);
        return result;
    }

    /**
     *     INSURANCE_ORDER(new Short("42"),"INSURANCE_ORDER","保险保单资料"), done
     *     LOAN_RELATE_FILE(new Short("44"),"LOAN_RELATE_FILE","贷款申请相关资料"), done
     *     WARRANT_APPLYED_FILE(new Short("45"),"WARRANT_APPLYED_FILE","拟担保审核通过资料"), done
     *     LOAN_APPLYED_fILE(new Short("46"),"LOAN_APPLYED_fILE","贷款审核通过资料"), done
     *     WARRANT_APPROVED_FILE(new Short("47"),"WARRANT_APPROVED_FILE","担保审批通过后资料"), done
     *     LOAN_APPROVED_FILE(new Short("48"),"LOAN_APPROVED_FILE","贷款审批通过后资料"), done
     *
     *     //检测资料
     *     DETETCT_APPLY_FILE(new Short("49"),"DETETCT_APPLY_FILE","检测申请资料"), done
     *     DETETCT_RESULT_FILE(new Short("50"),"DETETCT_RESULT_FILE","检测结果资料"); done
     */


    @GetMapping("/delete")
    @ApiOperation(value = "删除文件",notes = "删除文件")
    public Result deleteFileInfo(@RequestParam(required = true)Integer id){
        Result result = new Result();
        boolean isSuccess = fileInfoService.deleteByPrimaryKey(id);
        if (isSuccess){
            result.setMessage("删除成功");
        }else{
            result.setMessage("删除失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/downFile")
    @ApiOperation(value = "文件下载",notes = "根据传入文件的路径下载文件")
    public void downBatchFile(@RequestParam(required = true) String fileUrl,@RequestParam(required = true) String fileName,
                              HttpServletResponse response){
        fileUpload.downloadFile(fileUrl,fileName,response);
    }
}
