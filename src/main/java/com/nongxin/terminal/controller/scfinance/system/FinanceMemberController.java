package com.nongxin.terminal.controller.scfinance.system;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.dao.scfinance.system.FinanceMemberMapper;
import com.nongxin.terminal.entity.address.Address;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.scfinance.system.FinanceMember;
import com.nongxin.terminal.service.scfinance.CommonService;
import com.nongxin.terminal.service.scfinance.system.impl.FinanceMemberServiceImpl;
import com.nongxin.terminal.util.FinanceCodeUtil;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.common.AddressRelateTypeEnum;
import com.nongxin.terminal.util.enumUtil.common.CodeEnum;
import com.nongxin.terminal.util.enumUtil.file.ImgRelationTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author clover
 * @since 2019-12-13
 */
@RestController
@RequestMapping("/finance/member")
public class FinanceMemberController {

    @Autowired
    private FinanceMemberMapper financeMemberMapper;

    @Autowired
    private FinanceMemberServiceImpl financeMemberService;

    @Autowired
    private CommonService commonService;

    @GetMapping("/list")
    @ApiOperation(value = "查询社员信息列表",notes = "GET分页查询社员信息列表")
    public Result getCompanyList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                 @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                 FinanceMember member){
        Result result = new Result<>();
        Page<FinanceMember> page = new Page<>(pageNo, pageSize);
        QueryWrapper<FinanceMember> wrapper = new QueryWrapper<>();
        wrapper.eq("finance_user_id", JwtUtil.queryFnanceUserId());
        if(member.getPhone()!=null){
            wrapper.like("phone",member.getPhone());
        }

        IPage<FinanceMember> page1 = financeMemberMapper.memberList(page,wrapper);
        //List<FinanceMember> financeMemberList = financeMemberMapper.testQueryFinanceCominfo(wrapper);
        result.setSuccessResult(page1);
        return result;
    }

    @GetMapping("/listAll")
    @ApiOperation(value = "查询社员信息列表",notes = "GET分页查询社员信息列表")
    public Result memberLists(){
        Result result = new Result<>();
        QueryWrapper<FinanceMember> wrapper = new QueryWrapper<>();
        wrapper.eq("finance_user_id", JwtUtil.queryFnanceUserId());

        List<FinanceMember> members = financeMemberMapper.financeMemberList(wrapper);
        //List<FinanceMember> financeMemberList = financeMemberMapper.testQueryFinanceCominfo(wrapper);
        result.setSuccessResult(members);
        return result;
    }

    @GetMapping("/listAllByUserId")
    @ApiOperation(value = "查询社员信息列表根据金融用户ID",notes = "查询社员信息列表根据金融用户ID")
    public Result memberLists(@RequestParam Integer financeUserId){
        Result result = new Result<>();
        QueryWrapper<FinanceMember> wrapper = new QueryWrapper<>();
        wrapper.eq("finance_user_id", financeUserId);
        List<FinanceMember> members = financeMemberMapper.financeMemberList(wrapper);
        //List<FinanceMember> financeMemberList = financeMemberMapper.testQueryFinanceCominfo(wrapper);
        result.setSuccessResult(members);
        return result;
    }




    @PostMapping("/addOrUpdate")
    @ApiOperation(value = "添加或修改合作社社员",notes = "添加社员")
    public Result saveOrUpdate(@RequestBody FinanceMember member){
        Result result = new Result<>();

        boolean save = false;

        try {
            //增加一個多租户的字段
            if(member.getId()==null){
                Integer fnanceUserId = JwtUtil.queryFnanceUserId();
                member.setFinanceUserId(fnanceUserId);
                member.setTenantId(fnanceUserId);
                member.setMemberCode(FinanceCodeUtil.getCode(CodeEnum.MEMBER));
            }

            //需保存头像图片，身份证图片，入社申请图片,住址
            save = financeMemberService.saveOrUpdate(member);

            Integer memberId = member.getId();

            List<PictureInfo> headPictureInfos = member.getHeadPictureInfos();
            List<PictureInfo> idPictureInfos = member.getIdPictureInfos();
            List<PictureInfo> concPictureInfos = member.getConcPictureInfos();
            commonService.savePictures(headPictureInfos,memberId, ImgRelationTypeEnum.MEMBER_HEAD);
            commonService.savePictures(idPictureInfos,memberId, ImgRelationTypeEnum.MEMBER_CREDIT);
            commonService.savePictures(concPictureInfos,memberId, ImgRelationTypeEnum.JOIN_SOCIAL);

            //保存地址
            Address address = member.getAddress();
            commonService.saveOrUpdateAddress(address,memberId, AddressRelateTypeEnum.MEMBER_ADDRESS);
        } catch (Exception e) {
            save = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }

        if(save){
            result.setMessage("编辑社员信息成功");
        }else{
            result.setMessage("编辑社员公司信息失败");
        }
        result.setSuccess(save);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除合作社社员",notes = "删除社员")
    public Result delete(@RequestParam Integer id){
        Result result = new Result<>();

        boolean save = false;

        try {
            //需保存头像图片，身份证图片，入社申请图片,住址
            save = financeMemberService.deleteAndPics(id);

        } catch (Exception e) {
            save = false;
            result.setMessage(e.getMessage());
            e.printStackTrace();
        }

        if(save){
            result.setMessage("删除社员信息成功");
        }else{
            result.setMessage("删除社员公司信息失败");
        }
        result.setSuccess(save);
        return result;
    }







}
