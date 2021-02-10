package com.xzw.serverwarehouse.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 此处配置文件表示开启mybatis-plus分页功能
 * @author xzw
 */
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
 
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}