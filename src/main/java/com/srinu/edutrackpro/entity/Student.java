package com.srinu.edutrackpro.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Student code is required")
    @Column(name="student_code",nullable = false,unique = true)
    private String studentCode;

    @NotBlank(message = "First name is required")
    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @NotBlank(message = "Invalid email formal")
    @Column(nullable = false,unique = true)
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @NotBlank(message = "Department is required")
    @Column(nullable = false)
    private String department;

    @NotBlank(message = "Semester is required")
    @Column(nullable = false)
    private String semester;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;

}
