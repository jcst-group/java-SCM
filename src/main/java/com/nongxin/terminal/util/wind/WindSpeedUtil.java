package com.nongxin.terminal.util.wind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author clover
 * @date 2019/11/8
 * @description
 */
public  class WindSpeedUtil {

    /**
     * 返回各风向概率
     * 统计各个风向等级的次数
     * 再计算每个风向等级的频率
     * @return
     */
//    public static  Map<String,Double> calDirect(List<Double> directs){
//        Map<String,Integer> persent = new HashMap();
//        int length = directs.size();
//        directs.forEach(e->{
//            String i = fitDirect(e);
//            if(persent.containsKey(i)){
//                Integer per = persent.get(i);
//                per++;
//                persent.put(i,per);
//            }else{
//                persent.put(i,1);
//            }
//        });
//        Map<String,Double> xx = new HashMap<>();
//        xx.entrySet().forEach(x->{
//            xx.put(x.getKey(),x.getValue()/directs.size());
//        });
//        return xx;
//    }

    /**
     * 返回各风向概率
     * 统计各个风向等级的次数
     * 再计算每个风向等级的频率
     * @return
     */
    public static  Map<String,Double> calDirectBySad(List<SpeedAndDirect> speeds){
        Map<String, Long> collect = speeds.stream().collect(Collectors.groupingBy(SpeedAndDirect::getDirect, Collectors.counting()));
        int length = speeds.size();
        Map<String,Double> xx = new HashMap<>();
        collect.entrySet().forEach(x->{
            double dv = new Double(x.getValue().intValue())/new Double(length);
            xx.put(x.getKey(),dv);
        });
        return xx;
    }

    /**
     * 根据传入的speed，计算每个方向不同风速的概率
     * @param speeds
     * @return
     */
    public static Map<String,Map<Integer,Double>> calSpeed(List<SpeedAndDirect> speeds){
        Map<String,Map<Integer,Double>> xx = new HashMap<>();
        WindDirectEnum[] values = WindDirectEnum.values();
        Integer length = speeds.size();
        //将风向风速数据按风向分组
        Map<String,List<SpeedAndDirect>> sameDirects = speeds.stream().collect(Collectors.groupingBy(SpeedAndDirect::getDirect));
        //System.out.println(sameDirects);
        //计算每个风向分组的每个风速概率
        //Map<风向，Map<风速等级，概率>>
        Map<String,Map<Integer,Double>> mymap = new HashMap<>();
        for (WindDirectEnum windDirectEnum : values) {
            String windDirectLevel = windDirectEnum.getWindDirectLevel();
            List<SpeedAndDirect> speedAndDirects = sameDirects.get(windDirectLevel);
            if(speedAndDirects!=null){
//                System.out.println(speedAndDirects);
                Map<Integer, Long> collect = speedAndDirects.stream().collect(Collectors.groupingBy(SpeedAndDirect::getSpeed, Collectors.counting()));
                Map<Integer,Double> xxx = new HashMap<>();
                collect.entrySet().forEach(x->{
                    double dv = new Double(x.getValue().intValue())/new Double(length);
                    xxx.put(x.getKey(),dv);
                });
                mymap.put(windDirectLevel,xxx);
            }
        }
//        List<Map<Integer, Long>> collect = sameDirects.values().stream()
//                .map(x -> x.stream().collect(Collectors.groupingBy(SpeedAndDirect::getSpeed, Collectors.counting())))
//                .collect(Collectors.toList());
//        System.out.println(collect);
        /*for(WindDirectEnum e:values){


            //将该方向的所有风速取出
            for(SpeedAndDirect spd: speeds){
                if(spd.direct.equals(e.getWindDirectLevel())){
                    sameDirects.add(spd);
                }
            }

        }*/


        return mymap;
    }


    public static String fitDirect(Double data){
        WindDirectEnum[] values = WindDirectEnum.values();
        for(int i=0;i<values.length;i++){
            WindDirectEnum value = values[i];
            if(value.getStartArea()<data && data< value.getEndArea()){
                return value.getWindDirectLevel();
            }
        }
        return values[0].getWindDirectLevel();
    }

    public static Integer fitSpeed(Double data){
        WindSpeedEnum[] values = WindSpeedEnum.values();
        for(int i=0;i<values.length;i++){
            WindSpeedEnum value = values[i];
            if(value.getStartArea()<=data && data<=value.getEndArea()){
                //System.out.println(data + ":" + value.getWindSpeedLevel());
                //System.out.println(value);
                return value.getWindSpeedLevel();
            }
        }
        return 0;
    }
}
