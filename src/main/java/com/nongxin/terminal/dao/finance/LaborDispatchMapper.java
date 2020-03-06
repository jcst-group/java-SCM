package com.nongxin.terminal.dao.finance;

import com.nongxin.terminal.entity.finance.LaborDispatch;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface LaborDispatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LaborDispatch record);

    int insertSelective(LaborDispatch record);

    LaborDispatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LaborDispatch record);

    int updateByPrimaryKey(LaborDispatch record);

    List<LaborDispatch> getLaborDispatch(@Param("yearId") Integer yearId);

    Map<String,Object> getBoardLaborDispatch();

}