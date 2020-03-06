package com.nongxin.terminal.dao.product;

import com.nongxin.terminal.entity.product.Level;

import java.util.List;

public interface LevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);

    List<Level> getLevelByProductId(Integer productId);
}