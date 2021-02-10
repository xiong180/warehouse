package com.xzw.cloudregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 * @author xzw
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudRegisterApplication.class, args);
    }

}
