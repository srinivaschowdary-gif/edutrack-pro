package com.srinu.edutrackpro.controller;

import com.srinu.edutrackpro.dto.StudentRequest;
import com.srinu.edutrackpro.dto.StudentResponse;
import com.srinu.edutrackpro.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentResponse createStudent(
            @Valid @RequestBody StudentRequest request) {

        return studentService.saveStudent(request);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {

        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(
            @PathVariable Long id) {

        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(
            @PathVariable Long id) {

        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public StudentResponse updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequest request){

        return studentService.updateStudent(id,request);
    }
}