package com.github.bpazy.home.gateway;

import com.github.bpazy.home.gateway.filter.ApiFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/user/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://service-user")
                        .filter(new ApiFilter()))
                .route(p -> p.path("/article/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://service-article")
                        .filter(new ApiFilter()))
                .build();
    }
}
