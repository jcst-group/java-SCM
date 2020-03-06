package com.nongxin.terminal.service.scfinance.bank;

import com.nongxin.terminal.dao.base.LotMapper;
import com.nongxin.terminal.dao.crop.CropBatchMapper;
import com.nongxin.terminal.dao.plant.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankLoanService {

    @Autowired(required = false)
    private WorkOrderMapper workOrderMapper;
    @Autowired(required = false)
    private PrepareItemMapper prepareItemMapper;
    @Autowired(required = false)
    private FarmingMapper farmingMapper;
    @Autowired(required = false)
    private CropBatchMapper cropBatchMapper;
    @Autowired(required = false)
    private LotMapper lotMapper;
    @Autowired(required = false)
    private OrderRoleMapper orderRoleMapper;
    @Autowired(required = false)
    private DeviceActMapper deviceActMapper;
    @Autowired(required = false)
    private MaterialActMapper materialActMapper;
    @Autowired(required = false)
    private PersonnelActMapper personnelActMapper;
    @Autowired(required = false)
    private FarmingBatchRelMapper farmingBatchRelMapper;
    @Autowired(required = false)
    private OrderContentMapper orderContentMapper;


    //public List<>

}
