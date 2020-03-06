package com.nongxin.terminal.controller.backstage.budget;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.service.crop.CropBatchService;
import com.nongxin.terminal.service.plan.PrepareItemService;
import com.nongxin.terminal.util.ExportExcelUtil;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.workorder.BusinessReportVo;
import com.nongxin.terminal.vo.workorder.OrderConditionVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    private PrepareItemService prepareItemService;
    @Autowired
    private ExportExcelUtil export;
    @Autowired
    private CropBatchService cropBatchService;

    @GetMapping("/list")
    @ApiOperation("获取预算列表")
    public Result getBudget(@RequestParam(required = true)int[] batchIds){
        Result result = new Result();
        result.setSuccessResult(prepareItemService.getBudgetByBatchIds(batchIds));
        return result;
    }

    @GetMapping("/export")
    @ApiOperation("导出预算报表")
    public void export(int[] batchIds, HttpServletResponse response){
        export.budgetExport(batchIds,response);
    }

    @GetMapping("/getBusinessReport")
    @ApiOperation("获取批次经营报表")
    public Result<PageInfo> getBatchByPlanId(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                             @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                             CropBatch cropBatch){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<BusinessReportVo> businessReportVos = cropBatchService.getBusinessReport(cropBatch);
        PageInfo pageInfo = new PageInfo(businessReportVos);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/businessExport")
    @ApiOperation("导出经营报表")
    public void export(CropBatch cropBatch, HttpServletResponse response){
        export.businessExport(cropBatch,response);
    }

}
