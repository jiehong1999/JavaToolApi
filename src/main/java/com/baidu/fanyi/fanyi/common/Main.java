package com.baidu.fanyi.fanyi.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baidu.fanyi.fanyi.common.TransApi;
import com.google.gson.Gson;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.boot.json.JsonParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20191124000360031";
    private static final String SECURITY_KEY = "Y9Px4Wtk0H0fOmAxIsdG";

    public static void main(String[] args) {
//        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
//        String query = "不要";
//        String data =api.getTransResult(query, "auto", "en");
//        JSONObject obj =JSONObject.parseObject(data);
//        JSONArray list=obj.getJSONArray("trans_result");
//        JSONObject dst=(JSONObject)list.get(0);
//        System.out.println(dst.getString("dst"));
    }

}
