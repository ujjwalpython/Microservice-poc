package com.sp.gateway.filter;


import com.sp.gateway.config.JwtConfig;
import com.sp.gateway.config.RouteValidator;
import com.sp.gateway.expcetions.UnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;


@Component
public class JwtAuthenticationFilter implements GatewayFilter/*AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config>*/ {


    @Autowired
    private JwtConfig jwtConfig;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String authorizationHeader =
            exchange.getRequest().getHeaders().getFirst(jwtConfig.getHeader());
        try{
            if (authorizationHeader == null || !authorizationHeader.startsWith(jwtConfig.getPrefix())) {
                throw new UnauthorizedException("missing authorization header");
            }
//        if (authorizationHeader != null && authorizationHeader.startsWith(jwtConfig.getPrefix())) {
            String token = authorizationHeader.replace(jwtConfig.getPrefix(), "");
            Claims claims =
                Jwts.parserBuilder()
                    .setSigningKey(jwtConfig.getSecret())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();


        }
        catch (ExpiredJwtException e) {
            return Mono.error(new UnauthorizedException("JWT token has expired"));
        }
        catch (Exception e) {
            return Mono.error(new UnauthorizedException("Invalid jwt token"));
        }
        //     }
        return chain.filter(exchange);
    }
}


    /* Working code for web client call
    @Override
    public GatewayFilter apply(ObjectInputFilter.Config config) {
        return ((exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())) {
                //header contains token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new UnauthorizedException("missing authorization header");
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
//                try {
                    /*Mono<ResponseEntity<String>> responseMono = webClientBuilder.build().post()
                        .uri("http://auth-service/validateToken?tokenHeader={token}", authHeader)
                        .retrieve()
                        .toEntity(String.class);
                    */   /* .onErrorResume(error -> {
                        log.info("web client error response {}", error.getMessage());
                        return Mono.just(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
                    });*/
                        /*.flatMap(responseEntity -> {
                            if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
                                return Mono.just(responseEntity);
                            } else {
                                return Mono.error(new UnauthorizedException("Unauthorized access to application"));
                            }
                        });
*/
                    /*responseMono.subscribe(response -> {
                        if(response.getStatusCode()!= HttpStatus.OK){
                            log.info("web clinet api response {}",response.getStatusCode());
                            throw new RuntimeException("API response not OK");
                        }
                        chain.filter(exchange);

                    },
                        error -> {log.info("web clinet error response {}",String.valueOf(error));
                            return;
                    }
                   );*/
               /* if(result.get()!=true){
                    throw new UnauthorizedException("un authorized access");
                }*/
                  /*  RestTemplate restTemplate = new RestTemplate();
                    String url = "http://desktop-0bclnhs:50481/validateToken?tokenHeader="+authHeader;
                    URI uri = UriComponentsBuilder.fromUriString(url)
                        .build()
                        .toUri();
                    HttpHeaders headers = new HttpHeaders();
                    headers.set("Authorization", "Bearer " + authHeader);
                    HttpEntity<String> entity = new HttpEntity<>(null, headers);
                    ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity,String.class);


                    if (response.getStatusCode() == HttpStatus.OK) {
                        Claims claims =
                            Jwts.parserBuilder()
                                .setSigningKey(jwtConfig.getSecret())
                                .build()
                                .parseClaimsJws(authHeader)
                                .getBody();
                        }
                } catch (Exception e) {
                    log.info("exception e ---{}",e);
                    throw new UnauthorizedException("un authorized access to application");
                }
            }
            return null;
        });*/
//   }



    /*@Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String authorizationHeader =
                exchange.getRequest().getHeaders().getFirst(jwtConfig.getHeader());
        String token = null;
        if (authorizationHeader != null && authorizationHeader.startsWith(jwtConfig.getPrefix())) {
            token = authorizationHeader.replace(jwtConfig.getPrefix(), "");
            try {
               webClientBuilder.build().post()
                    .uri("http://auth-service/validateToken?tokenHeader={token}", token)
                    .retrieve()
                    .bodyToMono(String.class).subscribe(s -> log.info(s));
//                Claims claims =
//                        Jwts.parserBuilder()
//                                .setSigningKey(jwtConfig.getSecret())
//                                .build()
//                                .parseClaimsJws(token)
//                                .getBody();


//                // Check if the token was issued by a trusted issuer
//                if (!"trusted_issuer".equals(claims.getIssuer())) {
//                    return Mono.error(new UnauthorizedException("Invalid JWT issuer"));
//                }
            } catch (JwtException e) {
                return Mono.error(new UnauthorizedException("Invalid JWT token"));
            }
        }
//        Authentication authentication = new UsernamePasswordAuthenticationToken(null, token);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        return chain.filter(exchange);
    }
*/
