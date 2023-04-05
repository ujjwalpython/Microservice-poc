package com.sp.authservice.config;

import com.sp.authservice.filter.JwtUserAndPasswordAuthenticationFilter;
import com.sp.commonservice.security.JwtConfig;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.HttpMethod;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration {

  private final JwtConfig jwtConfig;

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
        .formLogin().disable()
        .addFilterBefore(new JwtUserAndPasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)

        .exceptionHandling(
            httpSecurityExceptionHandlingConfigurer ->
                httpSecurityExceptionHandlingConfigurer.authenticationEntryPoint(
                    (req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)));

    return http.build();
  }
}