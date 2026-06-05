package com.srinu.edutrackpro.dto;

import com.srinu.edutrackpro.entity.StudentStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {

    private Long id;
    private String studentCode;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String department;
    private Integer semester;
    private StudentStatus status;
}
