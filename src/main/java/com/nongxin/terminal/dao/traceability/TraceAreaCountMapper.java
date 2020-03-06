package com.nongxin.terminal.dao.traceability;

import com.nongxin.terminal.entity.traceability.TraceAreaCount;

import java.util.List;

public interface TraceAreaCountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TraceAreaCount record);

    int insertSelective(TraceAreaCount record);

    TraceAreaCount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TraceAreaCount record);

    int updateByPrimaryKey(TraceAreaCount record);

    //更新地级市查询记录
    int updateCount(String retroCode,String cityId);

    //根据追溯码和地级市id查询有无记录
    int getCountByCityId(String retroCode,String cityId);

    //根据追溯码查询各地区的查看次数
    List<TraceAreaCount> getAreaCountByRetroCode(String retroCode);
}