package com.srinu.edutrackpro.service;

import com.srinu.edutrackpro.entity.Student;
import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void deleteStudent(Long id);
}
