package com.nongxin.terminal.service.traceability;

import com.nongxin.terminal.entity.traceability.TraceAreaCount;
import com.nongxin.terminal.vo.traceability.IpVo;

import java.util.List;

public interface TraceAreaCountService {

    //判断该地级市是否有溯源记录
    boolean isExist(String retroCode,String cityId);

    //新增地区的查询记录
    boolean insert(TraceAreaCount traceAreaCount);

    //更新地级市溯源记录
    boolean updateCount(String retroCode,String cityId);

    //根据追溯码查询各地区的查看次数
    List<TraceAreaCount> getByRetroCode(String retroCode);
}
