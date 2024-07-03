package com.ricardomartinso.social_media.controllers;

import com.ricardomartinso.social_media.dtos.UsersPostsResponseDTO;
import com.ricardomartinso.social_media.model.post.Post;
import com.ricardomartinso.social_media.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UsersPostsResponseDTO> getAllPostsByUser(@PathVariable Long userId) {
        UsersPostsResponseDTO posts = postService.getAllPostsByUserId(userId);

        return ResponseEntity.status(200).body(posts);
    }
}
