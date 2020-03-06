package com.nongxin.terminal.controller.backstage.company;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.company.CompanyTeam;
import com.nongxin.terminal.service.company.CompanyTeamService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class CompanyTeamController {

    @Autowired
    private CompanyTeamService companyTeamService;

    @PostMapping("/insert")
    @ApiOperation(value="添加公司团队信息", notes = "POST添加公司团队信息")
    public Result<CompanyTeam> insertCompanyInfo(@Validated @RequestBody CompanyTeam companyTeam){
        Result<CompanyTeam> result = new Result<>();
        boolean isInsertSuccess = companyTeamService.insertSelective(companyTeam);
        if(isInsertSuccess){
            result.setMessage("添加公司团队信息成功");
        }else{
            result.setMessage("添加公司团队信息失败");
        }
        result.setSuccess(isInsertSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation(value="修改公司团队信息", notes = "POST修改公司团队信息")
    public Result<CompanyTeam> updateCompanyInfo( @RequestBody CompanyTeam companyTeam){
        Result<CompanyTeam> result = new Result<>();
        boolean isUpdateSuccess = companyTeamService.updateByPrimaryKeySelective(companyTeam);
        if(isUpdateSuccess){
            result.setMessage("修改公司团队信息成功");
        }else{
            result.setMessage("修改公司团队信息失败");
        }
        result.setSuccess(isUpdateSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation(value="删除数据", notes = "GET删除公司团队信息数据")
    public Result<CompanyTeam> delete(Integer id){
        Result<CompanyTeam> result = new Result<>();
        boolean isDelSuccess = companyTeamService.deleteByPrimaryKey(id);
        if(isDelSuccess){
            result.setMessage("删除公司团队信息成功");
        }else{
            result.setMessage("删除公司团队信息失败");
        }
        result.setSuccess(isDelSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取数据列表")
    public Result<PageInfo> getTeamList(@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                              @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                                        CompanyTeam companyTeam){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<CompanyTeam> list = companyTeamService.getList(companyTeam);
        PageInfo pageInfo = new PageInfo(list);
        result.setSuccessResult(pageInfo);
        return result;
    }
}
