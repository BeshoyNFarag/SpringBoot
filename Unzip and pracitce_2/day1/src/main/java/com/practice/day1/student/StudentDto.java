package com.practice.day1.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(

        @NotEmpty(message = "first name aint empty fam")
        String fName,
        @NotEmpty(message = "last name aint empty fam on g")
        String lName,

        String email,
        int schoolId,
        int age
) {
}
