package com.nongxin.terminal.controller.backstage.illness;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.illness.IllFeedback;
import com.nongxin.terminal.service.illness.IllFeedbackService;
import com.nongxin.terminal.util.enumUtil.illness.IllFeedbackStatusEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/illFeedback")
public class IllFeedbackController {

    @Autowired
    private IllFeedbackService illFeedbackService;

    @GetMapping("/delete")
    @ApiOperation("删除病虫害反馈")
    public Result deleteIllFeedback(Integer id){
        Result result = new Result();
        boolean isSuccess = illFeedbackService.delete(id);
        if (isSuccess){
            result.setMessage("删除病虫害反馈成功");
        }else {
            result.setMessage("删除病虫害反馈失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改病虫害反馈")
    public Result updateIllFeedback(@RequestBody IllFeedback illFeedback){
        Result result = new Result();
        boolean isSuccess = illFeedbackService.update(illFeedback);
        if (isSuccess){
            result.setMessage("修改病虫害反馈成功");
        }else {
            result.setMessage("修改病虫害反馈失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation("查询病虫害反馈")
    public Result addIllFeedback(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                 @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                 Integer baseId,IllFeedbackStatusEnum status){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<IllFeedback> roleList = illFeedbackService.getIllFeedbackList(baseId,status);
        PageInfo pageInfo = new PageInfo(roleList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

    @PostMapping("/processFeedback")
    @ApiOperation("处理病虫害反馈")
    public Result processFeedback(@RequestBody IllFeedback illFeedback){
        Result result = new Result();
        boolean isSuccess = illFeedbackService.processFeedback(illFeedback);
        if (isSuccess){
            result.setMessage("处理病虫害反馈成功");
        }else {
            result.setMessage("处理病虫害反馈失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

}
