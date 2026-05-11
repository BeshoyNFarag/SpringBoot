package com.practice.day1.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    StudentInterface studentInterface;

    @Mock
    StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveStudentTest() {
        // Given - Setup the test data and mock behavior

        // Create input DTO using constructor + setters
        StudentDto inputDto = new StudentDto("John",
                "Doe",
                "john.doe@example.com",
                1,
                23);


        // Create Student entity using constructor + setters
        Student studentEntity = new Student();
        studentEntity.setFName("John");
        studentEntity.setLName("Doe");
        studentEntity.setEmail("john.doe@example.com");
        studentEntity.setAge(20);

        // Create expected response DTO using constructor + setters
        StudentResponseDTO expectedResponse = new StudentResponseDTO("John", "Doe","john.doe@example.com");


        // Mock the mapper converting DTO to Entity
        when(studentMapper.toStudent(inputDto)).thenReturn(studentEntity);

        // Mock the repository save operation
        when(studentInterface.save(studentEntity)).thenReturn(studentEntity);

        // Mock the mapper converting Entity to ResponseDTO
        when(studentMapper.toStudentResponseDto(studentEntity)).thenReturn(expectedResponse);

        // When - Execute the method being tested
        StudentResponseDTO actualResponse = studentService.saveStudent(inputDto);

        // Then - Verify the results and interactions
        assertEquals(expectedResponse.fName(), actualResponse.fName());
        assertEquals(expectedResponse.lName(), actualResponse.lName());
        assertEquals(expectedResponse.email(), actualResponse.email());

        // Note: NO ID assertion because StudentResponseDTO doesn't have an ID field
        // (based on your constructor only taking firstName, lastName, email)

        // Verify mock interactions
        verify(studentMapper, times(1)).toStudent(inputDto);
        verify(studentInterface, times(1)).save(studentEntity);
        verify(studentMapper, times(1)).toStudentResponseDto(studentEntity);
    }

    @Test
    void should_return_all_students() {
        //Given
        List<Student> students = new ArrayList<>();
        Student studentEntity = new Student();
        studentEntity.setFName("John");
        studentEntity.setLName("Doe");
        studentEntity.setEmail("john.doe@example.com");
        studentEntity.setAge(20);
        students.add(studentEntity);
        //When
        when(studentInterface.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDTO("John", "Doe","john.doe@example.com"));

        List<StudentResponseDTO> responseDTOS = studentService.getStudents();
        //Then
        assertEquals(students.size(), responseDTOS.size());
        verify(studentInterface, times(1)).findAll();
    }

    @Test
    void should_return_student_by_id(){
        //Given
        Integer studentId = 1;
        Student studentEntity = new Student();
        studentEntity.setFName("John");
        studentEntity.setLName("Doe");
        studentEntity.setEmail("john.doe@example.com");
        studentEntity.setAge(20);
        //When
        when(studentInterface.findById(studentId)).thenReturn(Optional.of(studentEntity));
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDTO("John", "Doe","john.doe@example.com"));
        StudentResponseDTO responseDTO = studentService.getStudentById(studentId);
        //Then
        assertEquals(responseDTO.fName(), studentEntity.getFName());
        assertEquals(responseDTO.lName(), studentEntity.getLName());
        assertEquals(responseDTO.email(), studentEntity.getEmail());

        verify(studentInterface, times(1)).findById(studentId);

    }

    @Test
    void should_return_student_by_name(){
        //Given
        String studentName = "John";
        Student studentEntity = new Student();
        studentEntity.setFName("John");
        studentEntity.setLName("Doe");
        studentEntity.setEmail("john.doe@example.com");
        studentEntity.setAge(20);
        //When
        when(studentInterface.findByfNameContaining(studentName)).thenReturn(students);
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDTO("John", "Doe","john.doe@example.com"));
        StudentResponseDTO responseDTO = studentService.findByfNameContaining(studentName);
        //Then
        assertEquals(responseDTO.fName(), studentEntity.getFName());
        assertEquals(responseDTO.lName(), studentEntity.getLName());
        assertEquals(responseDTO.email(), studentEntity.getEmail());

        verify(studentInterface, times(1)).findByfNameContaining(studentName);
    }
}