package com.baidu.fanyi.fanyi.thread;

import com.baidu.fanyi.fanyi.common.GetVal;
import com.baidu.fanyi.fanyi.entity.FanYiList;
import com.google.gson.Gson;

import java.util.*;
import java.util.concurrent.Callable;


public class  FabYiSelectionThread implements Callable<Object> {
    String val;
    String from;
    String to;
    LinkedHashMap<String, String> map = new LinkedHashMap<>();

    public FabYiSelectionThread() {
    }

    //构造函数
    public FabYiSelectionThread(String val, String from, String to) {
        this.val = val;
        this.from = from;
        this.to = to;
        this.map=new Gson().fromJson(val, map.getClass());
    }


    @Override
    public Object call() throws Exception {
        LinkedHashMap<String,String> resmap=new LinkedHashMap();
        try {
            System.out.println(Thread.currentThread().getName() + "启动@" + System.currentTimeMillis());
            //循环便利map
            for(Map.Entry<String, String> entry : map.entrySet()) {
                //将mqp值翻译
                resmap.put(entry.getKey(),GetVal.resVal(entry.getValue(),from,to));
            }
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return resmap;
    }
}
