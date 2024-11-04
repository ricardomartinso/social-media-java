package com.ricardomartinso.social_media.post;

import com.ricardomartinso.social_media.errors.exceptions.PostNotFoundException;
import com.ricardomartinso.social_media.errors.exceptions.UserNotFoundException;
import com.ricardomartinso.social_media.user.User;
import com.ricardomartinso.social_media.user.UserRepository;
import com.ricardomartinso.social_media.util.EntityToDTOConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostLikeRepository postLikeRepository;
    private final PostCommentRepository postCommentRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository, PostLikeRepository postLikeRepository, PostCommentRepository postCommentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.postLikeRepository = postLikeRepository;
        this.postCommentRepository = postCommentRepository;
    }

    public AllUserPosts getAllPostsByUserId(Long userId) {

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            throw new UserNotFoundException(userId);
        }

        List<Post> posts = postRepository.findByUserId(user.get().getId());

        List<PostDTO> postsDTO = posts
                .stream()
                .map(EntityToDTOConverter::convertToPostDTO)
                .toList();

        return new AllUserPosts(postsDTO);
    }

    public List<PostCommentDetail> getAllPostComments(Long postId) {
        Optional<Post> post = postRepository.findById(postId);

        if (post.isEmpty()) {
            throw new PostNotFoundException(postId);
        }

        List<PostComment> comments = postCommentRepository.findAllCommentsByPost(post.get());

        return comments
                .stream()
                .map(EntityToDTOConverter::convertToPostCommentDTO).toList();

    }
}
