package com.practice.day1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {


    private final SchoolRepository schoolRepo;

    public SchoolController(SchoolRepository schoolRepo) {
        this.schoolRepo = schoolRepo;
    }

    @PostMapping("/schools")
    public SchoolDto addSchools(@RequestBody SchoolDto dto) {

        var school = toSchool(dto);
        schoolRepo.save(school);
        return dto;
    }

    private School toSchool (SchoolDto dto) {

        School school = new School(dto.schoolName());
        return school;
    }

    private SchoolDto toSchoolDto (School school) {

        return new SchoolDto(school.getName());
    }
    @GetMapping("/schools")
    public List<SchoolDto> findAll() {


        return schoolRepo.findAll().stream().map(this::toSchoolDto).collect(Collectors.toList());
    }
}
