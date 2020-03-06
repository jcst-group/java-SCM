package com.nongxin.terminal.dao.base;

import com.nongxin.terminal.entity.base.Lot;
import com.nongxin.terminal.vo.lookboard.LotTwoVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface LotMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Lot record);

    int insertSelective(Lot record);

    Lot selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Lot record);

    int updateByPrimaryKey(Lot record);

    List<Lot> getLotList(@Param("baseId")Integer baseId);

    List<Lot> getIdAndNameByBaseId(@Param("baseId")Integer baseId);

    BigDecimal getAcreageSum(Integer batchId);

    List<Lot> getLotByBatchId(Integer batchId);

    Lot getIdAndNameById(Integer id);

    List<Lot> getLotListInBoard(Integer baseId);

    List<Lot> getLotInfoInBoard(Integer lotId);

    LotTwoVo getLotInBoard(Integer lotId);

    List<Lot> selectByOrderId(Integer orderId);

    List<Lot> selectByBaseIdAndYear(@Param("baseId")Integer baseId,@Param("year")Integer year,@Param("batchId")Integer batchId);

    Integer getBaseId(@Param("id")Integer id);
}