package com.nongxin.terminal.dao.finance;

import com.nongxin.terminal.entity.finance.StandardPlan;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StandardPlanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StandardPlan record);

    int insertSelective(StandardPlan record);

    StandardPlan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StandardPlan record);

    int updateByPrimaryKey(StandardPlan record);

    List<StandardPlan> getStandardPlan(@Param("yearId")Integer yearId);

    //查询某年某个基地对应数据条数
    int getCount(@Param("baseId")Integer baseId,@Param("yearId")Integer yearId,@Param("id")Integer id);

    Map<String,Object> getBoardStandardPlan(@Param("baseId")Integer baseId);

}