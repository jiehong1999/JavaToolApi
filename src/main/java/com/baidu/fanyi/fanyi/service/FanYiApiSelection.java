package com.baidu.fanyi.fanyi.service;


import com.baidu.fanyi.fanyi.entity.FanYiList;
import com.baidu.fanyi.fanyi.thread.FabYiSelectionThread;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class FanYiApiSelection{
    public Object SelectionMap(String val, String from,List<String> toList) throws RuntimeException{
        List<Object> list=new ArrayList<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0;i<toList.size();i++){
            try {
                Object oj=exec.submit(new FabYiSelectionThread(val,from,toList.get(i))).get();
                if(oj!=null){
                    list.add(oj);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        exec.shutdown();
        System.out.println(list);
       return list;
    }
}
