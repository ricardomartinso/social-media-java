package com.ricardomartinso.social_media.post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreatePostResponse> createsPost(CreatePostRequest createPostRequest) {
        //TODO
        return null;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserPostsResponse> getAllPostsByUser(@PathVariable Long userId) {
        AllUserPosts posts = postService.getAllPostsByUserId(userId);
        return ResponseEntity
                .status(200)
                .body(new UserPostsResponse(
                        "Posts carregados corretamente",
                        posts,
                        HttpStatus.OK));
    }

    @GetMapping("/comments/{postId}")
    public ResponseEntity<CommentsOfPostResponse> getAllPostCommentsByPost(@PathVariable Long postId) {
        return ResponseEntity
                .status(200)
                .body(new CommentsOfPostResponse(
                        "Comentários do post carregados corretamente",
                        postService.getAllPostComments(postId),
                        HttpStatus.OK));
    }
}
