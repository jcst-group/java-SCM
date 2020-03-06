package com.nongxin.terminal.dao.file;

import com.nongxin.terminal.entity.file.FileInfo;

public interface FileInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FileInfo record);

    int insertSelective(FileInfo record);

    FileInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FileInfo record);

    int updateByPrimaryKey(FileInfo record);

    FileInfo getOrderFile(Integer orderId);

    FileInfo getVideoCompany(Integer companyId);

    FileInfo getVideoProduct(Integer companyId);

    FileInfo getOrderApply(Integer companyId);

}