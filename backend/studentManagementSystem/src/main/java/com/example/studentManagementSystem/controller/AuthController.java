package com.example.studentManagementSystem.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentManagementSystem.dto.LoginRequestDTO;
import com.example.studentManagementSystem.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO dto) {
    
	   if(dto.getUsername().equals("admin") && dto.getPassword().equals("admin")){
            return jwtService.generateJwtToken(dto.getUsername());
        }

        return "Invalid Credentials";
    }
}