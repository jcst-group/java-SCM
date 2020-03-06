package com.nongxin.terminal.vo.zishan;

import lombok.Data;

import java.util.List;

@Data
public class AngleVo {

    private String w_angle;

    private List<WsGradeVo> grade;

    @Override
    public String toString() {
        return "AngleVo{" +
                "w_angle='" + w_angle + '\'' +
                ", grade=" + grade +
                '}';
    }
}
