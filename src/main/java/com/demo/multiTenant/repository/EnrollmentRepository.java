package com.demo.multiTenant.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.multiTenant.model.Enrollment;

import java.util.List;

@Repository
public class EnrollmentRepository {
    private final JdbcTemplate jdbcTemplate;

    public EnrollmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Enrollment> findAll() {
        return jdbcTemplate.query("SELECT * FROM enrollments", (rs, rowNum) -> {
            Enrollment enrollment = new Enrollment();
            enrollment.setEnrollmentID(rs.getInt("enrollmentID"));
            enrollment.setStudentID(rs.getInt("studentID"));
            enrollment.setCourseID(rs.getInt("courseID"));
            enrollment.setEnrollmentDate(rs.getDate("enrollmentDate"));
            return enrollment;
        });
    }

    // Additional CRUD operations as needed
}

