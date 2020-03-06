package com.nongxin.terminal.controller.backstage.envmonitor;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.envmonitor.VideoEquipment;
import com.nongxin.terminal.service.envmonitor.VideoEquipmentService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videoEquipment")
public class VideoEquipmentController {

    @Autowired
    private VideoEquipmentService videoEquipmentService;

    @PostMapping("/insert")
    public Result<String> insert(@RequestBody VideoEquipment videoEquipment){
        Result<String> result = new Result<>();
        boolean isInsertSuccess = false;
        if(check(videoEquipment.getSerialNumber())){
            isInsertSuccess = videoEquipmentService.insertSelective(videoEquipment);
        }
        if(isInsertSuccess){
            result.setMessage("添加成功");
        }else{
            result.setMessage("添加失败,设备序列号已存在!");
        }
        result.setSuccess(isInsertSuccess);
        return result;
    }

    /**
     * 检查监控设备序列号
     * @param serialNumber
     * @return
     */
    public Boolean check(String serialNumber){
        Boolean result = true;
        VideoEquipment videoEquipment = videoEquipmentService.checkSerialNumber(serialNumber);
        if(videoEquipment!=null){
            result = false;
        }
        return result;
    }

    @PostMapping("/update")
    public Result<String> update(@RequestBody VideoEquipment videoEquipment){
        Result<String> result = new Result<>();
        boolean isUpdateSuccess = videoEquipmentService.update(videoEquipment);
        if(isUpdateSuccess){
            result.setMessage("修改成功");
        }else{
            result.setMessage("修改失败");
        }
        result.setSuccess(isUpdateSuccess);
        return result;
    }

    @GetMapping("/delete")
    public Result<String> delete(Integer id){
        Result<String> result = new Result<>();
        boolean isDeleteSuccess = videoEquipmentService.delete(id);
        if(isDeleteSuccess){
            result.setMessage("删除成功");
        }else {
            result.setMessage("删除失败");
        }
        result.setSuccess(isDeleteSuccess);
        return result;
    }

    @GetMapping("/list")
    public Result<PageInfo> getList(@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                    @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                                    VideoEquipment videoEquipment){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<VideoEquipment> list = videoEquipmentService.getList(videoEquipment);
        PageInfo pageInfo = new PageInfo(list);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getList")
    @ApiOperation(value = "下拉选择视频设备")
    public Result<List<VideoEquipment>> getVideoList(VideoEquipment videoEquipment){
        Result<List<VideoEquipment>> result = new Result<>();
        List<VideoEquipment> list = videoEquipmentService.getList(videoEquipment);
        result.setResult(list);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getVideoList")
    @ApiOperation(value = "视频列表")
    public Result<List<VideoEquipment>> getVideoList(){
        Result<List<VideoEquipment>> result = new Result<>();
        List<VideoEquipment> list = videoEquipmentService.getList(new VideoEquipment());
        result.setResult(list);
        result.setMessage("获取成功");
        result.setSuccess(true);
        return result;
    }
}
