package com.nongxin.terminal.dao.company;

import com.nongxin.terminal.entity.company.CompanyInfo;

import java.util.List;

public interface CompanyInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    CompanyInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);

    List<CompanyInfo> getCompanyInfoList(CompanyInfo record);

    List<CompanyInfo> getCompanyInfo();

    String getShopUrl();
}