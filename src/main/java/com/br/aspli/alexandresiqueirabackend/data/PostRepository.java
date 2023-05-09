package com.br.aspli.alexandresiqueirabackend.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.br.aspli.alexandresiqueirabackend.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}

