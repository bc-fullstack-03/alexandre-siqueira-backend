package com.br.aspli.alexandresiqueirabackend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "profiles")
public class Profile {

    @Id
    private String id;
    @TextIndexed
    private String name;
    private String email;
    private String imageUrl;
    @DBRef
    private User user;
    @DBRef
    private Set<Profile> following;
    @DBRef
    private Set<Profile> followers;

}

