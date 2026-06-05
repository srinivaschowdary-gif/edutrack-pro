package com.srinu.edutrackpro.mapper;

import com.srinu.edutrackpro.dto.StudentRequest;
import com.srinu.edutrackpro.dto.StudentResponse;
import com.srinu.edutrackpro.entity.Student;

public class StudentMapper {

    public static Student toEntity(StudentRequest request){

        Student student=new Student();

        student.setStudentCode(request.getStudentCode());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setDepartment(request.getDepartment());
        student.setSemester(request.getSemester());
        student.setStatus(request.getStatus());

        return student;
    }

    public static StudentResponse toResponse(Student student){

        StudentResponse response=new StudentResponse();

        response.setId(student.getId());
        response.setStudentCode(student.getStudentCode());
        response.setFirstName(student.getFirstName());
        response.setLastName(student.getLastName());
        response.setEmail(student.getEmail());
        response.setPhoneNumber(student.getPhoneNumber());
        response.setDepartment(student.getDepartment());
        response.setSemester(student.getSemester());
        response.setStatus(student.getStatus());

        return response;
    }
}
