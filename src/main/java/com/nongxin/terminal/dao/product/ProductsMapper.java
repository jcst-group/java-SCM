package com.nongxin.terminal.dao.product;

import com.nongxin.terminal.entity.product.Products;

import java.util.List;

public interface ProductsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Products record);

    int insertSelective(Products record);

    Products selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Products record);

    int updateByPrimaryKey(Products record);

    List<Products> getProductsByCropId(Integer cropId);
}