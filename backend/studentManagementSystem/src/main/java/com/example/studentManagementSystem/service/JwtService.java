package com.example.studentManagementSystem.service;

import org.springframework.stereotype.Service;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;


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
}