package com.sp.authservice.config;

import com.sp.commonservice.security.JwtConfig;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.HttpMethod;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Slf4j
@Configuration
@AllArgsConstructor
public class SecurityConfiguration {

  private final JwtConfig jwtConfig;
  private final AuthenticationManager authenticationManager;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.csrf()
        .disable()
        .sessionManagement(
            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(
            request ->
                request
                    .requestMatchers(HttpMethod.POST, jwtConfig.getUri())
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .exceptionHandling(
            httpSecurityExceptionHandlingConfigurer ->
                httpSecurityExceptionHandlingConfigurer.authenticationEntryPoint(
                    (req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)));

    return http.build();
  }
}
