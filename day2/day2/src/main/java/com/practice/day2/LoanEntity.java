package com.practice.day2;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class LoanEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    @Column(nullable = false, columnDefinition = "date default now()")
    LocalDate borrowDate;
    @Column(nullable = false, columnDefinition = "date default now()")
    LocalDate dueDate;
    @Column(nullable = false, columnDefinition = "date default now()")
    LocalDate returnDate;

    @ManyToOne()
    @JoinColumn(name= "borrower_id")
    BorrowerEntity borrower;


    @ManyToOne()
    @JoinColumn(name= "book_id")
    BookEntity book;

    public LoanEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public BorrowerEntity getBorrower() {
        return borrower;
    }

    public void setBorrower(BorrowerEntity borrower) {
        this.borrower = borrower;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
