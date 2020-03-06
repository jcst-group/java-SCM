package com.nongxin.terminal.controller.backstage.feedback;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.feedback.Feedback;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.service.feedback.FeedbackService;
import com.nongxin.terminal.service.system.UserService;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.illness.IllFeedbackStatusEnum;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.constant.DefContants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/feedBack")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/update")
    @ApiOperation("修改巡视记录")
    public Result updateFeedBack(@RequestBody Feedback feedback){
        Result result = new Result();
        feedback.setStatus(IllFeedbackStatusEnum.PROCESSED);
        boolean isSuccess = feedbackService.update(feedback);
        if (isSuccess){
            result.setMessage("处理巡视记录成功");
        }else{
            result.setMessage("处理巡视记录失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页查询巡视记录")
    public Result<PageInfo> getBaseList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                        @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                        Integer baseId,IllFeedbackStatusEnum status){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<Feedback> feedbackList = feedbackService.getFeedBack(baseId,status,null);
        PageInfo pageInfo = new PageInfo(feedbackList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

}
