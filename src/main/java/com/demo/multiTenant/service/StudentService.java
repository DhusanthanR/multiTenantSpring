package com.demo.multiTenant.service;

import org.springframework.stereotype.Service;

import com.demo.multiTenant.model.Student;
import com.demo.multiTenant.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
	
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> listAllStudents() {
        return studentRepository.findAll();
    }

    // Additional business logic
}

