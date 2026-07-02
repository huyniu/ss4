package com.example.ss4.controller;

import com.example.ss4.dto.ApiResponse;
import com.example.ss4.dto.InstructorCreateRequest;
import com.example.ss4.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<ApiResponse> createInstructor(@RequestBody InstructorCreateRequest req) {
        instructorService.createInstructor(req);

        ApiResponse response = new ApiResponse("Instructor Created Successfully", true, null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}