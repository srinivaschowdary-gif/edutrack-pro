package com.srinu.edutrackpro.dto;

import com.srinu.edutrackpro.entity.StudentStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {

    @NotBlank(message = "Student code is required")
    private String studentCode;

    @NotBlank(message = "First name is required")
    private String firstName;

    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    private String phoneNumber;

    @NotBlank(message = "Department is required")
    private String department;

    @NotBlank(message = "Semester is required")
    private Integer semester;

    private StudentStatus status;
}
