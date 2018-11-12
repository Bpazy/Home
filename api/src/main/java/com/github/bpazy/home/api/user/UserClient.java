package com.github.bpazy.home.api.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-client", fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("/user/{userId}")
    User findUser(@PathVariable("userId") String userId);
}
