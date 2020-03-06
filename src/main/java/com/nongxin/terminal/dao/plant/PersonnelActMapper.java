package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.PersonnelAct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonnelActMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonnelAct record);

    int insertSelective(PersonnelAct record);

    PersonnelAct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonnelAct record);

    int updateByPrimaryKey(PersonnelAct record);

    List<PersonnelAct> selectByOrderId(Integer orderId);

    List<PersonnelAct> budgetPersonnelAct(@Param("batchIds")int[] batchIds, @Param("farmingId")Integer farmingId);
}