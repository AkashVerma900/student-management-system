package com.example.studentManagementSystem.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {  

    @Value("${jwt.secret}")
    private String key; 

    public String generateJwtToken(String username) {
        // In a real application, you would use a library like jjwt to generate a JWT token
        // Here, we are just returning a dummy token for demonstration purposes
         
        String token = 
            Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*30)) // 1 day expiration
                .signWith(Keys.hmacShaKeyFor(key.getBytes()))
                .compact();
            return token;
    }

    public boolean isValid(String token) {
        // In a real application, you would use a library like jjwt to validate the JWT token
        // Here, we are just returning true for demonstration purposes
        try {
            Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(key.getBytes()))
                .build()
                .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        // In a real application, you would use a library like jjwt to extract the username from the JWT token
        // Here, we are just returning a dummy username for demonstration purposes
        return Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(key.getBytes()))
                .build()
                .parseSignedClaims(token)
                .getBody()
                .getSubject();
    }
}