package com.sp.authservice.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class JwtConfig {
    @Value("${security.jwt.uri:/auth/**}")
    private  String Uri="/auth/**";

    @Value("${security.jwt.header:Authorization}")
    private  String header="Authorization";

    @Value("${security.jwt.prefix:Bearer }")
    private  String prefix="Bearer";

    @Value("${security.jwt.expiration:#{24*60*60}}")
    private int expiration=24*60*60;

    @Value("${security.jwt.secret:JwtSecretKey}")
    private  String secret="JwtSecretKeyJwtSecretKeyJwtSecretKeyJwtSecretKey";
}
