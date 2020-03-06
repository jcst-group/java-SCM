package com.nongxin.terminal.service.system.impl;

import com.nongxin.terminal.dao.system.FamilyMemberMapper;
import com.nongxin.terminal.entity.system.FamilyMenber;
import com.nongxin.terminal.service.system.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyMemberServiceImpl implements FamilyMemberService {

    @Autowired(required = false)
    private FamilyMemberMapper familyMemberMapper;

    @Override
    public boolean add(FamilyMenber familyMenber) {
        return familyMemberMapper.insertSelective(familyMenber)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return familyMemberMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(FamilyMenber familyMenber) {
        return familyMemberMapper.updateByPrimaryKeySelective(familyMenber)==1;
    }

    @Override
    public List<FamilyMenber> getFamilyMemberByUid(Integer uid) {
        return familyMemberMapper.getFamilyMenberByUid(uid);
    }
}
