package com.nongxin.terminal.service.system;

import com.nongxin.terminal.entity.system.FamilyMenber;

import java.util.List;

public interface FamilyMemberService {

    boolean add(FamilyMenber familyMenber);

    boolean delete(Integer id);

    boolean update(FamilyMenber familyMenber);

    List<FamilyMenber> getFamilyMemberByUid(Integer uid);
}
