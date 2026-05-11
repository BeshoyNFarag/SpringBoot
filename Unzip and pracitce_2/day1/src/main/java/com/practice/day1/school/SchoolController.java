package com.practice.day1.school;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {


    private final SchoolRepository schoolRepo;
    private final SchoolService schoolService;

    public SchoolController(SchoolRepository schoolRepo, SchoolService schoolService) {
        this.schoolRepo = schoolRepo;
        this.schoolService = schoolService;
    }

    @PostMapping("/schools")
    public SchoolDto addSchools(@RequestBody SchoolDto dto) {

        return schoolService.addSchools(dto);
    }


    @GetMapping("/schools")
    public List<SchoolResponseDto> findAll() {


        return schoolService.findAll();
    }
}
