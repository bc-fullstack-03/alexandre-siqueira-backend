package com.br.aspli.alexandresiqueirabackend.api;

import com.br.aspli.alexandresiqueirabackend.entities.Post;
import com.br.aspli.alexandresiqueirabackend.services.post.CreatePostRequest;
import com.br.aspli.alexandresiqueirabackend.services.post.FindPostResponse;
import com.br.aspli.alexandresiqueirabackend.services.post.PostService;
import com.br.aspli.alexandresiqueirabackend.services.user.CreateUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/")
    public String createPost(@RequestBody CreatePostRequest request) {
        var response = postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response).toString();
    }

    @GetMapping("/{postId}")
    public ResponseEntity getPost(@PathVariable UUID postId) {
        return ResponseEntity.ok(postService.findById(postId));
    }

    @GetMapping("/")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(postService.findAll());
    }


    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }

}