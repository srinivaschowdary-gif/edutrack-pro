package com.srinu.edutrackpro.entity;
import jakarta.persistence.*;
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

    @Column(name="student_code",nullable = false,unique = true)
    private String studentCode;

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String semester;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;
}
