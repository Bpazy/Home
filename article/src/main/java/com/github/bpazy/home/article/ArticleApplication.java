package com.github.bpazy.home.article;

import com.github.bpazy.home.common.EnableCommon;
import com.github.bpazy.home.acl.EnableAcl;
import com.github.bpazy.home.api.EnableApi;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@EnableAcl
@EnableApi
@EnableCommon
@MapperScan("com.github.bpazy.home.article")
@SpringCloudApplication
public class ArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }
}
