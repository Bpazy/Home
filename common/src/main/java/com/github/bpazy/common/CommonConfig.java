package com.github.bpazy.common;

import com.github.bpazy.common.spring.PermissionExceptionInterceptor;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configurable
@ComponentScan
public class CommonConfig implements WebMvcConfigurer {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public Decoder decoder() {
        return new PermissionExceptionInterceptor(new ResponseEntityDecoder(new SpringDecoder(messageConverters)));
    }
}
