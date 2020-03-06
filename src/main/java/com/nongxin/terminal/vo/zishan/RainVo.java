package com.nongxin.terminal.vo.zishan;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RainVo {

    private Integer equipmentId;

    private List<String> day;

    private List<String> month;

    private List<String> year;

}
