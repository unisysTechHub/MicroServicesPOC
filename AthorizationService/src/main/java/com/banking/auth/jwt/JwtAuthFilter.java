package com.banking.auth.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.banking.auth.jwt.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
    	String requestPath = request.getRequestURI();
    	 String jwtToken = null;
         String username = "john_doe";

        // Skip token validation for public endpoints
        if (requestPath.startsWith("/api/users/authenticate") ) {
            filterChain.doFilter(request, response);
            return;
        }
        final String authHeader = request.getHeader("Authorization");
       
        		
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwtToken = authHeader.substring(7);
            System.out.println("auth header first 7 chars" + jwtToken);
         //   username = jwtService.getUsernameFromToken(jwtToken) ;
        } else { 
        	System.out.println("auth header is null or bearer is not in token");
        }
     //   UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        UsernamePasswordAuthenticationToken authToken = 
//              new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
     // SecurityContextHolder.getContext().setAuthentication(authToken);
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername("john_doe");

            if (jwtService.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = 
                       new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
              SecurityContextHolder.getContext().setAuthentication(authToken);
                
           } else {
            	System.out.println("not a valid token - not ");
          }
        }
        else {
        	System.out.println("user name is null");
        }

        filterChain.doFilter(request, response);
    }
}
