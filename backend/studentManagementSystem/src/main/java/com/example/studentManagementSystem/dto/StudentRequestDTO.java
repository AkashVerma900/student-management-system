package com.example.studentManagementSystem.dto;

public class StudentRequestDTO {
    private String name;
    private String course;

    public StudentRequestDTO(String name, String course) {
        this.name = name;
        this.course = course;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}