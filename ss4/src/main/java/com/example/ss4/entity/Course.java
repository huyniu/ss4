    package com.example.ss4.entity;

    import jakarta.persistence.*;

    import java.util.List;

    @Entity
    @Table(name = "courses")
    public class Course {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String title;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private CourseStatus status;

        @ManyToOne
        @JoinColumn(name = "instructor_id") // Định nghĩa cột khóa ngoại
        private Instructor instructor;

        // Sẽ thêm danh sách đăng ký ở Bước 3
        @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
        private List<StudentEnrollment> enrollments;

        // Nhớ tạo Getter/Setter cho instructor và enrollments
        public Instructor getInstructor() { return instructor; }
        public void setInstructor(Instructor instructor) { this.instructor = instructor; }

        public List<StudentEnrollment> getEnrollments() { return enrollments; }
        public void setEnrollments(List<StudentEnrollment> enrollments) { this.enrollments = enrollments; }
        // Constructors
        public Course() {}

        // Getters and Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public CourseStatus getStatus() { return status; }
        public void setStatus(CourseStatus status) { this.status = status; }

    }