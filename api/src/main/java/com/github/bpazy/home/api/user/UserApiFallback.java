package com.github.bpazy.home.api.user;

import org.springframework.stereotype.Component;

@Component
public class UserApiFallback implements UserApi {
    @Override
    public User findUser(String userId) {
        return null;
    }
}
