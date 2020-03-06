package com.nongxin.terminal.service.finance;

import com.nongxin.terminal.entity.finance.FertilizerDeliver;
import com.nongxin.terminal.support.BaseException;

import java.util.List;

public interface FertilizerDeliverService {

    boolean add(FertilizerDeliver fertilizerDeliver) throws BaseException;

    boolean delete(Integer id);

    boolean update(FertilizerDeliver fertilizerDeliver) throws BaseException;

    List<FertilizerDeliver> getFertilizerDeliverList(Integer fertilizerId);

}
