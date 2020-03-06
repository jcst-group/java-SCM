package com.nongxin.terminal.service.base;

import com.nongxin.terminal.entity.base.Lot;
import com.nongxin.terminal.vo.lookboard.LotTwoVo;

import java.util.List;

public interface LotService {

    boolean add(Lot lot);

    boolean delete(Integer id);

    boolean update(Lot lot);

    List<Lot> getLotList(Integer baseId);

    List<Lot> getIdAndNameByBaseId(Integer baseId);

    Lot selectByPrimaryKey(Integer id);

    LotTwoVo getLotInBoard(Integer lotId);

}
