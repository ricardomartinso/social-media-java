package com.ricardomartinso.social_media.controllers.post;

import com.ricardomartinso.social_media.dtos.response.PostCommentsResponseDTO;
import com.ricardomartinso.social_media.dtos.UserPostsDTO;
import com.ricardomartinso.social_media.dtos.response.UserPostsResponseDTO;
import com.ricardomartinso.social_media.services.post.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserPostsResponseDTO> getAllPostsByUser(@PathVariable Long userId) {
        UserPostsDTO posts = postService.getAllPostsByUserId(userId);
        return ResponseEntity
                .status(200)
                .body(new UserPostsResponseDTO(
                        "Posts do usuário " + posts.user().username() + " carregados corretamente",
                        posts,
                        HttpStatus.OK));
    }

    @GetMapping("/comments/{postId}")
    public ResponseEntity<PostCommentsResponseDTO> getAllPostCommentsByPost(@PathVariable Long postId) {
        return ResponseEntity
                .status(200)
                .body(new PostCommentsResponseDTO(
                        "Comentários do post carregados corretamente",
                        postService.getAllPostComments(postId),
                        HttpStatus.OK));
    }
}
