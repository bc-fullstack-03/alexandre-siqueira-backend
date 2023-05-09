package com.br.aspli.alexandresiqueirabackend.services.user;

import java.util.UUID;

public class FindUserResponse {
    public UUID id;
    public String name;
    public String email;
    public String photoUri;

    public FindUserResponse(UUID id, String name, String email, String photoUri) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.photoUri = photoUri;
    }
}