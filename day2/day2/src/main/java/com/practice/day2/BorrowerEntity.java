package com.practice.day2;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class BorrowerEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int borrowerId;
    @Column(unique=false, nullable=false)
    String name;
    @Column(unique=true, nullable=false)
    String email;
    @Column(columnDefinition = "date default now()")
    LocalDate membershipDate;


    @OneToMany(mappedBy = "borrower")
    List<LoanEntity> loan;

    public BorrowerEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }

    public List<LoanEntity> getLoan() {
        return loan;
    }

    public void setLoan(List<LoanEntity> loan) {
        this.loan = loan;
    }
}
