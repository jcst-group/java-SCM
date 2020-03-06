package com.nongxin.terminal.util.wind;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author clover
 * @date 2019/11/9
 * @description
 */
public class WindTest {

    public static void main(String[] args){
        List<SpeedAndDirect> sad = new ArrayList<>();
        sad.add(SpeedAndDirect.newInstance(0d,45d));
        sad.add(SpeedAndDirect.newInstance(0d,45d));
        sad.add(SpeedAndDirect.newInstance(1.7,270d));
        sad.add(SpeedAndDirect.newInstance(0d,22.5));
        sad.add(SpeedAndDirect.newInstance(0d,337.5));
        sad.add(SpeedAndDirect.newInstance(0d,337.5));
        sad.add(SpeedAndDirect.newInstance(0d,337.5));
        sad.add(SpeedAndDirect.newInstance(0.2,270d));
        sad.add(SpeedAndDirect.newInstance(1.3,247.5));
        sad.add(SpeedAndDirect.newInstance(2d,270d));
        Map<String, Map<Integer, Double>> stringMapMap = WindSpeedUtil.calSpeed(sad);
        System.out.println("xxx:"+stringMapMap);
        Map<String, Double> stringDoubleMap = WindSpeedUtil.calDirectBySad(sad);
        System.out.println("xx:"+stringDoubleMap);

    }
}
