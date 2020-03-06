package com.nongxin.terminal.service.plan;

import com.nongxin.terminal.entity.plant.PrepareItem;
import com.nongxin.terminal.vo.workorder.BudgetVo;

import java.util.List;

public interface PrepareItemService {

    List<PrepareItem> getPrepareItem(Integer batchId,String year);

    //预算报表
    List<BudgetVo> getBudgetByBatchIds(int[] batchIds);

}
