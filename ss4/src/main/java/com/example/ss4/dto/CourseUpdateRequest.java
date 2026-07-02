package com.example.ss4.dto;

import com.example.ss4.entity.CourseStatus;

public class CourseUpdateRequest {
    private String title;
    private CourseStatus status;
    private Long instructorId;

    // --- Khởi tạo Getters ---
    public String getTitle() {
        return title;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    // --- Khởi tạo Setters ---
    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }
}