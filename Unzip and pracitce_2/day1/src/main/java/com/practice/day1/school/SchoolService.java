package com.practice.day1.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepository schoolRepo;

    private final SchoolMapper schoolMapper;






    public SchoolService(SchoolRepository schoolRepo, SchoolMapper schoolMapper) {
        this.schoolRepo = schoolRepo;

        this.schoolMapper = schoolMapper;

    }

    public List<SchoolResponseDto> getAll() {


        return schoolRepo.findAll().stream().map(schoolMapper::toSchoolResponseDto).collect(Collectors.toList());
    }

    public SchoolDto addSchools(@RequestBody SchoolDto dto) {

        var school = schoolMapper.toSchool(dto);
        schoolRepo.save(school);
        return dto;
    }

    public List<SchoolResponseDto> findAll(){

        return schoolRepo.findAll().stream().map(schoolMapper::toSchoolResponseDto).collect(Collectors.toList());
    }

//    public SchoolDto getSchoolDto() {
//        return schoolDto;
//    }
}
