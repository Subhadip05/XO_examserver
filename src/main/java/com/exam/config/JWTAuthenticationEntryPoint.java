package com.exam.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint {

    // AWT Authentication class 1 Done
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized : Server");
        PrintWriter writer = response.getWriter();
        writer.println("Access Denied !! "+ authException.getMessage());
    }
}
