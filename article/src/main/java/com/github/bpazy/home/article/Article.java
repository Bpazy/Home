package com.github.bpazy.home.article;

import com.github.bpazy.home.api.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private String title;
    private String content;
    private User creator;
}
