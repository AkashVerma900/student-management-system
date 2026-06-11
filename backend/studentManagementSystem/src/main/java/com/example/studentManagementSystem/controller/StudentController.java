package com.example.studentManagementSystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentManagementSystem.dto.StudentResponseDTO;
import com.example.studentManagementSystem.model.Student;
import com.example.studentManagementSystem.service.StudentService;
import com.example.studentManagementSystem.dto.StudentRequestDTO;
import com.example.studentManagementSystem.dto.StudentRequestDTO;
@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    // @GetMapping
    // public ArrayList<Student> getStudents() {

    //     ArrayList<Student> students = new ArrayList<>();
    //     students.add(
    //         new Student(1,"Akash Verma","CSE")
    //     );
    //     students.add(
    //         new Student(2,"Aryan Verma","CSE")
    //     );
    //     return students;
    // }

    @GetMapping("/count")
    public String countStudents() {

        return studentService.getStudentCount();
    }
    @GetMapping("/message")
    public String getMessage() {
        return studentService.getStudentInfo();
    }

    // @GetMapping
    // public List<Student> getAllStudents() {
    //     return studentService.getAllStudents();
    // }

    // @PostMapping
    // public Student addStudent(@RequestBody Student student) {
    // return studentService.saveStudent(student);
    // }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Integer id) {
        Student student = studentService.getStudentById(id);
        
        StudentResponseDTO responseDTO = new StudentResponseDTO(
            student.getId(), 
            student.getName(), 
            student.getCourse());
        return ResponseEntity.ok(responseDTO);
    }
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentRequestDTO dto) {

    Student student = studentService.addStudent(dto);

    return ResponseEntity.ok(student);
}
}