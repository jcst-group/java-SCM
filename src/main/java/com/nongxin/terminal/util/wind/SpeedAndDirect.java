package com.nongxin.terminal.util.wind;

import io.swagger.models.auth.In;

/**
 * @author clover
 * @date 2019/11/8
 * @description
 */
public class SpeedAndDirect {
    /**
     * 风速等级
     */
    private Integer speed;
    /**
     *风向
     */
    private String direct;

    public static SpeedAndDirect newInstance(Double speedNum, Double directNum) {

        if(speedNum!=null&&directNum!=null) {
            Integer speed = WindSpeedUtil.fitSpeed(speedNum);
            String direct = WindSpeedUtil.fitDirect(directNum);
            return new SpeedAndDirect(speed, direct);
        }else{
            Integer speed = 0;
            String direct = "0";
            return new SpeedAndDirect(speed, direct);
        }
    }

    public SpeedAndDirect(Integer speed, String direct) {
        this.speed = speed;
        this.direct = direct;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    @Override
    public String toString() {
        return "SpeedAndDirect{" +
                "speed=" + speed +
                ", direct='" + direct + '\'' +
                '}';
    }
}
