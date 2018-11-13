package com.github.bpazy.home.user;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @SneakyThrows
    @RequestMapping("/findUser/{userId}")
    public User findUser(@PathVariable String userId) {
        return userService.findUser(userId);
    }
}
