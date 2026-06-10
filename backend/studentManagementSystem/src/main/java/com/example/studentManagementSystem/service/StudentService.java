package com.example.studentManagementSystem.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.studentManagementSystem.model.Student;
import com.example.studentManagementSystem.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentRepository repository;

    public String getStudentInfo() {
        return "Student Service is working!";
    }
    
    public String getStudentCount() {

        String sql = "SELECT COUNT(*) FROM students";

        return jdbcTemplate.queryForObject(sql,Integer.class).toString();
    
    }

    public Student saveStudent( Student student) {
    return repository.save(student);
    }

    public List <Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        return repository.findAll();
    }
}