package com.practice.day2.model;

import org.springframework.stereotype.Component;

@Component
public class AuthorMapperDTO {

    // Request DTO -> Entity (for saving to database)
    public AuthorEntity toEntity(AuthorRequestDTO request) {
        AuthorEntity entity = new AuthorEntity();
        entity.setAuthorName(request.authorName());
        entity.setNationality(request.nationality());
        return entity;
    }

    // Entity -> Response DTO (for sending back to client)
    public AuthorResponseDTO toResponse(AuthorEntity entity) {
        return new AuthorResponseDTO(
                entity.getAuthorId(),
                entity.getAuthorName(),
                entity.getNationality(),
                entity.getBirthdate()
        );
    }


}