package com.sp.gateway.config;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import reactor.core.publisher.Mono;

import java.util.List;

public interface AuthClient {

//    @PostMapping("/validateToken")
//    Mono<String> validateToken(@RequestHeader("Authorization") String tokenHeader);
}
