package com.xzw.serverorderout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 订单出库服务
 * @author xzw
 */
@SpringBootApplication
@EnableEurekaClient
public class ServerOrderOutApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerOrderOutApplication.class, args);
    }

}
