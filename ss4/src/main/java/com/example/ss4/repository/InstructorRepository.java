package com.example.ss4.repository;

import com.example.ss4.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    // Để trống hoàn toàn. JpaRepository đã cung cấp sẵn findAll(), findById(), save()...
}