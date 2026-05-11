package com.practice.day1.student;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentMapper studentMapper;

    private final StudentInterface studentInterface;

    public StudentService(StudentMapper studentMapper, StudentInterface student, StudentInterface studentInterfac) {
        this.studentMapper = studentMapper;

        this.studentInterface = studentInterfac;
    }

    public StudentResponseDTO saveStudent(StudentDto dto) {
        var student = studentMapper.toStudent(dto);
        var savedStudent =studentInterface.save(student);


        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<StudentResponseDTO> getStudents(){
        return studentInterface.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public StudentResponseDTO getStudentById(int id) {
        return studentMapper.toStudentResponseDto(studentInterface.findById(id).get());
    }

    public List<StudentResponseDTO> getStudentsByName(String name) {
        return studentInterface.findByfNameContaining(name).stream()
                .map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
    }
}
