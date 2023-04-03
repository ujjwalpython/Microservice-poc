package com.sp.authservice.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.commonservice.security.JwtConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@AllArgsConstructor
public class JwtUserAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;
  private final JwtConfig jwtConfig;

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

    System.out.println("[][][][failed to get the solution matters");
    try {

      // 1. Get credentials from request
      UserCredentials userCredentials =
          new ObjectMapper().readValue(request.getInputStream(), UserCredentials.class);

      // 2. Create auth object (contains credentials) which will be used by auth manager
      UsernamePasswordAuthenticationToken authToken =
          new UsernamePasswordAuthenticationToken(
              userCredentials.getUsername(),
              userCredentials.getPassword(),
              Collections.emptyList());

      // 3. Authentication manager authenticate the user, and use
      // UserDetailsServiceImpl::loadUserByUsername() method to load the user.
      return authenticationManager.authenticate(authToken);

    } catch (IOException e) {
      System.out.println("[][][][========= failed to get the solution matters");
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication authResult)
      throws ServletException {

    long now = System.currentTimeMillis();
    String token =
        Jwts.builder()
            .setSubject(authResult.getName())
            .claim(
                "authorities",
                authResult.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()))
            .setIssuedAt(new Date(now))
            .setExpiration(new Date(now + jwtConfig.getExpiration() * 1000L))
            .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtConfig.getSecret())))
            .compact();

    // Add token to header
    response.addHeader(jwtConfig.getHeader(), jwtConfig.getPrefix() + token);
  }

  @Override
  protected void unsuccessfulAuthentication(
      HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
      throws IOException, ServletException {
    super.unsuccessfulAuthentication(request, response, failed);
  }

  @Getter
  @Setter
  private static class UserCredentials {
    private String username, password;
  }
}
