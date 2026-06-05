package com.example.studentManagementSystem.controller;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentManagementSystem.model.Student;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @GetMapping
    public ArrayList<Student> getStudents() {

        ArrayList<Student> students = new ArrayList<>();
        students.add(
            new Student(1,"Akash Verma","CSE")
        );
        students.add(
            new Student(2,"Aryan Verma","CSE")
        );
        return students;
    }
}