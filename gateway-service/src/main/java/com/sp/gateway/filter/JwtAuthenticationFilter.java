package com.sp.gateway.filter;

import com.sp.commonservice.security.JwtConfig;
import com.sp.gateway.expcetions.UnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import java.util.Date;
import lombok.AllArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter implements GatewayFilter {

    private final JwtConfig jwtConfig;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String authorizationHeader =
                exchange.getRequest().getHeaders().getFirst(jwtConfig.getHeader());
        
        if (authorizationHeader != null && authorizationHeader.startsWith(jwtConfig.getPrefix())) {
            String token = authorizationHeader.replace(jwtConfig.getPrefix(), "");
            try {
                Claims claims =
                        Jwts.parserBuilder()
                                .setSigningKey(jwtConfig.getSecret().getBytes())
                                .build()
                                .parseClaimsJws(token)
                                .getBody();
                
                if (claims.getExpiration().before(new Date())) {
                    return Mono.error(new UnauthorizedException("JWT token has expired"));
                }
                // Check if the token was issued by a trusted issuer
                if (!"trusted_issuer".equals(claims.getIssuer())) {
                    return Mono.error(new UnauthorizedException("Invalid JWT issuer"));
                }
            } catch (JwtException e) {
                return Mono.error(new UnauthorizedException("Invalid JWT token"));
            }
        }
        return chain.filter(exchange);
    }
}
