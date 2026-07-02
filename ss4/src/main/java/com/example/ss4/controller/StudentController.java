package com.example.ss4.controller;

import com.example.ss4.dto.ApiResponse;
import com.example.ss4.dto.EnrollmentRequest;
import com.example.ss4.dto.StudentCreateRequest;
import com.example.ss4.service.StudentEnrollmentService;
import com.example.ss4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentEnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<ApiResponse> createStudent(@RequestBody StudentCreateRequest req) {
        studentService.createStudent(req);
        ApiResponse response = new ApiResponse("Student Created Successfully", true, null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/enrollments")
    public ResponseEntity<ApiResponse> enrollStudent(@RequestBody EnrollmentRequest req) {
        enrollmentService.enrollStudent(req.getStudentId(), req.getCourseId());
        ApiResponse response = new ApiResponse("Student Enrolled Successfully", true, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}