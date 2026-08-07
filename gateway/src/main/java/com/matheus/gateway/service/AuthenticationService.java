package com.matheus.gateway.service;

import org.springframework.stereotype.Service;

import com.matheus.gateway.security.JwtService;

import org.springframework.beans.factory.annotation.Value;


@Service
public class AuthenticationService {
    
    private JwtService jwtService;
    @Value("${spring.security.user.name}")
    private String myusername;

    @Value("${spring.security.user.password}")
    private String mypassword;
   

    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    

    public String authenticate(String username, String password){
        if(username.equals(myusername) && password.equals(mypassword)){
            return jwtService.generateToken(username, "ROLE_ADMIN");
        }
        throw new IllegalArgumentException("Invalid credentials");
    }
    
}
