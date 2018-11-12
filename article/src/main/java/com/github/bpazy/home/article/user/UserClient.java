package com.github.bpazy.home.article.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-client")
public interface UserClient {

    @GetMapping("/user/{userId}")
    User findUser(@PathVariable("userId") String userId);
}
