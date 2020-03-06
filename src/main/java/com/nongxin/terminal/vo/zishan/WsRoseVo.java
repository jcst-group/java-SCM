package com.nongxin.terminal.vo.zishan;

import lombok.Data;

import java.util.List;

@Data
public class WsRoseVo {

    private Integer equipmentId;

    private List<AngleVo> day;

    private List<AngleVo> month;

    private List<AngleVo> year;
}
