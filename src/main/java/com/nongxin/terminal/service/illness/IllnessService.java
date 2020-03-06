package com.nongxin.terminal.service.illness;

import com.nongxin.terminal.entity.illness.Illness;

import java.util.List;

public interface IllnessService {

    List<Illness> getAll(String illnessName);

}
