package com.rashmika.studentmanagement.controller;

import com.rashmika.studentmanagement.dto.StudentDto;
import com.rashmika.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(
            @Valid
            @RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.updateStudent(id, studentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getstudentById(Long id){
        return ResponseEntity.ok(studentService.findStudentById(id));
    }
}
