package net.software.backendcursojava;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import net.software.backendcursojava.services.UserServiceInterface;

public interface BCryptPasswordEncoder {

    DaoAuthenticationConfigurer<AuthenticationManagerBuilder, UserServiceInterface> passwordEncoder;

    default void configure(HttpSecurity http) throws Exception {
          http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/users")
          .permitAll().anyRequest().authenticated();
      }

}
