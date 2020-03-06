package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.MaterialAct;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MaterialActMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaterialAct record);

    int insertSelective(MaterialAct record);

    MaterialAct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterialAct record);

    int updateByPrimaryKey(MaterialAct record);

    List<MaterialAct> selectByOrderId(Integer orderId);

    //物料预算费用
    List<MaterialAct> budgetMaterialAct(@Param("batchIds")int[] batchIds, @Param("farmingId")Integer farmingId);

    //物料实际费用
    List<Map<String,Object>> getBusinessMaterialAct(Integer batchId);
}