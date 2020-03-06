package com.nongxin.terminal.service.plan.impl;

import com.nongxin.terminal.dao.plant.FarmingMapper;
import com.nongxin.terminal.dao.plant.FarmingRoleMapper;
import com.nongxin.terminal.entity.plant.Farming;
import com.nongxin.terminal.entity.plant.FarmingRole;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.service.plan.FarmingService;
import com.nongxin.terminal.util.enumUtil.plan.FarmingTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class FarmingServiceImpl implements FarmingService {

    @Autowired(required = false)
    private FarmingMapper farmingMapper;
    @Autowired(required = false)
    private FarmingRoleMapper farmingRoleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(Farming farming) {
        try {
            farmingMapper.insertSelective(farming);
            FarmingRole farmingRole = new FarmingRole();
            farmingRole.setFarmingId(farming.getId());
            for (Role role : farming.getRoleList()) {
                farmingRole.setRoleId(role.getId());
                farmingRoleMapper.insertSelective(farmingRole);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return farmingMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(Farming farming) {
        try {
            farmingMapper.updateByPrimaryKeySelective(farming);
            if (farming.getRoleList() != null && !farming.getRoleList().isEmpty()){
                farmingRoleMapper.deleteByFarmingId(farming.getId());
                FarmingRole farmingRole = new FarmingRole();
                farmingRole.setFarmingId(farming.getId());
                for (Role role : farming.getRoleList()) {
                    farmingRole.setRoleId(role.getId());
                    farmingRoleMapper.insertSelective(farmingRole);
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<Farming> getFarmingList(Integer planYearId,String farmingName, FarmingTypeEnum type) {
        return farmingMapper.getFarmingList(planYearId,farmingName,type);
    }

    @Override
    public boolean updateSequExecute(Integer id, boolean sequExecute) {
        return farmingMapper.updateSequExecute(id,sequExecute)==1;
    }
}
