package com.br.aspli.alexandresiqueirabackend.services.post;

import lombok.Data;

import java.util.UUID;

@Data
public class CreatePostRequest {
    private String title;
    private String description;
    private String photoUri;
    private UUID userId;
}