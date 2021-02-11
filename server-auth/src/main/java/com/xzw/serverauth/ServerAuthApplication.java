package com.xzw.serverauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xzw
 */
@SpringBootApplication
@EnableEurekaClient
public class ServerAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerAuthApplication.class, args);
    }

}
