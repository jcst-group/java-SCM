package com.nongxin.terminal.dao.product;

import com.nongxin.terminal.entity.product.ProLevelRel;

public interface ProLevelRelMapper {
    int deleteByPrimaryKey(Integer productsId);

    int insert(ProLevelRel record);

    int insertSelective(ProLevelRel record);

    ProLevelRel selectByPrimaryKey(Integer productsId);

    int updateByPrimaryKeySelective(ProLevelRel record);

    int updateByPrimaryKey(ProLevelRel record);
}