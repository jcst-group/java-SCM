package com.nongxin.terminal.service.testing;

import com.nongxin.terminal.entity.testing.InitproDetection;

import java.util.Date;
import java.util.List;

public interface InitProDetectionService {

    boolean add(InitproDetection initproDetection);

    boolean delete(Integer id);

    boolean update(InitproDetection initproDetection);

    List<InitproDetection> getInitproDetection(Integer planId, Date startTime, Date endTime);

    String getInitDetectionPic(Integer batchId);

}
