package com.nongxin.terminal.controller.backstage.envmonitor;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.envmonitor.VideoChannel;
import com.nongxin.terminal.service.envmonitor.VideoChannelService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videoChannel")
public class VideoChannelController {

    @Autowired
    private VideoChannelService videoChannelService;

    @PostMapping("/insert")
    @ApiOperation(value = "添加视频通道")
    public Result<String> insert(@RequestBody @Validated VideoChannel videoChannel){
        Result<String> result = new Result<>();
        boolean isInsertSuccess = false;
        if(checkChannel(videoChannel.getSerialId(),videoChannel.getChannelNo())){
            isInsertSuccess = videoChannelService.insertSelective(videoChannel);
        }
        if(isInsertSuccess){
            result.setMessage("添加通道成功！");
        }else{
            result.setMessage("添加通道失败,该序列号下已存在该通道！");
        }
        result.setSuccess(isInsertSuccess);
        return result;
    }

    /**
     * 检查通道是否存在
     * @param serialId
     * @param channelNo
     * @return
     */
    public Boolean checkChannel(Integer serialId, Integer channelNo){
        boolean result = true;
        VideoChannel videoChannel = videoChannelService.checkChannel(serialId,channelNo);
        if(videoChannel!=null){
            result = false;
        }
        return result;
    }
    @PostMapping("/update")
    @ApiOperation(value = "修改视频通道")
    public Result<String> update(@RequestBody VideoChannel videoChannel){
        Result<String> result = new Result<>();
        boolean isUpdateSuccess = videoChannelService.updateByPrimaryKeySelective(videoChannel);
        if(isUpdateSuccess){
            result.setMessage("修改通道成功");
        }else{
            result.setMessage("修改通道失败");
        }
        result.setSuccess(isUpdateSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除视频通道")
    public Result<String> delete(Integer id){
        Result<String> result = new Result<>();
        boolean isDeleteSuccess = videoChannelService.deleteByPrimaryKey(id);
        if(isDeleteSuccess){
            result.setMessage("删除通道成功");
        }else {
            result.setMessage("删除通道失败");
        }
        result.setSuccess(isDeleteSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页条件查询通道")
    public Result<PageInfo> getList(@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                    @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
                                    String serialNumber,Integer baseId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<VideoChannel> list = videoChannelService.getChannelList(serialNumber,baseId);
        PageInfo pageInfo = new PageInfo(list);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }
}
