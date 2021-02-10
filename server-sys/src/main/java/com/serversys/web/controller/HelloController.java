package com.serversys.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.serversys.web.component.SmsAsyncComponent;
import com.serversys.web.entity.User;

import javax.annotation.Resource;

/**
 * @author xzw
 */
@RestController
@Slf4j
public class HelloController {
    @Value("${xzw.name}")
    private String name;
    @Value("${xzw.age}")
    private Integer age;

    @Resource
    private SmsAsyncComponent sms;

    @GetMapping("/getName")
    public String getName(){
        return name + "---->"+ age;
    }

    @RequestMapping("/getUserName")
    public String getUserName(){
        User user = new User();
        user.setAge(12);
        user.setUserName("汤俊华");
        return user.getUserName() + "---->"+ user.getAge();
    }

    @RequestMapping("sms/{name}")
    public String sms(@PathVariable("name")String name) throws InterruptedException {
        log.info(">01<");
        log.info("发送短信:{}",name);
        log.info("接口线程:{}",Thread.currentThread().getName());
        sms.smsAsync();
        log.info(">04<");
        return name;
    }

}
