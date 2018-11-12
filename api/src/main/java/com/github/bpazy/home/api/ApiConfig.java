package com.github.bpazy.home.api;

import feign.Feign;
import feign.hystrix.HystrixFeign;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@Configurable
@ComponentScan
@EnableFeignClients
@EnableCircuitBreaker
public class ApiConfig {
    /**
     * 手动创建hystrixBuilder，原因为写在application.yml中的feign.hystrix.enabled不能被父项目自动发现
     */
    @Bean
    @Scope("prototype")
    public Feign.Builder feignHystrixBuilder() {
        return HystrixFeign.builder();
    }
}
