package com.practice.day2;

import jakarta.persistence.*;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "Authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int authorId;
    @Column(nullable = false)
    String authorName;
    @Column(nullable = false)
    LocalDate birthdate;
    @Column(nullable = false)
    String nationality;

    @OneToMany(mappedBy = "author")
    List<BookEntity> books;

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }

    public AuthorEntity() {

    }


    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
