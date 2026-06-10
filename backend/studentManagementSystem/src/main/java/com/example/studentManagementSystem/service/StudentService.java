package com.example.studentManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getStudentInfo() {
        return "Student Service is working!";
    }
    
    public String getStudentCount() {

        String sql = "SELECT COUNT(*) FROM students";

        return jdbcTemplate.queryForObject(sql,Integer.class).toString();
    
}
}