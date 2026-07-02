package com.example.ss4.service;

import com.example.ss4.dto.StudentCreateRequest;
import com.example.ss4.entity.Student;
import com.example.ss4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void createStudent(StudentCreateRequest req) {
        Student student = new Student();
        student.setName(req.getName());
        student.setEmail(req.getEmail() != null ? req.getEmail() : "no-email@test.com"); // Tránh lỗi null constraint nếu có
        studentRepository.save(student);
    }
}