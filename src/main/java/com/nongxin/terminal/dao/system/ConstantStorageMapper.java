package com.nongxin.terminal.dao.system;

import com.nongxin.terminal.entity.system.ConstantStorage;
import com.nongxin.terminal.util.enumUtil.system.ConstantTypeEnum;
import org.apache.ibatis.annotations.Param;

public interface ConstantStorageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConstantStorage record);

    int insertSelective(ConstantStorage record);

    ConstantStorage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConstantStorage record);

    int updateByPrimaryKey(ConstantStorage record);

    ConstantStorage selectByType(@Param("type") ConstantTypeEnum type);
}