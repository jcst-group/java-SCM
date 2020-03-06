package com.nongxin.terminal;

public class Test {

    private static final String[] directArr = new String[] { "N", "NNE", "NE", "ENE", "E", "ESE",
            "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW" };

    public static void main(String[] args) {
        System.out.println(windDirectionSwitch(330));
    }

    public static String windDirectionSwitch(float degrees) {
        int index = 0;
        if (348.75 <= degrees && degrees <= 360) {
        index = 0;
        } else if (0 <= degrees && degrees <= 11.25) {
        index = 0;
        } else if (11.25 < degrees && degrees <= 33.75) {
        index = 1;
        } else if (33.75 < degrees && degrees <= 56.25) {
        index = 2;
        } else if (56.25 < degrees && degrees <= 78.75) {
        index = 3;
        } else if (78.75 < degrees && degrees <= 101.25) {
        index = 4;
        } else if (101.25 < degrees && degrees <= 123.75) {
        index = 5;
        } else if (123.75 < degrees && degrees <= 146.25) {
        index = 6;
        } else if (146.25 < degrees && degrees <= 168.75) {
        index = 7;
        } else if (168.75 < degrees && degrees <= 191.25) {
       index = 8;
        } else if (191.25 < degrees && degrees <= 213.75) {
        index = 9;
        } else if (213.75 < degrees && degrees <= 236.25) {
        index = 10;
        } else if (236.25 < degrees && degrees <= 258.75) {
        index = 11;
        } else if (258.75 < degrees && degrees <= 281.25) {
        index = 12;
        } else if (281.25 < degrees && degrees <= 303.75) {
        index = 13;
        } else if (303.75 < degrees && degrees <= 326.25) {
        index = 14;
        } else if (326.25 < degrees && degrees < 348.75) {
        index = 15;
        } else {
            System.out.println("degrees[{}] 大于 360.0了"+ degrees);
        }
        return directArr[index];
    }
}
