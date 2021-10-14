package net.software.backendcursojava.security;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpMethod;
import jdk.internal.icu.impl.ICUBinary.Authenticate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import net.software.backendcursojava.BCryptPasswordEncoder;
import net.software.backendcursojava.services.UserServiceInterface;

@EnablewebSegurity
public class WebSecurity  extends webSecurityConfiguredAdapter{

    private final UserServiceInterface userServiceInterface;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurity(UserServiceInterface userService, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userServiceInterface =  userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

      }
      @Override
      protected void configure(HttpSecurity http) throws Exception {
          http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/users")
          .permitAll().anyRequest().authenticated();
      }
      

      @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userServiceInterface).passwordEncoder(bCryptPasswordEncoder);
    }  
          
      

    
}
