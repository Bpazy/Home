package com.github.bpazy.home.user;

import com.github.bpazy.common.EnableCommon;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCommon
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.github.bpazy.home.user")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}

