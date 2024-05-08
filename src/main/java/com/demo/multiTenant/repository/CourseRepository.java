package com.demo.multiTenant.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.multiTenant.model.Course;

import java.util.List;

@Repository
public class CourseRepository {
    private final JdbcTemplate jdbcTemplate;

    public CourseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Course> findAll() {
        return jdbcTemplate.query("SELECT * FROM courses", (rs, rowNum) -> {
            Course course = new Course();
            course.setCourseID(rs.getInt("courseID"));
            course.setCourseName(rs.getString("courseName"));
            course.setCredits(rs.getInt("credits"));
            return course;
        });
    }

    // Additional CRUD operations as needed
}

