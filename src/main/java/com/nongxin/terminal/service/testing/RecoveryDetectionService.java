package com.nongxin.terminal.service.testing;

import com.nongxin.terminal.entity.testing.RecoveryDetection;
import com.nongxin.terminal.entity.testing.SeedDetection;

import java.util.Date;
import java.util.List;

public interface RecoveryDetectionService {

    boolean add(RecoveryDetection recoveryDetection);

    boolean delete(Integer id);

    boolean update(RecoveryDetection recoveryDetection);

    List<RecoveryDetection> getRecoveryDetection(Integer planId,Date startTime, Date endTime);

}
