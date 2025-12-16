package com.rashmika.studentmanagement.service;

import com.rashmika.studentmanagement.dto.StudentDto;
import com.rashmika.studentmanagement.entity.Student;
import com.rashmika.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

   public StudentDto createStudent(StudentDto studentDto) {
        if (studentRepository.existsByEmail(studentDto.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        Student  student = mapToEntity(studentDto);
        Student savedStudent = studentRepository.save(student);

        return mapToDto(savedStudent);
   }

    private StudentDto mapToDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEmail(student.getEmail());
        studentDto.setAge(student.getAge());
        studentDto.setMajor(student.getMajor());
        studentDto.setEnrollmentDate(student.getEnrollmentDate());
        return studentDto;
    }

    private Student mapToEntity(StudentDto dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());
        student.setMajor(dto.getMajor());
        student.setEnrollmentDate(dto.getEnrollmentDate());
        return student;
    }
}
