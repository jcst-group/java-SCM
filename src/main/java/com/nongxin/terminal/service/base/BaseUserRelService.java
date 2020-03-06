package com.nongxin.terminal.service.base;

import com.nongxin.terminal.entity.base.BaseUserRel;

import java.util.List;

public interface BaseUserRelService {

    boolean add(BaseUserRel baseUserRel);

    boolean delete(Integer baseId);

    List<BaseUserRel> getBaseUserList(String baseName,String userName);

    boolean selectByBaseId(Integer baseId);

}
