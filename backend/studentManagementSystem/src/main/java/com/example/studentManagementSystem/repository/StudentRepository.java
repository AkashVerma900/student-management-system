package com.example.studentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentManagementSystem.model.Student;

public interface StudentRepository
        extends JpaRepository<Student, Integer> {

}