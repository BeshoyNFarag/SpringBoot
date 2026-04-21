package com.practice.day1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FirstController {


    private final StudentInterface student;


    @Autowired
    public FirstController(StudentInterface student) {
        this.student = student;
    }


    @GetMapping("/student/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public Student printMessage(@PathVariable("student-id") int studentId) {
        return student.findById(studentId).orElse(null);
    }

    @PostMapping("student")
    @ResponseStatus(HttpStatus.CREATED)
    public void printUser( @RequestBody Student studentInput){


         student.save(studentInput);

    }

    @GetMapping("students")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents(){

        return student.findAll();
    }

    @GetMapping("students/search/{FName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> searchStudent(@PathVariable("FName") String FName){

        return student.findByfNameContaining(FName);

    }

    @DeleteMapping("students/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable("id") int id){

         student.deleteById(id);

    }


}
