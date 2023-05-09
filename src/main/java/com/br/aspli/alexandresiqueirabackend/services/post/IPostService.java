package com.br.aspli.alexandresiqueirabackend.services.post;

import java.util.List;
import java.util.UUID;

public interface IPostService {
    List<FindPostResponse> findAll();
    FindPostResponse findById(UUID id);
    FindPostResponse create(CreatePostRequest request);
}
