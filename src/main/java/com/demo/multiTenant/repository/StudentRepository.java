package com.demo.multiTenant.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.multiTenant.model.Student;

import java.util.List;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> findAll() {
        return jdbcTemplate.query("SELECT * FROM students", (rs, rowNum) -> {
            Student student = new Student();
            student.setStudentID(rs.getInt("studentID"));
            student.setFirstName(rs.getString("firstName"));
            student.setLastName(rs.getString("lastName"));
            student.setEmail(rs.getString("email"));
            student.setDateOfBirth(rs.getDate("dateOfBirth"));
            return student;
        });
    }

    // Additional CRUD operations as needed
}

