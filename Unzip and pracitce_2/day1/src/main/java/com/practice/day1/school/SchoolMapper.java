package com.practice.day1.school;


import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {


    public School toSchool(SchoolDto dto){
        var school = new School();
        school.setName(dto.schoolName());



        return school;

    }

    public SchoolResponseDto toSchoolResponseDto(School school) {

        return new SchoolResponseDto(school.getName());
    }
}
