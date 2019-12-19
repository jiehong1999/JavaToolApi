package com.baidu.fanyi.fanyi.common;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
public class  GetVal {
    private static final String APP_ID = "20191124000360031";
    private static final String SECURITY_KEY = "Y9Px4Wtk0H0fOmAxIsdG";
    public static String resVal(String val,String from,String to){
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String data =api.getTransResult(val, from, to);
        JSONObject obj =JSONObject.parseObject(data);
        JSONArray list=obj.getJSONArray("trans_result");
        JSONObject dst=(JSONObject)list.get(0);
        return dst.getString("dst");
    }

    public String resVals(String val,String from,String to){
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String data =api.getTransResult(val, from, to);
        JSONObject obj =JSONObject.parseObject(data);
        JSONArray list=obj.getJSONArray("trans_result");
        JSONObject dst=(JSONObject)list.get(0);
        return dst.getString("dst");
    }
}
