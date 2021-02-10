package com.serversys.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.kevinsawicki.http.HttpRequest;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * IntelliJ IDEA.
 *
 * @author 熊志伟
 * 创建时间 2020/11/12 15:53
 * 描述 http请求工具
 */
public class HttpRequestUtil {
    static String HTMLCODE = "<html";
    /**
     *
     * @param url url
     * @param data data
     * @return
     * 来自 https://blog.csdn.net/flymoringbird/article/details/93719672
     */
    public static ResultMessage doGet(String url, Map<String,Object> data,boolean isSet) {
        StringBuilder stringBuilder = new StringBuilder();
        if(data != null && !data.isEmpty()){
            HttpRequest request = HttpRequest.get(url);
            if(isSet){
                //信任所有证书
                request.trustAllCerts();
                //信任所有地址
                request.trustAllHosts();
                //设置请求超时时间
                request.connectTimeout(60000);
                //设置读取超时时间
                request.readTimeout(60000);
            }
            stringBuilder.append(request.form(data).body());
        }else{
            HttpRequest request = HttpRequest.get(url);
            if(isSet){
                //信任所有证书
                request.trustAllCerts();
                //信任所有地址
                request.trustAllHosts();
                //设置请求超时时间
                request.connectTimeout(60000);
                //设置读取超时时间
                request.readTimeout(60000);
            }
            stringBuilder.append(request.body());
        }
        return getResultMessage(stringBuilder);
    }

    /**
     *
     * @param url url
     * @param data data
     * @return
     * 来自 https://blog.csdn.net/flymoringbird/article/details/93719672
     */
    public static ResultMessage doPost(String url, Map<String,Object> data,boolean isSet){
        StringBuilder stringBuilder = new StringBuilder();
        if(data != null && !data.isEmpty()){
            HttpRequest request = HttpRequest.post(url);
            if(isSet){
                //信任所有证书
                request.trustAllCerts();
                //信任所有地址
                request.trustAllHosts();
                //设置请求超时时间
                request.connectTimeout(60000);
                //设置读取超时时间
                request.readTimeout(60000);
            }
            stringBuilder.append(request.form(data).body());
        }else{
            HttpRequest request = HttpRequest.post(url);
            if(isSet){
                //信任所有证书
                request.trustAllCerts();
                //信任所有地址
                request.trustAllHosts();
                //设置请求超时时间
                request.connectTimeout(60000);
                //设置读取超时时间
                request.readTimeout(60000);
            }
            stringBuilder.append(request.body());
        }
        return getResultMessage(stringBuilder);
    }

    private static ResultMessage getResultMessage(StringBuilder stringBuilder) {
        if(stringBuilder.toString().contains(HTMLCODE)){
            return  ResultMessage.erreo(ResultMessage.FAILCODE, null,stringBuilder.toString());
        }else{
            try {
                JSONObject jsonObject = JSONObject.parseObject(stringBuilder.toString());
                return  ResultMessage.success(jsonObject,ResultMessage.SUCCESSFUL);
            }catch (Exception e){
                JSONArray jsonArray = JSONArray.parseArray(stringBuilder.toString());
                return  ResultMessage.success(jsonArray,ResultMessage.SUCCESSFUL);
            }
        }
    }

    /**
     *
     * @param url url
     * @return
     * https://blog.csdn.net/qq_16055765/article/details/83342069
     */
    public static ResultMessage httpGet(String url){
        RestTemplate restTemplate=new RestTemplate();
        String result=restTemplate.exchange(url, HttpMethod.GET,null,String.class).getBody();
        return ResultMessage.success(result,"");
    }

    /**
     *
     * @param url url
     * @param name name
     * @return
     * https://blog.csdn.net/qq_16055765/article/details/83342069
     */
    public static ResultMessage httpPost(String url,String name){
        RestTemplate restTemplate=new RestTemplate();
        return ResultMessage.success(restTemplate.postForEntity(url,name,String.class).getBody(),"");
    }
}
