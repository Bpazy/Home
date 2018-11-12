package com.github.bpazy.home.article;

import com.github.bpazy.home.api.user.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private UserClient userClient;

    @GetMapping("/test")
    public Article test() {
        return Article.builder()
                .title("title")
                .content("content")
                .creator(userClient.findUser("1"))
                .build();
    }
}
