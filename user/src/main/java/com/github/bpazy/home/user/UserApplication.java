package com.github.bpazy.home.user;

import com.github.bpazy.common.EnableCommon;
import com.github.bpazy.home.acl.EnableAcl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@EnableAcl
@EnableCommon
@SpringCloudApplication
@MapperScan("com.github.bpazy.home.user")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}

