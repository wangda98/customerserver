package com.da.provideserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.da.provideserver.mapper"})
public class ProvideserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProvideserverApplication.class, args);
    }
}
