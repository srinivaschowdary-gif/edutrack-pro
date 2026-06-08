package com.srinu.edutrackpro.controller;

import com.srinu.edutrackpro.dto.StudentRequest;
import com.srinu.edutrackpro.dto.StudentResponse;
import com.srinu.edutrackpro.entity.Student;
import com.srinu.edutrackpro.entity.StudentStatus;
import com.srinu.edutrackpro.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.srinu.edutrackpro.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentResponse>>
    createStudent(
            @Valid @RequestBody StudentRequest request) {

        StudentResponse response =
                studentService.saveStudent(request);

        ApiResponse<StudentResponse> apiResponse =
                new ApiResponse<>(
                        true,
                        "Student created successfully",
                        response
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentResponse>>> getAllStudents() {

        List<StudentResponse> students =
                studentService.getAllStudents();

        ApiResponse<List<StudentResponse>> response =
                new ApiResponse<>(
                        true,
                        "Students fetched successfully",
                        students
                );

        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStudent(
            @PathVariable Long id) {

        studentService.deleteStudent(id);

        ApiResponse<String> response =
                new ApiResponse<>(
                        true,
                        "Student deleted successfully",
                        null
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> getStudentById(
            @PathVariable Long id) {

        StudentResponse student =
                studentService.getStudentById(id);

        ApiResponse<StudentResponse> response =
                new ApiResponse<>(
                        true,
                        "Student fetched successfully",
                        student
                );

        return ResponseEntity.ok(response);
    }


    @GetMapping("/paged")
    public Page<StudentResponse> getStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy){

        return studentService.getStudents(page,size,sortBy);
    }

    @GetMapping("/email/{email}")
    public StudentResponse getStudentByEmail(
            @PathVariable String email){

        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/department/{department}")
    public List<StudentResponse> getStudentByDepartment(
            @PathVariable String department){

        return studentService.getStudentByDepartment(department);
    }

    @GetMapping("/status/{status}")
    public List<StudentResponse> getStudentByStatus(
            @PathVariable StudentStatus status){

        return studentService.getStudentByStatus(status);
    }
}