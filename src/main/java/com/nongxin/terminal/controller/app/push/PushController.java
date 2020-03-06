package com.nongxin.terminal.controller.app.push;

import com.nongxin.terminal.dao.push.WorkOrderQueryMapper;
import com.nongxin.terminal.entity.push.PushRel;
import com.nongxin.terminal.service.push.PushRelService;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.push.CIDVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/push")
public class PushController {

    @Autowired
    private PushRelService pushRelService;

    @Autowired
    private WorkOrderQueryMapper workOrderQueryMapper;

    @PostMapping("/addCid")
    @ApiOperation(value = "登录App时添加手机CID")
    public Result<String> add(@RequestBody PushRel pushRel){
        Result<String> result = new Result<>();
        boolean insertSuccess = false;
        if (pushRelService.isExist(pushRel)==null){
            insertSuccess = pushRelService.insertSelective(pushRel);
        }
        if(insertSuccess){
            result.setMessage("添加成功");
        }else{
            result.setMessage("添加失败");
        }
        result.setSuccess(insertSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation(value = "退出登录时删除这台手机CID与用户的关联")
    public Result<String> delete(Integer userId,String cid){
        PushRel pushRel = new PushRel();
        pushRel.setUserId(userId);
        pushRel.setCid(cid);
        Result<String> result = new Result<>();
        boolean deleteSuccess = false;
        if (pushRelService.isExist(pushRel)!=null){
            deleteSuccess = pushRelService.deleteByUidAndCid(pushRel);
        }
        if(deleteSuccess){
            result.setMessage("删除成功");
        }else{
            result.setMessage("删除失败");
        }
        result.setSuccess(deleteSuccess);
        return result;
    }

    @GetMapping("/list")
    public Result<List<CIDVo>> getList(){
        Result<List<CIDVo>> result = new Result<>();
        result.setSuccessResult(workOrderQueryMapper.getUserCid());
        return result;
    }
}
