package com.nongxin.terminal.vo.zishan;

public class WsGradeVo {

    private String wds_grade;

    private String angle;

    private String wds_fqy;

    private String wdd_fqy;

    public String getWds_grade() {
        return wds_grade;
    }

    public void setWds_grade(String wds_grade) {
        this.wds_grade = wds_grade;
    }

    public String getAngle() {
        return angle;
    }

    public void setAngle(String angle) {
        this.angle = angle;
    }

    public String getWds_fqy() {
        return wds_fqy;
    }

    public void setWds_fqy(String wds_fqy) {
        this.wds_fqy = wds_fqy;
    }

    public String getWdd_fqy() {
        return wdd_fqy;
    }

    public void setWdd_fqy(String wdd_fqy) {
        this.wdd_fqy = wdd_fqy;
    }

    @Override
    public String toString() {
        return "WsGradeVo{" +
                "wds_grade='" + wds_grade + '\'' +
                ", angle='" + angle + '\'' +
                ", wds_fqy='" + wds_fqy + '\'' +
                ", wdd_fqy='" + wdd_fqy + '\'' +
                '}';
    }
}
