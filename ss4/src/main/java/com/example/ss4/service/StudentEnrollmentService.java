package com.example.ss4.service;

import com.example.ss4.entity.Course;
import com.example.ss4.entity.Student;
import com.example.ss4.entity.StudentEnrollment;
import com.example.ss4.repository.CourseRepository;
import com.example.ss4.repository.StudentEnrollmentRepository;
import com.example.ss4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentEnrollmentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentEnrollmentRepository enrollmentRepository;

    public void enrollStudent(Long studentId, Long courseId) {
        // 1. Tìm Sinh viên
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Sinh viên"));

        // 2. Tìm Khóa học
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Khóa học"));

        // 3. Khởi tạo đối tượng bảng trung gian
        StudentEnrollment enrollment = new StudentEnrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        // 4. Lưu vào DB
        enrollmentRepository.save(enrollment);
    }
}