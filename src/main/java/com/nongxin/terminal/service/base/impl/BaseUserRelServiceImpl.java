package com.nongxin.terminal.service.base.impl;

import com.nongxin.terminal.dao.base.BaseUserRelMapper;
import com.nongxin.terminal.entity.base.BaseUserRel;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.service.base.BaseUserRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class BaseUserRelServiceImpl implements BaseUserRelService {

    @Autowired(required = false)
    private BaseUserRelMapper baseUserRelMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(BaseUserRel baseUserRel) {
        try {
            baseUserRelMapper.deleteByBaseId(baseUserRel.getBaseId());
            for (User user : baseUserRel.getUserList()){
                baseUserRel.setUserId(user.getUid());
                baseUserRelMapper.insertSelective(baseUserRel);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public boolean delete(Integer baseId) {
        return baseUserRelMapper.deleteByBaseId(baseId)>0;
    }

    @Override
    public List<BaseUserRel> getBaseUserList(String baseName, String userName) {
        return baseUserRelMapper.getBaseUserRelList(baseName,userName);
    }

    @Override
    public boolean selectByBaseId(Integer baseId) {
        return baseUserRelMapper.selectByBaseId(baseId)>0;
    }
}
