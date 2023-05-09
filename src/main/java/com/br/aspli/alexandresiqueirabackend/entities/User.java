package com.br.aspli.alexandresiqueirabackend.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class User {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String photoUri;

    public User(String name, String email) {
        this.setId();
        this.name = name;
        this.email = email;
    }

    protected void setId() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return this.id;
    }
}