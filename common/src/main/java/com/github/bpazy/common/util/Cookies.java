package com.github.bpazy.common.util;

import org.springframework.http.HttpCookie;
import org.springframework.http.server.reactive.ServerHttpRequest;

public class Cookies {
    public static String findCookie(ServerHttpRequest request, String name) {
        HttpCookie cookie = request.getCookies().getFirst(name);
        if (cookie == null) return "";
        return cookie.getValue();
    }
}
