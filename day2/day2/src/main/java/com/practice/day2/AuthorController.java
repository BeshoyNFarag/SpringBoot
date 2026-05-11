package com.practice.day2;


import com.practice.day2.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    private final AuthorService authorService;


    public AuthorController( AuthorService authorService) {
        this.authorService = authorService;  // Add constructor

    }



    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponseDTO addAuthor(@RequestBody AuthorRequestDTO request) {
        return authorService.createAuthor(request);
    }

//    @GetMapping("/author/{id}")
//    public Optional<AuthorEntity> getAuthor(@PathVariable int id) {
//        return authorRepo.findById(id);
//    }
//
//    @GetMapping("/authors")
//    public List<AuthorEntity> getAuthors() {
//        return authorRepo.findAll();
//    }

}
