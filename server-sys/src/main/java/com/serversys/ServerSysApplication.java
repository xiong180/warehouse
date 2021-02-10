package com.serversys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xzw
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.serversys.web.mapper")
public class ServerSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerSysApplication.class, args);
    }

}
