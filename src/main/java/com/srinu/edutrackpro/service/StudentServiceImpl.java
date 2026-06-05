package com.srinu.edutrackpro.service;

import com.srinu.edutrackpro.entity.Student;
import com.srinu.edutrackpro.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
