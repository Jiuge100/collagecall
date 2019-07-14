package com.example.collagecall.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;


import java.io.IOException;

public class GetOpenid {
    //从微信后台获得
    private static final String APPID = "wxdbae4ce3bd120f76";
    private static final String APPSECRET="58887d7db07450942761accef02ae903";

    //向微信后台发起请求获取openid的url
    private static final String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?" +
            "appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    public static String getOpenId(String code){

        System.out.println("code="+code);

        //替换链接中的参数
        String requestUrl = WX_URL.replace("APPID",APPID)
                .replace("SECRET",APPSECRET).replace("JSCODE",code);
        System.out.println(requestUrl);

        //调用get方法发起get请求，并把返回值赋值给returnValue
        HttpClient client = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(requestUrl);
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        String returnValue = null;
        try {
            returnValue = client.execute(httpget, responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //将返回内容封装成json
        JSONObject value = (JSONObject) JSON.parse(returnValue);
        String openId = "";
        try{
            System.out.println("返回的结果："+value.toJSONString());
            //获取openId
            openId = value.get("openid").toString();
        }catch (Exception e){
            System.out.println("返回结果为空");
        }

        return openId;
    }



}
