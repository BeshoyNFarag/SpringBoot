package com.practice.day2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {
}
