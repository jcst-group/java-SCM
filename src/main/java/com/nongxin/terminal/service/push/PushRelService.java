package com.nongxin.terminal.service.push;

import com.nongxin.terminal.entity.push.PushRel;

public interface PushRelService {

    boolean insertSelective(PushRel record);

    boolean deleteByUidAndCid(PushRel record);

    PushRel isExist(PushRel record);

}
