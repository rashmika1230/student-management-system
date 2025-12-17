package com.rashmika.studentmanagement.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {

    private Long id;

    @NotBlank(message = "FirstName is required")
    private String firstName;

    @NotBlank(message = "LastName is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email")
    private String email;

    @Min(value = 5, message = "Age must be at least 5")
    @Max(value = 100, message = "Age must be less than 100")
    private Integer age;

    @NotBlank(message = "Major is required")
    private String major;

    @NotNull(message = "Enrollment date is required")
    @PastOrPresent(message = "Enrollment date cannot be in the future")
    private LocalDate enrollmentDate;
}
