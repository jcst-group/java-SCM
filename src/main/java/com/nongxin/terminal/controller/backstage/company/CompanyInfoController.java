package com.nongxin.terminal.controller.backstage.company;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.company.CompanyInfo;
import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.service.company.CompanyInfoService;
import com.nongxin.terminal.service.file.FileInfoService;
import com.nongxin.terminal.service.file.PictureInfoService;
import com.nongxin.terminal.util.enumUtil.file.FileRelationTypeEnum;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/companyInfo")
public class CompanyInfoController {

    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private PictureInfoService pictureInfoService;
    @Autowired
    private FileInfoService fileInfoService;


    @PostMapping("/insert")
    @ApiOperation(value="添加公司信息", notes = "POST添加公司信息")
    public Result<CompanyInfo> insertCompanyInfo(@Validated @RequestBody CompanyInfo companyInfo){
        Result<CompanyInfo> result = new Result<>();
        boolean isInsertSuccess = companyInfoService.insertSelective(companyInfo);
        if(isInsertSuccess){
            result.setMessage("添加公司信息成功");
        }else{
            result.setMessage("添加公司信息失败");
        }
        result.setSuccess(isInsertSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation(value="修改公司信息", notes = "POST修改公司信息")
    public Result<CompanyInfo> updateCompanyInfo( @RequestBody CompanyInfo companyInfo){
        Result<CompanyInfo> result = new Result<>();
        boolean isUpdateSuccess = companyInfoService.updateByPrimaryKeySelective(companyInfo);
        if(isUpdateSuccess){
            result.setMessage("修改公司信息成功");
        }else{
            result.setMessage("修改公司信息失败");
        }
        result.setSuccess(isUpdateSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation(value="删除数据", notes = "GET删除公司信息数据")
    public Result<CompanyInfo> delete(Integer id){
        Result<CompanyInfo> result = new Result<>();
        boolean isDelSuccess = companyInfoService.deleteByPrimaryKey(id);
        if(isDelSuccess){
            result.setMessage("删除公司信息成功");
        }else{
            result.setMessage("删除公司信息失败");
        }
        result.setSuccess(isDelSuccess);
        return result;
    }

    @GetMapping("/getCompanyById")
    @ApiOperation(value="查询公司信息", notes = "GET根据id查询公司信息列表")
    public Result<CompanyInfo> getCompanyById(Integer id){
        Result<CompanyInfo> result = new Result<>();
        CompanyInfo companyInfo = companyInfoService.selectByPrimaryKey(id);
        result.setResult(companyInfo);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询公司信息列表",notes = "GET分页模糊查询公司信息列表")
    public Result<PageInfo> getCompanyList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                              @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                           CompanyInfo companyInfo){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<CompanyInfo> companyInfoList = companyInfoService.getCompanyInfoList(companyInfo);
        PageInfo pageInfo = new PageInfo(companyInfoList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getCompanyInfo")
    @ApiOperation(value="查询公司信息", notes = "用于下拉选择")
    public Result<List<CompanyInfo>> getCompanyInfo(){
        Result<List<CompanyInfo>> result = new Result<>();
        List<CompanyInfo> companylist = companyInfoService.getCompanyInfo();
        result.setResult(companylist);
        result.setSuccess(true);
        return result;
    }

    @PostMapping("/addMPicure")
    @ApiOperation("上传公司管理模式图片")
    public Result uploadMPic(@RequestParam("file") MultipartFile file,@RequestParam(defaultValue = "1") Integer id){
        return pictureInfoService.add(file,id, ImgRelationTypeEnum.COMPANY_MANAGER);
    }

    @PostMapping("/addHPicure")
    @ApiOperation("上传公司荣誉模式图片")
    public Result uploadHPic(@RequestParam("file") MultipartFile file,@RequestParam(defaultValue = "1") Integer id){
        return pictureInfoService.add(file,id, ImgRelationTypeEnum.COMPANY_HONOR);
    }

    @PostMapping("/addComPicture")
    @ApiOperation(value = "上传公司简介图")
    public Result uploadComPic(@RequestParam("file") MultipartFile file,@RequestParam(defaultValue = "1") Integer id){
        return pictureInfoService.add(file,id,ImgRelationTypeEnum.COMPANY_PROFILE);
    }

    @PostMapping("/uploadVideoCompany")
    @ApiOperation("上传公司介绍视频文件")
    public Result uploadVideoCompany(@RequestParam("file") MultipartFile file,@RequestParam(defaultValue = "1") Integer id){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setStatus((short)1);
        fileInfo.setRelationId(id);
        fileInfo.setRelationType(FileRelationTypeEnum.VIDEOCOMPANY);
        Result result = fileInfoService.insertFile(file,fileInfo);
        return result;
    }

    @PostMapping("/uploadVideoProduct")
    @ApiOperation("上传产品介绍视频文件")
    public Result uploadVideoProduct(@RequestParam("file") MultipartFile file,@RequestParam(defaultValue = "1") Integer id){
        FileInfo fileInfo = new FileInfo();
        fileInfo.setStatus((short)1);
        fileInfo.setRelationId(id);
        fileInfo.setRelationType(FileRelationTypeEnum.VIDEOPRODUCT);
        Result result = fileInfoService.insertFile(file,fileInfo);
        return result;
    }

}
