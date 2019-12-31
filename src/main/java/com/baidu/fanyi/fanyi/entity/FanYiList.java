package com.baidu.fanyi.fanyi.entity;


import java.util.LinkedHashMap;
import java.util.List;


public class FanYiList {
    private String name;
    private Object MapData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getMapData() {
        return MapData;
    }

    public void setMapData(Object mapData) {
        MapData = mapData;
    }

    public FanYiList(String name, Object mapData) {
        this.name = name;
        MapData = mapData;
    }
    public FanYiList() {

    }
}
