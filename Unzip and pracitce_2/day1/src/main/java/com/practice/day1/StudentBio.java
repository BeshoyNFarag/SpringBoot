package com.practice.day1;


import jakarta.persistence.*;

@Entity
public class StudentBio {


    @Id
    @GeneratedValue
    private int id;

    private String bio;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public StudentBio() {
    }

    public StudentBio(String bio) {
        this.bio = bio;
    }
}
