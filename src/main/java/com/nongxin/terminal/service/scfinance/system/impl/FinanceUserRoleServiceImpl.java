package com.nongxin.terminal.service.scfinance.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nongxin.terminal.dao.scfinance.system.FinanceUserRoleMapper;
import com.nongxin.terminal.entity.scfinance.insurance.FinanceUserRole;
import com.nongxin.terminal.entity.scfinance.system.FinanceRole;
import com.nongxin.terminal.entity.scfinance.system.FinanceUser;
import com.nongxin.terminal.service.scfinance.system.IFinanceUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clover
 * @since 2019-12-27
 */
@Service
public class FinanceUserRoleServiceImpl extends ServiceImpl<FinanceUserRoleMapper, FinanceUserRole> implements IFinanceUserRoleService {


    @Autowired
    private FinanceUserRoleMapper financeUserRoleMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean addRoleToUser(FinanceUser user) {
        try {

            QueryWrapper deleteWrapper = new QueryWrapper();
            deleteWrapper.eq("user_id",user.getId());
            financeUserRoleMapper.delete(deleteWrapper);
            List<FinanceRole> financeRoles = user.getFinanceRoles();
            for (FinanceRole role : financeRoles){
                FinanceUserRole userRole = new FinanceUserRole();
                userRole.setRoleId(role.getId());
                userRole.setUserId(user.getId());
                financeUserRoleMapper.insert(userRole);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }
}
