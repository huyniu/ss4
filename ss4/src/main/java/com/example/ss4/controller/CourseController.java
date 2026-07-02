package com.example.ss4.controller;

import com.example.ss4.dto.ApiResponse;
import com.example.ss4.dto.CourseCreateRequest;
import com.example.ss4.dto.CourseUpdateRequest;
import com.example.ss4.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<ApiResponse> createCourse(@RequestBody CourseCreateRequest req) {
        courseService.createCourse(req);
        ApiResponse response = new ApiResponse("Course Created Successfully", true, null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateCourse(@PathVariable Long id, @RequestBody CourseUpdateRequest req) {
        courseService.updateCourse(id, req);
        ApiResponse response = new ApiResponse("Course Updated Successfully", true, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}