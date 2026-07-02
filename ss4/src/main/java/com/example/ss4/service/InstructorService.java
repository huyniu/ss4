package com.example.ss4.service;

import com.example.ss4.dto.InstructorCreateRequest;
import com.example.ss4.entity.Instructor;
import com.example.ss4.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> findAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor findInstructorById(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    public Instructor createInstructor(InstructorCreateRequest req) {
        Instructor newInstructor = new Instructor();

        newInstructor.setName(req.getName());
        newInstructor.setEmail(req.getEmail());

        return instructorRepository.save(newInstructor);
    }
}