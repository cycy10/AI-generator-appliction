package org.backend.contentgenerator.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {


    private JWTService jwtservice;
    public  JWTFilter(JWTService jwtservice){
        this.jwtservice = jwtservice;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authroization");
        String token = null;
        String username = null;

        if(header!=null && header.startsWith("Bearer ")){

        }
    }
}
