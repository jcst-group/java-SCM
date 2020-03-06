package com.nongxin.terminal.service.plan.impl;

import com.nongxin.terminal.dao.plant.DeviceActMapper;
import com.nongxin.terminal.dao.plant.MaterialActMapper;
import com.nongxin.terminal.dao.plant.PersonnelActMapper;
import com.nongxin.terminal.dao.plant.PrepareItemMapper;
import com.nongxin.terminal.entity.plant.PrepareItem;
import com.nongxin.terminal.service.plan.PrepareItemService;
import com.nongxin.terminal.vo.workorder.BudgetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrepareItemServiceImpl implements PrepareItemService {

    @Autowired(required = false)
    private PrepareItemMapper prepareItemMapper;
    @Autowired(required = false)
    private DeviceActMapper deviceActMapper;
    @Autowired(required = false)
    private MaterialActMapper materialActMapper;
    @Autowired(required = false)
    private PersonnelActMapper personnelActMapper;

    @Override
    public List<PrepareItem> getPrepareItem(Integer batchId,String year) {
        return prepareItemMapper.getPrepareItem(batchId,year);
    }

    @Override
    public List<BudgetVo> getBudgetByBatchIds(int[] batchIds) {
        List<BudgetVo> budgetVoList = prepareItemMapper.getBudgetByBatchIds(batchIds);
        for (BudgetVo budgetVo : budgetVoList) {
            budgetVo.setDeviceActList(deviceActMapper.budgetDeviceAct(batchIds,budgetVo.getFarmingId()));
            budgetVo.setMaterialActList(materialActMapper.budgetMaterialAct(batchIds,budgetVo.getFarmingId()));
            budgetVo.setPersonnelActList(personnelActMapper.budgetPersonnelAct(batchIds,budgetVo.getFarmingId()));
        }
        return budgetVoList;
    }

}
