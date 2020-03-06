package com.nongxin.terminal.dao.system;

import com.nongxin.terminal.entity.system.FamilyMenber;

import java.util.List;

public interface FamilyMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FamilyMenber record);

    int insertSelective(FamilyMenber record);

    FamilyMenber selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FamilyMenber record);

    int updateByPrimaryKey(FamilyMenber record);

    List<FamilyMenber> getFamilyMenberByUid(Integer uid);
}