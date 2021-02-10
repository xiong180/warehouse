package com.xzw.serverorderin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 订单入库服务
 * @author xzw
 */
@SpringBootApplication
@EnableEurekaClient
public class ServerOrderInApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerOrderInApplication.class, args);
    }

}
