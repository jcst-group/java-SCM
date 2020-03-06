package com.nongxin.terminal.vo.detection;

import com.nongxin.terminal.entity.common.Unit;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetectionRelVo {

    private String item;

    private BigDecimal minValue;

    private BigDecimal maxValue;

    private BigDecimal value;

    private String detectionTime;

    private Unit unit;

}
