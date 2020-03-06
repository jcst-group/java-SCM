package com.nongxin.terminal.service.company;

import com.nongxin.terminal.entity.company.CompanyInfo;

import java.util.List;

public interface CompanyInfoService {

    boolean insertSelective(CompanyInfo record);

    boolean updateByPrimaryKeySelective(CompanyInfo record);

    boolean deleteByPrimaryKey(Integer id);

    CompanyInfo selectByPrimaryKey(Integer id);

    List<CompanyInfo> getCompanyInfoList(CompanyInfo companyInfo);

    List<CompanyInfo> getCompanyInfo();

    String getShopUrl();
}

