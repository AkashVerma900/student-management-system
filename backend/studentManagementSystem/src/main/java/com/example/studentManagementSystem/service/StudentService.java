package com.example.studentManagementSystem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.studentManagementSystem.exception.StudentNotFoundException;
import com.example.studentManagementSystem.model.Student;
import com.example.studentManagementSystem.repository.StudentRepository;
import com.example.studentManagementSystem.dto.StudentRequestDTO;
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

    // public List <Student> getAllStudents() {
    //     String sql = "SELECT * FROM students";
    //     return repository.findAll();
    // }

    public Student getStudentById(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    public Student addStudent(StudentRequestDTO dto){
        Student student = new Student();
        student.setName(dto.getName());
        student.setCourse(dto.getCourse());

        return repository.save(student);
    }
}