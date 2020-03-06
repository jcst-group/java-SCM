package com.nongxin.terminal.service.scfinance.insurance.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nongxin.terminal.dao.scfinance.insurance.InsplantMemberRelMapper;
import com.nongxin.terminal.dao.scfinance.insurance.InsurancePlantInfoMapper;
import com.nongxin.terminal.entity.scfinance.insurance.InsplantMemberRel;
import com.nongxin.terminal.entity.scfinance.insurance.InsurancePlantInfo;
import com.nongxin.terminal.entity.scfinance.system.FinanceMember;
import com.nongxin.terminal.service.scfinance.insurance.IInsurancePlantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clover
 * @since 2019-12-13
 */
@Service
public class InsurancePlantInfoServiceImpl extends ServiceImpl<InsurancePlantInfoMapper, InsurancePlantInfo> implements IInsurancePlantInfoService {


    @Autowired
    private InsplantMemberRelMapper insplantMemberRelMapper;

    public boolean saveOrUpdatePlantInfo(InsurancePlantInfo insurancePlantInfo){

        boolean success = false;
        try {
            List<FinanceMember> financeMembers = insurancePlantInfo.getFinanceMembers();
            if(financeMembers == null){
                financeMembers = new ArrayList<>();
            }
            List<Integer> memberIds = financeMembers.stream().map(x -> x.getId()).collect(Collectors.toList());
            //保存险种为种植险时，保存种植险信息
            success = super.saveOrUpdate(insurancePlantInfo);


            Integer infoId = insurancePlantInfo.getId();
            /**
             * 删除旧的种植险与社员关联信息
             */
            QueryWrapper<InsplantMemberRel> queryWrapper = new QueryWrapper();
            queryWrapper.eq("info_id",infoId);
            int delete = insplantMemberRelMapper.delete(queryWrapper);

            /**
             * 保存新的种植险与社员关联关系
             */
            for(Integer memberId:memberIds) {
                InsplantMemberRel insplantMemberRel = new InsplantMemberRel();
                insplantMemberRel.setInfoId(infoId);
                insplantMemberRel.setMemberId(memberId);
                int insert = insplantMemberRelMapper.insert(insplantMemberRel);
            }
        } catch (Exception e) {
            e.printStackTrace();
            success = false;
        }


        return success;

    }

}
