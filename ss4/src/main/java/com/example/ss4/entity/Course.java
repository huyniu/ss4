package com.example.ss4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Không được để trống
    private String title;

    @Enumerated(EnumType.STRING) // Lưu giá trị Enum dưới dạng Chuỗi (String) thay vì số (Ordinal)
    @Column(nullable = false)
    private CourseStatus status;

    @Column(name = "instructor_id") // Tuân thủ naming convention của DB
    private Long instructorId;

    // Constructors
    public Course() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public CourseStatus getStatus() { return status; }
    public void setStatus(CourseStatus status) { this.status = status; }

    public Long getInstructorId() { return instructorId; }
    public void setInstructorId(Long instructorId) { this.instructorId = instructorId; }
}