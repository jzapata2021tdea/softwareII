package net.software.backendcursojava.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import net.software.backendcursojava.models.request.UserLoginRequestModel;


public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) 
                throws AuthenticationException{
                                
            try {
                UserLoginRequestModel userModel = new ObjectMapper().readValue(request.getInputStream(), UserLoginRequestModel.class);
                return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                        userModel.getEmail(), 
                        userModel.getPassword(),
                        new ArrayList<>()));
            }catch(IOException e) {
                throw new RuntimeException(e);
            }

    }

    
}
