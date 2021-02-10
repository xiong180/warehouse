package com.serversys.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Administrator
 * @Description thymeleaf的例子
 * @create 2020-12-27 17:47
 */
@Controller
public class MyController {
    @RequestMapping("thymeleafTest")
    public String thymeleafTest(Map<String,Object> res){
        res.put("name","xzw");
        res.put("age","12");
        ArrayList<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");
        list.add("231");
        res.put("list",list);
        return "myHtml";
    }
}
