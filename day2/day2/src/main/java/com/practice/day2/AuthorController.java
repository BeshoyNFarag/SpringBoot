package com.practice.day2;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthorController {

    private final AuthorRepo authorRepo;


    public AuthorController(AuthorRepo authorRepo) {  // Add constructor
        this.authorRepo = authorRepo;
    }



    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorEntity addAuthor(@RequestBody AuthorEntity author) {
        return authorRepo.save(author);
    }

    @GetMapping("/author/{id}")
    public Optional<AuthorEntity> getAuthor(@PathVariable int id) {
        return authorRepo.findById(id);
    }
}
