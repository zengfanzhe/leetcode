package com.coding.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1396_designUndergroundSystem {
    /**
     * case 1 :
     *  in  1 a 0
     * out  1 b 10
     *
     */
    List<Data> dataList = new ArrayList<>();

    public static void main(String[] args) {
        List<Data> dataList = null;
        //case 1:
        dataList = new ArrayList<>();
        dataList.add(new Data("in", 1, "a", 0));
        dataList.add(new Data("out", 1, "b", 10));
        testCase(dataList, "a", "b");

        //case 2:
        dataList = new ArrayList<>();
        dataList.add(new Data("in", 1, "a", 0));
        dataList.add(new Data("out", 1, "b", 10));
        dataList.add(new Data("in", 2, "a", 5));
        dataList.add(new Data("out", 2, "b", 10));
        dataList.add(new Data("in", 1, "a", 11));
        dataList.add(new Data("out", 1, "c", 14));
        dataList.add(new Data("in", 2, "c", 32));
        dataList.add(new Data("out", 2, "b", 34));
        testCase(dataList, "a", "b");
    }

    private static void testCase(List<Data> dataList, String in, String out) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        for (Data data : dataList){
            if(data.type.equals("in")){
                undergroundSystem.checkIn(data.id, data.stationName, data.t);
            }else{
                undergroundSystem.checkOut(data.id, data.stationName, data.t);
            }
        }
        System.out.println("result is " + undergroundSystem.getAverageTime(in, out));
    }
}

class Data{
    public String type;
    public int id;
    public String stationName;
    public int t;

    public Data(String type, int id, String stationName, int t){
        this.type = type;
        this.stationName = stationName;
        this.id = id;
        this.t = t;
    }
}

class UndergroundSystem {
    private Map<String, List<String>> map;
    private Map<Integer, String> tempMap;

    public UndergroundSystem() {
        this.map = new HashMap<>();
        this.tempMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        tempMap.put(id, stationName + "," + t);
    }

    public void checkOut(int id, String stationName, int t) {
        String startInfo = tempMap.get(id);
        String[] info = startInfo.split(",");
        String startStation = info[0];
        String startTime = info[1];
        String key = startStation + "," + stationName;
        List<String> list = map.get(key);
        if(list == null){
            list = new ArrayList<>();
        }
        list.add(startTime + "," + t);
        map.put(key, list);
        tempMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        double result = 0.0;
        String key = startStation + "," + endStation;
        List<String> listInfo = map.get(key);
        for (String info : listInfo) {
            String[] arr = info.split(",");
            result += (Integer.valueOf(arr[1]) - Integer.valueOf(arr[0]));
        }
        return result/listInfo.size();
    }
}
