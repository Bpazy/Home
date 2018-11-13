package com.github.bpazy.home.user;

import com.github.bpazy.common.EnableCommon;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@EnableCommon
@SpringCloudApplication
@MapperScan("com.github.bpazy.home.user")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}

