package com.baidu.fanyi.fanyi.service;

import com.baidu.fanyi.fanyi.common.GetVal;
import com.baidu.fanyi.fanyi.common.Results;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class FanYiApiSelection {

    public Object Selection(String val,String from,List<String> toList) {
            Gson gson = new Gson();
            LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
            try {
                map = gson.fromJson(val, map.getClass());
            } catch (RuntimeException e) {
                return new Results<Object>(450, e.getMessage(), "翻译格式为Map", null);
            }
            LinkedHashMap<String, String> resmap = new LinkedHashMap<String, String>();

            for (Map.Entry<String, String> entry : map.entrySet()) {
                resmap.put(entry.getKey(), GetVal.resVal(entry.getKey(),from,"en"));
            }

        return null;
    }
}
