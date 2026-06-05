package com.srinu.edutrackpro.service;

import com.srinu.edutrackpro.dto.StudentRequest;
import com.srinu.edutrackpro.dto.StudentResponse;
import com.srinu.edutrackpro.entity.Student;
import com.srinu.edutrackpro.mapper.StudentMapper;
import com.srinu.edutrackpro.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponse saveStudent(StudentRequest request) {

        Student student = StudentMapper.toEntity(request);

        Student savedStudent = studentRepository.save(student);

        return StudentMapper.toResponse(savedStudent);
    }

    @Override
    public List<StudentResponse> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::toResponse)
                .toList();
    }

    @Override
    public StudentResponse getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + id));

        return StudentMapper.toResponse(student);
    }

    @Override
    public void deleteStudent(Long id) {

        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest request){

        Student student = studentRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Student not found with id:"+id));

        student.setStudentCode(request.getStudentCode());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setDepartment(request.getDepartment());
        student.setSemester(request.getSemester());
        student.setStatus(request.getStatus());

        Student updateStudent = studentRepository.save(student);

        return StudentMapper.toResponse(updateStudent);
    }
}