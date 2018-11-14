package com.github.bpazy.home.api.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(path = "/user", value = "user-service", fallback = UserApiFallback.class)
public interface UserApi {

    @GetMapping("/findUser/{userId}")
    User findUser(@PathVariable("userId") String userId);
}
