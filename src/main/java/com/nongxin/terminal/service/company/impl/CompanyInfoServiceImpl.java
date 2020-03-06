package com.nongxin.terminal.service.company.impl;

import com.nongxin.terminal.dao.company.CompanyInfoMapper;
import com.nongxin.terminal.entity.company.CompanyInfo;
import com.nongxin.terminal.service.company.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService  {

    @Autowired
    private CompanyInfoMapper companyInfoDao;

    @Override
    public boolean insertSelective(CompanyInfo record) {
        return companyInfoDao.insertSelective(record) == 1;
    }

    @Override
    public boolean updateByPrimaryKeySelective(CompanyInfo record) {
        return companyInfoDao.updateByPrimaryKeySelective(record) == 1;
    }

    @Override
    public boolean deleteByPrimaryKey(Integer id) {
        return companyInfoDao.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public CompanyInfo selectByPrimaryKey(Integer id) {
        return companyInfoDao.selectByPrimaryKey(id);
    }

    @Override
    public List<CompanyInfo> getCompanyInfoList(CompanyInfo companyInfo) {
        return companyInfoDao.getCompanyInfoList(companyInfo);
    }

    @Override
    public List<CompanyInfo> getCompanyInfo() {
        return companyInfoDao.getCompanyInfo();
    }

    @Override
    public String getShopUrl() {
        return companyInfoDao.getShopUrl();
    }
}
