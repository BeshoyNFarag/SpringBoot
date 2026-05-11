package com.practice.day1.student;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/student/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponseDTO printMessage(@PathVariable("student-id") int studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping("students")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponseDTO saveStudent( @Valid @RequestBody StudentDto dto){

        return studentService.saveStudent(dto);
    }




    @GetMapping("students")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponseDTO> getAllStudents(){

        return studentService.getStudents();
    }

    @GetMapping("students/search/{FName}")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponseDTO> searchStudent(@PathVariable("FName") String FName){

        return studentService.getStudentsByName(FName);

    }

//    @DeleteMapping("students/delete/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteStudent(@PathVariable("id") int id){
//
//        studentService.deleteById(id);
//
//    }

    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach(error -> {

            var fieldName = ((FieldError)error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
