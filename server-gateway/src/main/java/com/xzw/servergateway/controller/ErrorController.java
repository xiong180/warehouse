package com.xzw.servergateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 熊志伟
 * 创建时间 2021/2/4 16:50
 * 描述
 */
@RestController
public class ErrorController {
    @RequestMapping(value = "/fallback")
    public Object fallback () {
        Map<String , Object> result = new HashMap<>();
        result.put("code" , 0);
        result.put("msg" , "服务器繁忙");
        result.put("state" , false);
        return result;
    }
}
