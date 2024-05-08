package com.demo.multiTenant.model;

public class Course {
    private int courseID;
    private String courseName;
    private int credits;

    // Getters and setters
    public int getCourseID() { return courseID; }
    public void setCourseID(int courseID) { this.courseID = courseID; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
}

