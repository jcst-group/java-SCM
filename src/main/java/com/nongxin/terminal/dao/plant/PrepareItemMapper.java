package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.PrepareItem;
import com.nongxin.terminal.vo.workorder.BudgetVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrepareItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PrepareItem record);

    int insertSelective(PrepareItem record);

    PrepareItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PrepareItem record);

    int updateByPrimaryKey(PrepareItem record);

    List<PrepareItem> getPrepareItem(@Param("batchId") Integer batchId,@Param("year") String year);

    int deleteByBatchId(Integer batchId);

    List<BudgetVo> getBudgetByBatchIds(@Param("batchIds")int[] batchIds);
}