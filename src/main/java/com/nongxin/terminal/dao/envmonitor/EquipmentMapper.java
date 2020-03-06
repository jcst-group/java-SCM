package com.nongxin.terminal.dao.envmonitor;

import com.nongxin.terminal.entity.envmonitor.Equipment;
import com.nongxin.terminal.vo.lookboard.EquipmentLngVo;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);

    Equipment selectByEquipmentId(String equipmentId);

    Equipment selectByEquipmentIdAndFactoryId(@Param("equipmentId") String equipmentId, @Param("factoryId") Integer factoryId);

    List<Equipment> getEquipmentList(Equipment equipment);

    Integer getFactoryId(Integer id);

    List<Equipment> getEquipmentIdAndNameList();

    Equipment checkId(String equipmentId,String equipmentName);

    String getEquipmentName(Integer id);

    String getBaseName(Integer id);

    int getBaseEquipmentByUid(@Param("uid")Integer uid);

    List<EquipmentLngVo> getEquipmentLng();
}