package com.srinu.edutrackpro.repository;

import com.srinu.edutrackpro.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.srinu.edutrackpro.entity.StudentStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

    Optional<Student> findByEmail(String email);
    List<Student> findByDepartment(String department);
    List<Student> findByStatus(StudentStatus status);
}
