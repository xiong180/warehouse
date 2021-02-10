package com.serversys.http;

import com.serversys.utils.HttpRequestUtil;
import com.serversys.utils.ResultMessage;

public class HttpTest {
    public static void main(String[] args) {
        String url = "https://www.bilibili.com/";
//        String url = "http://111.8.92.155:7095/OaWebLL/txl/txl_txl";
//        ResultMessage meg = HttpRequestUtil.doGet(url,null,false);
        ResultMessage meg = HttpRequestUtil.doGet(url,null,false);
        System.out.println(meg.getData());
        System.out.println(meg.getDescribe());
    }
}
