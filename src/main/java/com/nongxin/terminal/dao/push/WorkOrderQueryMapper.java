package com.nongxin.terminal.dao.push;

import com.nongxin.terminal.entity.push.PushRel;
import com.nongxin.terminal.vo.push.CIDVo;

import java.util.List;

public interface WorkOrderQueryMapper {

    List<CIDVo> getUserCid();

    String getFarmingName(Integer id);

    CIDVo getCidByWorkOrderId(Integer id);
}
