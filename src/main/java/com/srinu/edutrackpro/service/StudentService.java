package com.srinu.edutrackpro.service;

import com.srinu.edutrackpro.dto.StudentRequest;
import com.srinu.edutrackpro.dto.StudentResponse;
import com.srinu.edutrackpro.entity.StudentStatus;
import org.springframework.data.domain.Page;
import java.util.List;

public interface StudentService {

    StudentResponse saveStudent(StudentRequest request);

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Long id);

    void deleteStudent(Long id);

    StudentResponse updateStudent(Long id,StudentRequest request);

    Page<StudentResponse> getStudents(
            int page,
            int size,
            String sortBy);

    StudentResponse getStudentByEmail(String email);
    List<StudentResponse> getStudentByDepartment(String department);
    List<StudentResponse> getStudentByStatus(StudentStatus status);
}