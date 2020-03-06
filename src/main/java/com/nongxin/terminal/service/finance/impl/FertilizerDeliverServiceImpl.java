package com.nongxin.terminal.service.finance.impl;

import com.nongxin.terminal.dao.finance.FertilizerDeliverMapper;
import com.nongxin.terminal.dao.finance.FertilizerPurchaseMapper;
import com.nongxin.terminal.entity.finance.FertilizerDeliver;
import com.nongxin.terminal.service.finance.FertilizerDeliverService;
import com.nongxin.terminal.support.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FertilizerDeliverServiceImpl implements FertilizerDeliverService {

    @Autowired(required = false)
    private FertilizerDeliverMapper fertilizerDeliverMapper;
    @Autowired(required = false)
    private FertilizerPurchaseMapper fertilizerPurchaseMapper;

    @Override
    public boolean add(FertilizerDeliver fertilizerDeliver) throws BaseException {
        BigDecimal count = fertilizerDeliverMapper.getCount(fertilizerDeliver.getFertilizerId(),null)==null ? new BigDecimal("0"):fertilizerDeliverMapper.getCount(fertilizerDeliver.getFertilizerId(),null);
        BigDecimal fertilizerNum = fertilizerPurchaseMapper.selectByPrimaryKey(fertilizerDeliver.getFertilizerId()).getTotal();
        if ((count.add(fertilizerDeliver.getPayNum())).compareTo(fertilizerNum)==1){
            throw new BaseException(500,"交付数量不能大于采购总量");
        }
        return fertilizerDeliverMapper.insertSelective(fertilizerDeliver)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return fertilizerDeliverMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(FertilizerDeliver fertilizerDeliver) throws BaseException {
        BigDecimal count = fertilizerDeliverMapper.getCount(fertilizerDeliver.getFertilizerId(),null)==null ? new BigDecimal("0"):fertilizerDeliverMapper.getCount(fertilizerDeliver.getFertilizerId(),null);
        BigDecimal fertilizerNum = fertilizerPurchaseMapper.selectByPrimaryKey(fertilizerDeliver.getFertilizerId()).getTotal();
        if ((count.add(fertilizerDeliver.getPayNum())).compareTo(fertilizerNum)==1){
            throw new BaseException(500,"交付数量不能大于采购总量");
        }
        return fertilizerDeliverMapper.updateByPrimaryKeySelective(fertilizerDeliver)==1;
    }

    @Override
    public List<FertilizerDeliver> getFertilizerDeliverList(Integer fertilizerId) {
        return fertilizerDeliverMapper.getFertilizerDeliver(fertilizerId);
    }
}
