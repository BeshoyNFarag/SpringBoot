package com.practice.day1;


import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto){
        var student = new Student();
        student.setEmail(dto.email());
        student.setFName(dto.fName());
        student.setLName(dto.lName());

        var school = new School();
        school.setId(dto.Id());

        student.setSchool(school);
        return student;

    }

    public StudentResponseDTO toStudentResponseDto( Student student) {

        return new StudentResponseDTO(student.getFName(), student.getLName(), student.getEmail());
    }

}
