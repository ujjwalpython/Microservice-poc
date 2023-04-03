package com.sp.authservice.config;

import com.sp.authservice.domain.UserPool;
import com.sp.authservice.repo.UserPoolRepository;
import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
public class PoolConfiguration {

  private final PasswordEncoder passwordEncoder;
  private final UserPoolRepository userPoolRepository;

  @Bean
  CommandLineRunner commandLineRunner() {
    return (args) -> {
      List<UserPool> users = this.userPoolRepository.findAll();
      if (!users.isEmpty()) {
        return;
      }
      List<UserPool> pools =
          Arrays.asList(
              new UserPool(1L, "Auth Service", "auth@spring.com", passwordEncoder.encode("12345")),
              new UserPool(2L, "Post Service", "post@spring.com", passwordEncoder.encode("12345")),
              new UserPool(3L, "User Service", "user@spring.com", passwordEncoder.encode("12345")),
              new UserPool(4L, "Service", "userpost@spring.com", passwordEncoder.encode("12345")));

      this.userPoolRepository.saveAll(pools);
    };
  }
}
