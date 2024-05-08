package com.demo.multiTenant.controller;

import org.springframework.web.bind.annotation.*;

import com.demo.multiTenant.model.Student;
import com.demo.multiTenant.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.listAllStudents();
    }

    // Additional endpoints as needed
}

