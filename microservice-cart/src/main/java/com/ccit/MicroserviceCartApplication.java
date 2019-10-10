package com.ccit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ccit.dao")
public class MicroserviceCartApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCartApplication.class, args);
    }

}
