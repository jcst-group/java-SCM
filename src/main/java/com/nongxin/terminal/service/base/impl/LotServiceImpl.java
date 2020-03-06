package com.nongxin.terminal.service.base.impl;

import com.nongxin.terminal.dao.base.BaseInfoMapper;
import com.nongxin.terminal.dao.base.LotMapper;
import com.nongxin.terminal.entity.base.Lot;
import com.nongxin.terminal.service.base.LotService;
import com.nongxin.terminal.vo.lookboard.LotTwoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class LotServiceImpl implements LotService {

    @Autowired(required = false)
    private LotMapper lotMapper;
    @Autowired
    private BaseInfoMapper baseInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(Lot lot) {
        try {
            int count = lotMapper.insertSelective(lot);
            baseInfoMapper.updateAcreage(lot.getBaseId());
            return count==1;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        Integer baseId = lotMapper.getBaseId(id);
        int count = lotMapper.deleteByPrimaryKey(id);
        baseInfoMapper.updateAcreage(baseId);
        return count==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(Lot lot) {
        try {
            int count = lotMapper.updateByPrimaryKeySelective(lot);
            baseInfoMapper.updateAcreage(lot.getBaseId());
            return count==1;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<Lot> getLotList(Integer baseId) {
        return lotMapper.getLotList(baseId);
    }

    @Override
    public List<Lot> getIdAndNameByBaseId(Integer baseId) {
        return lotMapper.getIdAndNameByBaseId(baseId);
    }

    @Override
    public Lot selectByPrimaryKey(Integer id) {
        return lotMapper.selectByPrimaryKey(id);
    }

    @Override
    public LotTwoVo getLotInBoard(Integer lotId) {
        return lotMapper.getLotInBoard(lotId);
    }

}
