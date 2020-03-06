package com.nongxin.terminal.controller.backstage.crop;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.dao.plant.FarmingMapper;
import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.entity.plant.Farming;
import com.nongxin.terminal.service.crop.CropBatchService;
import com.nongxin.terminal.util.enumUtil.crop.BatchStatusEnum;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.batch.BatchVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cropBatch")
public class CropBatchController {

    @Autowired
    private CropBatchService cropBatchService;
    @Autowired(required = false)
    private FarmingMapper farmingMapper;

    @PostMapping("/add")
    @ApiOperation("添加作物批次")
    public Result addCropBatch(@Validated @RequestBody CropBatch cropBatch){
        Result result = new Result();
        Farming firstFarming = farmingMapper.getFirstByPlantingId(cropBatch.getPlanId());
        if (firstFarming==null){
            result.setMessage("该种植计划暂无农事活动，添加失败");
            result.setSuccess(false);
            return result;
        }
        cropBatch.setStatus(BatchStatusEnum.NOT_USED);
        result = cropBatchService.add(cropBatch);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除作物批次")
    public Result deleteCropBatch(Integer id){
        return cropBatchService.delete(id);
    }

    @PostMapping("/update")
    @ApiOperation("修改作物批次")
    public Result updateCropBatch(@RequestBody CropBatch cropBatch){
        Result result = new Result();
        Farming firstFarming = farmingMapper.getFirstByPlantingId(cropBatch.getPlanId());
        if (firstFarming==null){
            result.setMessage("该种植计划暂无农事活动，添加失败");
            result.setSuccess(false);
            return result;
        }
        result = cropBatchService.update(cropBatch);
        return result;
    }

    @GetMapping("/updateStatus")
    @ApiOperation("完成批次")
    public Result updateStatus(@RequestParam(required = true)Integer id){
        Result result = new Result();
        boolean isSuccess = cropBatchService.updateStatus(id,BatchStatusEnum.COMPLETED);
        if (isSuccess){
            result.setMessage("完成批次成功");
        }else {
            result.setMessage("完成批次失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询作物批次")
    public Result<PageInfo> getCropBatchList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                            @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                             CropBatch cropBatch){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<CropBatch> cropBatchList = cropBatchService.getCropBatchList(cropBatch);
        PageInfo pageInfo = new PageInfo(cropBatchList);
        result.setSuccessResult(pageInfo);
        return result;
    }



    @GetMapping("/all")
    @ApiOperation("获取所有批次，用于下拉列表选择")
    public Result getAllCropBatch(Integer baseId,Integer planId,String batchName){
        Result result = new Result();
        result.setSuccessResult(cropBatchService.getAllCropBatch(baseId,planId,batchName));
        return result;
    }

    @GetMapping("/unFinishBatch")
    @ApiOperation(value = "分页带条件查询作物批次")
    public Result<PageInfo> getUnFinishBatch(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                             @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                             String batchName,@RequestParam(required = true) Integer farming,Integer planId,String isEstablish){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<BatchVo> cropBatchList = cropBatchService.getBatchVo(farming,batchName,BatchStatusEnum.COMPLETED,planId,isEstablish);
        PageInfo pageInfo = new PageInfo(cropBatchList);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/getBatchByPlanId")
    @ApiOperation("根据种植计划id查询批次")
    public Result getBatchByPlanId(Integer planId,Integer startYear){
        Result result = new Result();
        result.setSuccessResult(cropBatchService.getBatchByPlanId(planId,startYear));
        return result;
    }

    @GetMapping("/selectByBaseId")
    @ApiOperation("根据基地id查询批次")
    public Result getBatchByPlanId(@RequestParam(required = true)Integer baseId){
        Result result = new Result();
        result.setSuccessResult(cropBatchService.selectByBaseId(baseId));
        return result;
    }

    @GetMapping("/getBatchAndRecovery")
    @ApiOperation(value = "分页带条件查询批次以及批次关联的采收批次")
    public Result<PageInfo> getBatchAndRecovery(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                             @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                             Integer batchId, Date startTime, Date endTime){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<CropBatch> cropBatchList = cropBatchService.getBatchAndRecovery(batchId,startTime,endTime);
        PageInfo pageInfo = new PageInfo(cropBatchList);
        result.setSuccessResult(pageInfo);
        return result;
    }

}
