package com.practice.day2;

import jakarta.persistence.*;

import java.time.Year;
import java.util.List;

@Entity

@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bookId;

    @Column(nullable = false)
    String title;
    @Column(nullable = false, unique = true)
    String ISBN;
    @Column(nullable = false)
    Year publicationYear;

    @Column(nullable = false)
    double price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    AuthorEntity author;

    @OneToMany(mappedBy = "book")
    List<LoanEntity> loan;

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

    public BookEntity() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Year getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Year publicationYear) {
        this.publicationYear = publicationYear;
    }

    public List<LoanEntity> getLoan() {
        return loan;
    }

    public void setLoan(List<LoanEntity> loan) {
        this.loan = loan;
    }
}
