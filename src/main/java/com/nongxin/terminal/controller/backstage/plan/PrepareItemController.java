package com.nongxin.terminal.controller.backstage.plan;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.entity.plant.PrepareItem;
import com.nongxin.terminal.service.crop.CropBatchService;
import com.nongxin.terminal.service.plan.PrepareItemService;
import com.nongxin.terminal.util.ExportExcelUtil;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/prepareItem")
public class PrepareItemController {

    @Autowired
    private PrepareItemService prepareItemService;
    @Autowired
    private ExportExcelUtil export;

    @Autowired
    private CropBatchService cropBatchService;


    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询准备事项")
    public Result<PageInfo> getBaseList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                        @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                        Integer batchId,String year){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<PrepareItem> prepareItemList = prepareItemService.getPrepareItem(batchId,year);
        PageInfo pageInfo = new PageInfo(prepareItemList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getYear")
    @ApiOperation("获取年")
    public Result<List<String>> getYear(Integer batchId){
        CropBatch cropBatch = cropBatchService.selectByPrimaryKey(batchId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String startYear = simpleDateFormat.format(cropBatch.getStartTime());
        String endYear = simpleDateFormat.format(cropBatch.getEndTime());
        List<String> list = new ArrayList<>();
        list.add(startYear);
        list.add(endYear);
        Result result = new Result();
        result.setSuccessResult(list);
        return result;
    }

    @GetMapping("/export")
    @ApiOperation("导出准备事项数据为表格")
    public void export(Integer batchId, String year, HttpServletResponse response){
        export.prepareItemExport(batchId,year,response);
    }



}
