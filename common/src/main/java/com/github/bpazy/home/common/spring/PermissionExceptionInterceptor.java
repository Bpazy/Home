package com.github.bpazy.home.common.spring;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;

import java.io.IOException;
import java.lang.reflect.Type;

public class PermissionExceptionInterceptor extends ResponseEntityDecoder {

    public static final int REJECT = 260;

    public PermissionExceptionInterceptor(Decoder decoder) {
        super(decoder);
    }

    @Override
    public Object decode(Response response, Type type) throws FeignException, IOException {
        if (response.status() == REJECT) {
            throw new HystrixBadRequestException("权限错误: " + response.body());
        }
        return super.decode(response, type);
    }
}
