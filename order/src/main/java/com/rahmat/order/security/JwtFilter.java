package com.rahmat.order.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import io.jsonwebtoken.*;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final String SECRET_KEY = "mysecretkeymysecretkeymysecretkey123";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token tidak ada");
            return;
        }

        String token = header.substring(7);

        try {
            Jwts.parser()
                .setSigningKey(SECRET_KEY.getBytes())
                .parseClaimsJws(token);

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Token tidak valid");
            return;
        }

        filterChain.doFilter(request, response);
    }
}