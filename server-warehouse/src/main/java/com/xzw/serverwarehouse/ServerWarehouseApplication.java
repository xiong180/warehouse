package com.xzw.serverwarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 仓库增删查改服务服务
 * @author xzw
 */
@SpringBootApplication
@EnableEurekaClient
public class ServerWarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerWarehouseApplication.class, args);
    }

}
