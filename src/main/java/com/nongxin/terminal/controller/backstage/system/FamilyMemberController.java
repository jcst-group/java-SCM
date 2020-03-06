package com.nongxin.terminal.controller.backstage.system;

import com.nongxin.terminal.entity.system.FamilyMenber;
import com.nongxin.terminal.service.system.FamilyMemberService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/familyMenber")
public class FamilyMemberController {

    @Autowired
    private FamilyMemberService familyMemberService;

    @PostMapping("/add")
    @ApiOperation("添加家庭成员")
    public Result addFamilyMember(@Validated @RequestBody FamilyMenber familyMenber){
        Result result = new Result();
        boolean isSuccess = familyMemberService.add(familyMenber);
        if (isSuccess){
            result.setMessage("添加家庭成员成功");
        }else {
            result.setMessage("添加家庭成员失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除家庭成员")
    public Result deleteFamilyMember(Integer id){
        Result result = new Result();
        boolean isSuccess = familyMemberService.delete(id);
        if (isSuccess){
            result.setMessage("删除家庭成员成功");
        }else {
            result.setMessage("删除家庭成员失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改家庭成员")
    public Result updateFamilyMember(@RequestBody FamilyMenber familyMenber){
        Result result = new Result();
        boolean isSuccess = familyMemberService.update(familyMenber);
        if (isSuccess){
            result.setMessage("修改家庭成员成功");
        }else {
            result.setMessage("修改家庭成员失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/getFamilyMemberByUid")
    @ApiOperation("查询用户家庭成员")
    public Result getFamilyMemberByUid(@RequestParam(required = true) Integer uid){
        Result result = new Result();
        result.setSuccessResult(familyMemberService.getFamilyMemberByUid(uid));
        return result;
    }

}
