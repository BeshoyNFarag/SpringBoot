package com.practice.day1;


import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentMapper studentMapper;
    private final StudentInterface student;
    private final StudentInterface studentInterfac;

    public StudentService(StudentMapper studentMapper, StudentInterface student, StudentInterface studentInterfac) {
        this.studentMapper = studentMapper;
        this.student = student;
        this.studentInterfac = studentInterfac;
    }

    public StudentResponseDTO saveStudent(StudentDto dto) {
        var student = studentMapper.toStudent(dto);
        var savedStudent =studentInterfac.save(student);


        return studentMapper.toStudentResponseDto(savedStudent);
    }
}
