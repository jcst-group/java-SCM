package com.nongxin.terminal.util.wind;

/**
 * @author clover
 * @date 2019/11/8
 * @description
 */
public enum  WindDirectEnum {
    N(1,"N",348.76,11.25),
    NNE(2,"NNE",11.26,33.75),
    NE(3,"NE",33.76,56.25),
    ENE(4,"ENE",56.26,78.75),
    E(5,"E",78.76,101.25),
    ESE(6,"ESE",101.26,123.75),
    SE(7,"SE",123.76,146.25),
    SSE(8,"SSE",146.26,168.75),
    S(9,"S",168.76,191.25),
    SSW(10,"SSW",191.26,213.75),
    SW(11,"SW",213.76,236.25),
    WSW(12,"WSW",236.26,258.75),
    W(13,"W",258.76,281.25),
    WNW(14,"WNW",281.76,303.75),
    NW(15,"NW",303.76,326.25),
    NNW(16,"NNW",326.26,348.75);
    WindDirectEnum(Integer id,String windDirectLevel, double startArea, double endArea) {
        this.id = id;
        this.windDirectLevel = windDirectLevel;
        this.startArea = startArea;
        this.endArea = endArea;
    }

    public static String getbycode(int index) {
        for(WindDirectEnum tEnum : values()) {
            if(tEnum.id == index) {
            return tEnum.windDirectLevel;
            }
        }
        return null;
    }

    public static Integer getIndex(String windDirectLevel){
        for(WindDirectEnum tEnum : values()) {
            if(tEnum.windDirectLevel== windDirectLevel) {
                return tEnum.id;
            }
        }
        return null;
    }
    public String getWindDirectLevel() {
        return windDirectLevel;
    }

    public void setWindDirectLevel(String windDirectLevel) {
        this.windDirectLevel = windDirectLevel;
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

    private Integer id;
    private String windDirectLevel;
    private double startArea;
    private double endArea;
}
