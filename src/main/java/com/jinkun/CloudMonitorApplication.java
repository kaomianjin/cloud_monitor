package com.jinkun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableCaching
@EnableScheduling
@MapperScan(basePackages = "com.jinkun.cloud_monitor.dao")
@SpringBootApplication
public class CloudMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudMonitorApplication.class, args);
    }

}
