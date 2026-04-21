package com.practice.day1;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "f_name")
    private String fName;

    @Column(name = "l_name")
    private String lName;

    private int age;
    private String email;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "student")
    private StudentBio studentProfile;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")
    private School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public StudentBio getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentBio studentProfile) {
        this.studentProfile = studentProfile;
    }

    public Student() {}

    public Student(String fName, int age, String lName, String email) {
        this.fName = fName;
        this.age = age;
        this.lName = lName;
        this.email = email;
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getFName() {  // Capital F
        return fName;
    }

    public String getLName() {  // Capital L
        return lName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFName(String fName) {  // Capital F
        this.fName = fName;
    }

    public void setLName(String lName) {  // Capital L
        this.lName = lName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}