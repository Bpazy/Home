package com.github.bpazy.home.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class ApiFilter implements GatewayFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest apiRequest = exchange.getRequest().mutate().header("innerApi", "true").build();
        ServerWebExchange apiExchange = exchange.mutate().request(apiRequest).build();
        return chain.filter(apiExchange);
    }
}
