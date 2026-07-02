package com.example.ss4.service;

import com.example.ss4.dto.CourseCreateRequest;
import com.example.ss4.dto.CourseUpdateRequest;
import com.example.ss4.entity.Course;
import com.example.ss4.entity.Instructor;
import com.example.ss4.repository.CourseRepository;
import com.example.ss4.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    public void createCourse(CourseCreateRequest req) {
        // 1. Tìm giảng viên. Nếu không thấy sẽ ném ra lỗi (Exception)
        Instructor instructor = instructorRepository.findById(req.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Giảng viên với ID: " + req.getInstructorId()));

        // 2. Tạo khóa học mới và gán dữ liệu
        Course course = new Course();
        course.setTitle(req.getTitle());
        course.setStatus(req.getStatus());
        course.setInstructor(instructor); // Gán nguyên Object Instructor vào

        // 3. Lưu vào DB
        courseRepository.save(course);
    }

    public void updateCourse(Long id, CourseUpdateRequest req) {
        // 1. Tìm khóa học cần sửa
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Khóa học"));

        // 2. Tìm giảng viên mới
        Instructor instructor = instructorRepository.findById(req.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Giảng viên"));

        // 3. Cập nhật dữ liệu
        existingCourse.setTitle(req.getTitle());
        existingCourse.setStatus(req.getStatus());
        existingCourse.setInstructor(instructor);

        courseRepository.save(existingCourse);
    }
}