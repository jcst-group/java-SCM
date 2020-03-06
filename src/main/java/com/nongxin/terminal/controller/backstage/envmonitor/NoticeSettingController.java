package com.nongxin.terminal.controller.backstage.envmonitor;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.envmonitor.NoticeSetting;
import com.nongxin.terminal.service.envmonitor.NoticeSettingService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticeSetting")
public class NoticeSettingController {

    @Autowired
    private NoticeSettingService noticeSettingService;

    @PostMapping("/add")
    @ApiOperation(value = "添加通知设置信息")
    public Result<NoticeSetting> insert(@RequestBody NoticeSetting noticeSetting){
        Result<NoticeSetting> result = new Result<>();
        boolean isInsertSuccess = noticeSettingService.insert(noticeSetting);
        if(isInsertSuccess){
            result.setMessage("添加成功");
        }else{
            result.setMessage("添加失败");
        }
        result.setSuccess(isInsertSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改通知设置信息")
    public Result<NoticeSetting> update(@RequestBody NoticeSetting noticeSetting){
        Result<NoticeSetting> result = new Result<>();
        boolean isUpdateSuccess = noticeSettingService.update(noticeSetting);
        if(isUpdateSuccess){
            result.setMessage("修改成功");
        }else{
            result.setMessage("修改失败");
        }
        result.setSuccess(isUpdateSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除通知设置信息")
    public Result<NoticeSetting> delete(Integer id){
        Result<NoticeSetting> result = new Result<>();
        boolean isDeleteSuccess = noticeSettingService.delete(id);
        if(isDeleteSuccess){
            result.setMessage("删除成功");
        }else{
            result.setMessage("删除失败");
        }
        result.setSuccess(isDeleteSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询已设置信息")
    public Result<PageInfo> getList(@RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
                                    @RequestParam(name="pageSize", defaultValue="10") Integer pageSize){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<NoticeSetting> list = noticeSettingService.getList();
        PageInfo pageInfo = new PageInfo(list);
        result.setSuccessResult(pageInfo);
        return result;
    }
}
