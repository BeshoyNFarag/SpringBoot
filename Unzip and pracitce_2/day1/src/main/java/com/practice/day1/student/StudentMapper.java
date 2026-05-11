package com.practice.day1.student;


import com.practice.day1.school.School;
import com.practice.day1.school.SchoolRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto) {
        if(dto == null) {
            throw new NullPointerException("dto cannot be null");
        }
        var student = new Student();
        student.setEmail(dto.email());
        student.setFName(dto.fName());
        student.setLName(dto.lName());
        student.setAge(dto.age());


        return student;
    }

    public StudentResponseDTO toStudentResponseDto(Student student) {

        return new StudentResponseDTO(student.getFName(), student.getLName(), student.getEmail());
    }

}
