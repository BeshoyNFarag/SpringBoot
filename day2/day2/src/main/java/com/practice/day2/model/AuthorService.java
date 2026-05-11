package com.practice.day2.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorMapperDTO mapper;  // Spring injects it

    @Autowired
    private AuthorRepo repo;

    public AuthorResponseDTO createAuthor(AuthorRequestDTO request) {
        // Convert request DTO to entity
        AuthorEntity entity = mapper.toEntity(request);

        // Save to database
        AuthorEntity saved = repo.save(entity);

        // Convert entity to response DTO and return
        return mapper.toResponse(saved);
    }
}
