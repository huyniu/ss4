package com.example.ss4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_enrollments") // Chuẩn hóa snake_case
public class StudentEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Quan hệ ManyToOne tới Student
    @ManyToOne
    @JoinColumn(name = "student_id") // Tạo khóa ngoại student_id
    private Student student;

    // Quan hệ ManyToOne tới Course
    @ManyToOne
    @JoinColumn(name = "course_id") // Tạo khóa ngoại course_id
    private Course course;

    // Có thể thêm các trường khác nếu cần (ví dụ: enrollmentDate, grade...)

    // Constructors
    public StudentEnrollment() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}