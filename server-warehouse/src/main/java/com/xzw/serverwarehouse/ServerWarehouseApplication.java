package com.xzw.serverwarehouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 仓库增删查改服务
 * @author xzw
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.xzw.serverwarehouse.mapper")
public class ServerWarehouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerWarehouseApplication.class, args);
    }

}
