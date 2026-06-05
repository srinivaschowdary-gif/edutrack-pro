package com.srinu.edutrackpro.service;

import com.srinu.edutrackpro.dto.StudentRequest;
import com.srinu.edutrackpro.dto.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse saveStudent(StudentRequest request);

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Long id);

    void deleteStudent(Long id);

    StudentResponse updateStudent(Long id,StudentRequest request);
}