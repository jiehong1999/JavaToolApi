package com.baidu.fanyi.fanyi.controllerApi;

import com.baidu.fanyi.fanyi.common.GetVal;

import com.baidu.fanyi.fanyi.common.Results;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.xml.transform.Result;
import java.util.*;

@Controller
public class FanYiController {
    @RequestMapping(value="/fanYiApi",method= RequestMethod.POST)
    @ResponseBody
    public Object fanYiApi(
            @RequestParam(value="val",required =false)String val
            ,@RequestParam(value="from",required = false)String from
            ,@RequestParam(value="to",required = false)String to){
        try {
            return new Results<Object>(GetVal.resVal(val,from,to));
        }catch (RuntimeException e){
            return new Results<Object>(500,"失败","系统异常",null);
        }
    }

    @RequestMapping(value="/fanYiApiMap",method= RequestMethod.POST)
    @ResponseBody
    public Object fanYiApiMap(
            @RequestParam(value="val",required =false)String val
            ,@RequestParam(value="from",required = false)String from
            ,@RequestParam(value="to",required = false)String to){
        try {
            Gson gson = new Gson();
            LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
            try {
                map = gson.fromJson(val, map.getClass());
            }catch (RuntimeException e){
                return new Results<Object>(450,e.getMessage(),"翻译格式为Map",null);
            }
            LinkedHashMap<String, String> resmap = new LinkedHashMap<String, String>();
            for(Map.Entry<String, String> entry : map.entrySet()){
                resmap.put(entry.getKey(),GetVal.resVal(entry.getKey(),from,to));
            }
            return new Results<Object>(resmap);//转回Map返回数据
        }catch (RuntimeException e){
            return new Results<Object>(500,e.getMessage(),"系统异常",null);
        }
    }
}
