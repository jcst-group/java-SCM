package com.nongxin.terminal.service.common;

import com.nongxin.terminal.entity.address.Area;

import java.util.List;

public interface AreaService {

    //根据等级获取地区
    List<Area> getAreaByLevel(Integer level);

    //根据父级code查询地区
    List<Area> getAreaByParentCode(String parentCode);

    List<Area> getAreaByName(String name);
}
