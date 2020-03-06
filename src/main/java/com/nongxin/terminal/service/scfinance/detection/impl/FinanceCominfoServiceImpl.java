package com.nongxin.terminal.service.scfinance.detection.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nongxin.terminal.dao.address.AddressMapper;
import com.nongxin.terminal.dao.scfinance.detection.FinanceCominfoMapper;
import com.nongxin.terminal.entity.address.Address;
import com.nongxin.terminal.entity.scfinance.detection.FinanceCominfo;
import com.nongxin.terminal.service.scfinance.detection.IFinanceCominfoService;
import com.nongxin.terminal.util.enumUtil.common.AddressRelateTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clover
 * @since 2019-12-10
 */
@Service
public class FinanceCominfoServiceImpl extends ServiceImpl<FinanceCominfoMapper, FinanceCominfo> implements IFinanceCominfoService {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private FinanceCominfoMapper financeCominfoMapper;

    @Override
    public boolean saveOrUpdate(@RequestBody  FinanceCominfo entity) {
        boolean save = super.saveOrUpdate(entity);

        Address address = entity.getAddress();
        if(address!=null){
            address.setRelateId(entity.getId());
            address.setRelateType(AddressRelateTypeEnum.COMPANY_ADDRESS);

            int i = addressMapper.deleteAddress(entity.getId(), AddressRelateTypeEnum.COMPANY_ADDRESS.getValue().toString());
            addressMapper.insertSelective(address);
        }
//        QueryWrapper queryWrapper = new QueryWrapper();
//        queryWrapper.eq("id",entity.getId());
//        FinanceCominfo financeCominfo = financeCominfoMapper.queryFinanceCominfo(queryWrapper);

        return save;
    }


}
