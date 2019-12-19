package com.baidu.fanyi.fanyi.entity;


import java.util.LinkedHashMap;
import java.util.List;


public class FanYiList {
    private String name;
    private LinkedHashMap<String,String> MapData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedHashMap<String, String> getMapData() {
        return MapData;
    }

    public void setMapData(LinkedHashMap<String, String> mapData) {
        MapData = mapData;
    }

    public FanYiList() {
    }

    public FanYiList(String name, LinkedHashMap<String, String> mapData) {
        this.name = name;
        MapData = mapData;
    }
}
