package com.nongxin.terminal.dao.base;

import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.util.enumUtil.base.BaseTypeEnum;
import com.nongxin.terminal.util.enumUtil.base.CategoryEnum;
import com.nongxin.terminal.vo.TreeNodeVo;
import com.nongxin.terminal.vo.lookboard.BaseInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BaseInfo record);

    int insertSelective(BaseInfo record);

    BaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BaseInfo record);

    int updateByPrimaryKey(BaseInfo record);

    List<BaseInfo> getBaseInfoList(BaseInfo baseInfo);

    //获取所有基地
    List<BaseInfo> getAllBaseInfo(@Param("category")CategoryEnum category, @Param("baseType")BaseTypeEnum baseType, @Param("baseName")String baseName);

    //根据基地类型查询基地
    List<BaseInfo> getBaseByType(Integer baseType);

    BaseInfo getIdAndName(Integer id);

    //获取无用户的基地
    List<BaseInfo> getBaseWithoutUser();

    BaseInfoVo getBaseInfoById(Integer baseId);

    BaseInfoVo getBaseLotInfoById(Integer baseId);

    BaseInfo getBaseById(Integer id);

    List<Map<String,Object>> getBaseByUid(Integer uid);

    String getBaseName(Integer id);

    List<TreeNodeVo> getBaseTreeByUid(Integer uid);

    List<BaseInfo> getBaseEquipment();

    int updateAcreage(@Param("baseId")Integer baseId);

    List<Map<String,Object>> getBaseByUidAndEqui(Integer uid);
}