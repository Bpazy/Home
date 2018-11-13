package com.github.bpazy.home.api.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "user-client", fallback = UserClientFallback.class)
@RequestMapping("/user")
public interface UserClient {

    @GetMapping("/findUser/{userId}")
    User findUser(@PathVariable("userId") String userId);
}
