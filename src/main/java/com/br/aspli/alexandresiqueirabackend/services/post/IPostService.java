package com.br.aspli.alexandresiqueirabackend.services.post;

import com.br.aspli.alexandresiqueirabackend.services.user.CreateUserRequest;

import java.util.List;
import java.util.UUID;

public interface IPostService {
    List<FindPostResponse> findAll();
    FindPostResponse findById(UUID id);
    String createPost(CreatePostRequest request);
    String deletePost(UUID id);

}
