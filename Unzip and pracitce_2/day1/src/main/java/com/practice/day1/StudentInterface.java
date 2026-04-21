package com.practice.day1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentInterface extends JpaRepository <Student, Integer> {

    List<Student> findByfNameContaining(String FName);
}
