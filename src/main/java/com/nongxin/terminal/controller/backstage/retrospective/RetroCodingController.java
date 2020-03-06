package com.nongxin.terminal.controller.backstage.retrospective;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.crop.Crop;
import com.nongxin.terminal.entity.retrospective.RetroCoding;
import com.nongxin.terminal.service.crop.CropService;
import com.nongxin.terminal.service.retrospective.RetroCodingService;
import com.nongxin.terminal.service.system.ConstantStorageService;
import com.nongxin.terminal.util.CodeUtil;
import com.nongxin.terminal.util.ExportExcelUtil;
import com.nongxin.terminal.util.enumUtil.common.CodeEnum;
import com.nongxin.terminal.util.enumUtil.retrospective.RetroCodingTypeEnum;
import com.nongxin.terminal.util.enumUtil.system.ConstantTypeEnum;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.retrospective.RetroCodeVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/retroCoding")
public class RetroCodingController {

    @Autowired
    private RetroCodingService retroCodingService;
    @Autowired
    private ExportExcelUtil export;
    @Autowired
    private ConstantStorageService constantStorageService;

    @PostMapping("/add")
    @ApiOperation("添加追溯码")
    public Result addCrop(@Validated @RequestBody RetroCoding retroCoding){
        return retroCodingService.add(retroCoding);
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询追溯码")
    public Result<PageInfo> getCropList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                        @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                        RetroCodingTypeEnum type,String batchCode, String retroCode){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<RetroCoding> retroCodingList = null;
        if (type != null || batchCode == null){
            retroCodingList = retroCodingService.getRetroCoding(type,batchCode,retroCode);
        }else{
            if (batchCode.indexOf("CS") != -1){
                retroCodingList = retroCodingService.getRetroCoding(RetroCodingTypeEnum.RECO_BATCH,batchCode,retroCode);
            }else{
                retroCodingList = retroCodingService.getRetroCoding(RetroCodingTypeEnum.INIT_BATCH,batchCode,retroCode);
            }
        }
        PageInfo pageInfo = new PageInfo(retroCodingList);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/export")
    @ApiOperation("导出追溯打码为表格")
    public void export(RetroCodingTypeEnum type,String batchCode, String retroCode, HttpServletResponse response){
        export.retroCodingExport(type,batchCode,retroCode,response);
    }

    @GetMapping("/getBatchByType")
    @ApiOperation("根据追溯码批次类型查询批次")
    public Result getBatchByType(RetroCodingTypeEnum type,String condition){
        Result result = new Result();
        result.setSuccessResult(retroCodingService.getBatchByType(type,condition));
        return  result;
    }

    @GetMapping("/getResidualOutput")
    @ApiOperation("查询批次剩余产量")
    public Result getBatchByType(Integer batchId,RetroCodingTypeEnum type){
        Result result = new Result();
        result.setSuccessResult(retroCodingService.getResidualOutput(batchId,type));
        return  result;
    }

    @GetMapping("/getRetroByRetroCode")
    @ApiOperation("根据追溯编号查询追溯码信息")
    public Result getRetroByRetroCode(String relationCode){
        Result result = new Result();
        RetroCodingTypeEnum type = null;
        if (relationCode != null && relationCode.indexOf("CS") != -1){
            type = RetroCodingTypeEnum.RECO_BATCH;
        }else{
            type = RetroCodingTypeEnum.INIT_BATCH;
        }
        result.setSuccessResult(retroCodingService.getRetroByRetroCode(relationCode,type));
        return  result;
    }


}
