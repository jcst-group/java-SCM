package com.nongxin.terminal.dao.batch;

import com.nongxin.terminal.entity.batch.ProItem;

public interface ProItemMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByProBathId(Integer proBatchId);

    int insert(ProItem record);

    int insertSelective(ProItem record);

    ProItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProItem record);

    int updateByPrimaryKey(ProItem record);

    int selectByinitproBatchId(Integer initproBatchId);
}