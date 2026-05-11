package com.practice.day1.student;

import jakarta.validation.constraints.NotEmpty;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
class StudentMapperTest {


    private static StudentMapper mapper;

    @BeforeAll
    static void setup(){
        mapper = new StudentMapper();

    }

    @Test
    public void shouldMapStudenttoDToSudent(){

        StudentDto studentDto = new StudentDto(
                "Beshoy",
                "Farag",
                "beshoynady401@gmail.com",
                1,
                23);
        Student student = mapper.toStudent(studentDto);
        assertEquals(studentDto.fName(), student.getFName());
        assertEquals(studentDto.lName(), student.getLName());
        assertEquals(studentDto.email(), student.getEmail());
        assertEquals(studentDto.age(), student.getAge());
        assertNotNull(studentDto.schoolId());
        assertNotNull(student.getStudentId());

    }

    @Test
    public void shouldMapStudenttoResponse(){
        //Given
        Student student = new Student();
        student.setFName("Beshoy");
        student.setLName("Farag");
        student.setEmail("beshoynady401@gmail.com");
        student.setAge(23);

        //When
        StudentResponseDTO studentResponseDTO = mapper.toStudentResponseDto(student);

        //Then
        assertEquals(student.getFName(), studentResponseDTO.fName());
        assertEquals(student.getLName(), studentResponseDTO.lName());
        assertEquals(student.getEmail(), studentResponseDTO.email());


    }

    @Test
    void should_handle_dto_is_null(){
       var message = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
       assertEquals("dto cannot be null",message.getMessage());

    }
}