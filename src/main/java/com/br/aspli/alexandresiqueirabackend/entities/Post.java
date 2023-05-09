package com.br.aspli.alexandresiqueirabackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("posts")
public class Post {
    @Id
    private UUID id;
    private String title;
    private String description;
    private String photoUri;
    private UUID userId;

    protected void setId() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return this.id;
    }
}

