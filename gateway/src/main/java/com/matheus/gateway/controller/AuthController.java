package com.matheus.gateway.controller;

import com.matheus.gateway.service.AuthenticationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.gateway.dto.LoginRequest;
import com.matheus.gateway.dto.LoginResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    private final AuthenticationService authenticationService;


    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        String token = authenticationService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        return new LoginResponse(token);
    }


    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    
}
