package com.nongxin.terminal.service.testing;

import com.nongxin.terminal.entity.testing.SeedDetection;

import java.util.Date;
import java.util.List;

public interface SeedDetectionService {

    boolean add(SeedDetection seedDetection);

    boolean delete(Integer id);

    boolean update(SeedDetection seedDetection);

    List<SeedDetection> getSeedDetection(Date startTime,Date endTime,Integer baseId);

}
