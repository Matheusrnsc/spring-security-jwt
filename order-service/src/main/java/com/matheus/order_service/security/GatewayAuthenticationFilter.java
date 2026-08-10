package com.matheus.order_service.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class GatewayAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                
                String gatewayHeader = request.getHeader("X-Gateway-Authenticated");
                if (gatewayHeader == null || !gatewayHeader.equals("true")) {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Forbidden: Request must come through the gateway");
                    return;
                }

        filterChain.doFilter(request, response);
    }
    
}
