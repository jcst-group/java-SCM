package com.nongxin.terminal.controller.scfinance.system;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.entity.scfinance.insurance.FinanceNotify;
import com.nongxin.terminal.service.scfinance.system.impl.FinanceNotifyServiceImpl;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.scfinance.TrueOrFalseEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author clover
 * @since 2019-12-31
 */
@RestController
@RequestMapping("/finance/notify")
public class FinanceNotifyController {


    @Autowired
    private FinanceNotifyServiceImpl financeNotifyService;

    @GetMapping("/list")
    @ApiOperation(value = "查询通知列表",notes = "GET分页查询通知列表")
    public Result getCompanyList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                 @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                 FinanceNotify notify){
        Result result = new Result<>();
        Page<FinanceNotify> page = new Page<>(pageNo, pageSize);
        QueryWrapper<FinanceNotify> wrapper = new QueryWrapper<>();
        wrapper.eq("finance_user_id", JwtUtil.queryFnanceUserId());

        wrapper.lambda().orderByDesc(FinanceNotify::getIfRead).orderByDesc(FinanceNotify::getCreateTime);
        IPage<FinanceNotify> page1 = financeNotifyService.page(page,wrapper);

        //List<FinanceMember> financeMemberList = financeMemberMapper.testQueryFinanceCominfo(wrapper);
        result.setSuccessResult(page1);
        return result;
    }

    @GetMapping("/listCount")
    @ApiOperation(value = "查询通知列表",notes = "GET分页查询通知列表")
    public Result listCount(){
        Result result = new Result<>();
        QueryWrapper<FinanceNotify> wrapper = new QueryWrapper<>();
        wrapper.eq("finance_user_id", JwtUtil.queryFnanceUserId());
        wrapper.lambda().eq(FinanceNotify::getIfRead, TrueOrFalseEnum.FALSE);

        int count = financeNotifyService.count(wrapper);

        //List<FinanceMember> financeMemberList = financeMemberMapper.testQueryFinanceCominfo(wrapper);
        result.setSuccessResult(count);
        return result;
    }

    @GetMapping("/allRead")
    @ApiOperation(value = "将所有未读标记为已读",notes = "将所有未读标记为已读")
    public Result allRead(){
        Result result = new Result<>();
        QueryWrapper<FinanceNotify> wrapper = new QueryWrapper<>();

        wrapper.lambda().eq(FinanceNotify::getIfRead, TrueOrFalseEnum.FALSE);
        FinanceNotify financeNotify = new FinanceNotify();
        financeNotify.setIfRead(TrueOrFalseEnum.TRUE);
        boolean update = financeNotifyService.update(financeNotify,wrapper);

        //List<FinanceMember> financeMemberList = financeMemberMapper.testQueryFinanceCominfo(wrapper);
        result.setSuccessResult("处理成功");
        return result;
    }

    @GetMapping("/readOne")
    @ApiOperation(value = "将一个未读标记为已读",notes = "将一个未读标记为已读")
    public Result readOne(@RequestParam(name = "id") Integer notifyId){
        Result result = new Result<>();
        QueryWrapper<FinanceNotify> wrapper = new QueryWrapper<>();

        wrapper.lambda().eq(FinanceNotify::getId,notifyId);
        FinanceNotify financeNotify = new FinanceNotify();
        financeNotify.setIfRead(TrueOrFalseEnum.TRUE);
        boolean update = financeNotifyService.update(financeNotify,wrapper);

        //List<FinanceMember> financeMemberList = financeMemberMapper.testQueryFinanceCominfo(wrapper);
        result.setSuccessResult("处理成功");
        return result;
    }
}
