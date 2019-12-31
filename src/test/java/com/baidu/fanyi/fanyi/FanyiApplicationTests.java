package com.baidu.fanyi.fanyi;

import com.baidu.fanyi.fanyi.entity.FanYiList;
import com.baidu.fanyi.fanyi.service.FanYiApiSelection;
import com.baidu.fanyi.fanyi.thread.FabYiSelectionThread;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootTest
class FanyiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private FanYiApiSelection selections=new FanYiApiSelection();
    @Test
    void testFanyi(){
        String val="{ \"请输入手机号\":\"请输入手机号\",\n" +
                "    \"请输入密码\":\"请输入密码\",\n" +
                "    \"忘记密码？\":\"忘记密码？\",\n" +
                "    \"手机号\":\"手机号\",\n" +
                "    \"图片验证码\":\"图片验证码\",\n" +
                "    \"请输入验证码\":\"请输入验证码\",\n" +
                "    \"验证码\":\"验证码\",\n" +
                "    \"登陆密码\":\"登陆密码\",\n" +
                "    \"请输入登陆密码\":\"请输入登陆密码\",\n" +
                "    \"确认密码\":\"确认密码\",\n" +
                "    \"请输入确认密码\":\"请输入确认密码\",\n" +
                "    \"邀请码\":\"邀请码\",\n" +
                "    \"请输入邀请码\":\"请输入邀请码\",\n" +
                "    \"获取验证码\":\"获取验证码\",\n" +
                "    \"登陆\":\"登陆\",\n" +
                "    \"注册\":\"注册\",\n" +
                "    \"手机号码有误\":\"手机号码有误\",\n" +
                "    \"请输入图形验证码\":\"请输入图形验证码\",\n" +
                "    \"两个密码不一致\":\"两个密码不一致\"}";
        List<String>toList=new ArrayList<>();
        toList.add("jp");
        toList.add("en");


        ArrayList<Future<Object>> results = new ArrayList<Future<Object>>();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0;i<toList.size();i++){
//            FabYiSelectionThread td = new FabYiSelectionThread(val,from,toList.get(i));
            results.add(exec.submit(new FabYiSelectionThread(val,"zh",toList.get(i))));

        }
         System.out.println(results);


    }
}
