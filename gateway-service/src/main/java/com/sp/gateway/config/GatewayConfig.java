package com.sp.gateway.config;

import com.sp.gateway.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GatewayConfig {

//    @Autowired
//    public GatewayConfig(@Lazy AuthClient authClient) {
//        this.authClient = authClient;
//    }
//    private AuthClient authClient;
    private JwtAuthenticationFilter filter;

    @Autowired
    private RouteValidator validator;

    @Bean
    public JwtConfig jwtConfig() {
        return new JwtConfig();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        filter = jwtAuthenticationFilter();
        return builder.routes().route("auth", r -> r.path("/auth/**").filters(f -> f.filter(filter)).uri("lb://auth-service"))
            .route("users", r -> r.path("/users/**").filters(f -> f.filter(filter)).uri("lb://user-post-service"))
            .route("posts", r -> r.path("/posts/**").filters(f -> f.filter(filter)).uri("lb://post-service"))
            /*.route("hello", r -> r.path("/hello/**").filters(f -> f.filter(filter)).uri("lb://hello"))*/.build();
    }

    /*@Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    @LoadBalanced
    public RestTemplate loadBalanceTemp() {
        return new RestTemplate();
    }*/
}