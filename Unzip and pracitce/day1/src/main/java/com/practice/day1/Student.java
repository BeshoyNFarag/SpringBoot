package com.practice.day1;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.Session;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue
    private int id;
    private String fName;
    private String lName;
    private int age;



    public Student() {
    }

    public Student(String fName, int age, String lName) {
        this.fName = fName;
        this.age = age;
        this.lName = lName;
    }

   Session session;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
