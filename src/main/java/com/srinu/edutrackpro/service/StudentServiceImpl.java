package com.srinu.edutrackpro.service;

import com.srinu.edutrackpro.dto.StudentRequest;
import com.srinu.edutrackpro.dto.StudentResponse;
import com.srinu.edutrackpro.entity.Student;
import com.srinu.edutrackpro.entity.StudentStatus;
import com.srinu.edutrackpro.exception.StudentNotFoundException;
import com.srinu.edutrackpro.mapper.StudentMapper;
import com.srinu.edutrackpro.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
                        new StudentNotFoundException(
                                "Student not found with id: " + id));

        return StudentMapper.toResponse(student);
    }

    @Override
    public void deleteStudent(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id: " + id));

        studentRepository.delete(student);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest request) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id: " + id));

        student.setStudentCode(request.getStudentCode());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setDepartment(request.getDepartment());
        student.setSemester(request.getSemester());
        student.setStatus(request.getStatus());

        Student updatedStudent = studentRepository.save(student);

        return StudentMapper.toResponse(updatedStudent);
    }

    @Override
    public Page<StudentResponse> getStudents(
            int page,
            int size,
            String sortBy){

        Pageable pageable =
                PageRequest.of(page,size,Sort.by(sortBy));

        return studentRepository.findAll(pageable)
                .map(StudentMapper::toResponse);
    }

    @Override
    public StudentResponse getStudentByEmail(String email){

        Student student = studentRepository.findByEmail(email)
                .orElseThrow(()->
                        new StudentNotFoundException(
                                "Student not found with email:"+email));

        return StudentMapper.toResponse(student);
    }

    @Override
    public List<StudentResponse> getStudentByDepartment(String department){

        return studentRepository.findByDepartment(department)
                .stream()
                .map(StudentMapper::toResponse)
                .toList();
    }

    @Override
    public List<StudentResponse> getStudentByStatus(StudentStatus status){

        return studentRepository.findByStatus(status)
                .stream()
                .map(StudentMapper::toResponse)
                .toList();
    }
}