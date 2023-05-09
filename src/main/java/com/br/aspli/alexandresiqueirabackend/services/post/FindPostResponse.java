package com.br.aspli.alexandresiqueirabackend.services.post;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
public class FindPostResponse {
    private UUID id;
    private String title;
    private String description;
    private String photoUri;
    private UUID userId;

    public FindPostResponse(UUID id, String title, String description, String photoUri, UUID userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.photoUri = photoUri;
        this.userId = userId;
    }
}
