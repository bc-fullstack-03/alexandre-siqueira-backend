package com.br.aspli.alexandresiqueirabackend.services.post;

import com.br.aspli.alexandresiqueirabackend.data.PostRepository;
import com.br.aspli.alexandresiqueirabackend.data.UserRepository;
import com.br.aspli.alexandresiqueirabackend.entities.Post;
import com.br.aspli.alexandresiqueirabackend.entities.User;
import com.br.aspli.alexandresiqueirabackend.services.exceptions.EntityNotFoundException;
import com.br.aspli.alexandresiqueirabackend.services.user.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    private UserService userService;

    @Override
    public List<FindPostResponse> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapToFindPostResponse).collect(Collectors.toList());
    }

    @Override
    public FindPostResponse findById(UUID id) {
        Post post = postRepository.findById(id.toString()).orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + id));
        return mapToFindPostResponse(post);
    }

    @Override
    public String createPost(CreatePostRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + request.getUserId()));
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setDescription(request.getDescription());
        post.setPhotoUri(request.getPhotoUri());
        post.setUserId(user.getId());
        post = postRepository.save(post);
        return mapToFindPostResponse(post).toString();
    }

    @Override
    public String deletePost(UUID id) throws EntityNotFoundException {
        Optional<Post> postOptional = postRepository.findById(id.toString());
        if (postOptional.isPresent()) {
            Post post = postOptional.get();
            postRepository.delete(post);
            return mapToFindPostResponse(post).toString();
        } else {
            throw new EntityNotFoundException("Post with id " + id + " not found.");
        }
    }
    private FindPostResponse mapToFindPostResponse(Post post) {
        FindPostResponse response = new FindPostResponse();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setDescription(post.getDescription());
        response.setPhotoUri(post.getPhotoUri());
        response.setUserId(post.getUserId());
        return response;
    }

}
