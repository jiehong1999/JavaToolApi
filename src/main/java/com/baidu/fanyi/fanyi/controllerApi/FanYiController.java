package com.baidu.fanyi.fanyi.controllerApi;

import com.baidu.fanyi.fanyi.common.GetVal;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.Map;

@Controller
public class FanYiController{
    @RequestMapping(value="/fanYiApi",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, String> fanYiApi(
            @RequestParam(value="val",required =false)String val
            ,@RequestParam(value="from",required = false)String from
            ,@RequestParam(value="to",required = false)String to){
        try {
            System.out.println(val);
            Gson gson = new Gson();
            Map<String, String> map = new HashMap<String, String>();
            map = gson.fromJson(val, map.getClass());
            Map<String, String> resval = new HashMap<String, String>();
            for(Map.Entry<String,String> item : map.entrySet()){
                item.setValue(GetVal.resVal(item.getValue(),from,to));
                resval.put(item.getKey(),item.getValue());
            }
            return resval;
        }catch (RuntimeException e){
            return null;
        }

    }
    public String langListApi(){
        return "";
    }
}
