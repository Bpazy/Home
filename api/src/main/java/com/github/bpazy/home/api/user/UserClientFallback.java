package com.github.bpazy.home.api.user;

import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User findUser(String userId) {
        return User.builder().build();
    }
}
