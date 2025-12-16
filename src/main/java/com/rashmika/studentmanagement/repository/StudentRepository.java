package com.rashmika.studentmanagement.repository;

import com.rashmika.studentmanagement.entity.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(@NotBlank(message = "Email is required") @Email(message = "Invalid Email") String email);
}