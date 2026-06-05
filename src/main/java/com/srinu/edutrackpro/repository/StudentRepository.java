package com.srinu.edutrackpro.repository;

import com.srinu.edutrackpro.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
