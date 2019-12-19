package com.baidu.fanyi.fanyi.service;


import com.baidu.fanyi.fanyi.entity.FanYiList;
import com.baidu.fanyi.fanyi.thread.FabYiSelectionThread;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Service
public class FanYiApiSelection{
    public List<FanYiList> SelectionMap(String val, String from,List<String> toList) throws RuntimeException, InterruptedException, ExecutionException {
        List<FanYiList> list=new ArrayList<>();
        for (int i=0;i<toList.size();i++){
            FabYiSelectionThread td = new FabYiSelectionThread(val,from,toList.get(i));
            FutureTask<Object> result = new FutureTask<Object>(td);
            new Thread(result).start();
            Object sum = result.get();  //FutureTask 可用于 闭锁 类似于CountDownLatch的作用，在所有的线程没有执行完成之后这里是不会执行的
            System.out.println(sum);
            System.out.println("------------------------------------");
        }
       return list;
    }
}
