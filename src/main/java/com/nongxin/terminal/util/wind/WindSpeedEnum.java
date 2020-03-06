package com.nongxin.terminal.util.wind;

public enum WindSpeedEnum {
    ZERO(0,0,0.2),
    ONE(1,0.3,1.5),
    TWO(2,1.6,3.3),
    THREE(3,3.4,10);
    private int windSpeedLevel;
    private double startArea;
    private double endArea;

    WindSpeedEnum(int windSpeedLevel, double startArea, double endArea) {
        this.windSpeedLevel = windSpeedLevel;
        this.startArea = startArea;
        this.endArea = endArea;
    }

    public int getWindSpeedLevel() {
        return windSpeedLevel;
    }

    public void setWindSpeedLevel(int windSpeedLevel) {
        this.windSpeedLevel = windSpeedLevel;
    }

    public double getStartArea() {
        return startArea;
    }

    public void setStartArea(double startArea) {
        this.startArea = startArea;
    }

    public double getEndArea() {
        return endArea;
    }

    public void setEndArea(double endArea) {
        this.endArea = endArea;
    }


}
