package com.ricardomartinso.social_media.services.post;

import com.ricardomartinso.social_media.config.exceptions.PostNotFoundException;
import com.ricardomartinso.social_media.config.exceptions.UserNotFoundException;
import com.ricardomartinso.social_media.dtos.PostCommentDTO;
import com.ricardomartinso.social_media.dtos.PostDTO;
import com.ricardomartinso.social_media.dtos.UserPostsDTO;
import com.ricardomartinso.social_media.model.post.Post;
import com.ricardomartinso.social_media.model.post.PostComment;
import com.ricardomartinso.social_media.model.user.User;
import com.ricardomartinso.social_media.repositories.post.PostCommentRepository;
import com.ricardomartinso.social_media.repositories.post.PostLikeRepository;
import com.ricardomartinso.social_media.repositories.post.PostRepository;
import com.ricardomartinso.social_media.repositories.user.UserRepository;
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

    public UserPostsDTO getAllPostsByUserId(Long userId) {

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            throw new UserNotFoundException(userId);
        }

        List<Post> posts = postRepository.findByUserId(user.get().getId());

        List<PostDTO> postsDTO = posts
                .stream()
                .map(EntityToDTOConverter::convertToPostDTO)
                .toList();

        return new UserPostsDTO(EntityToDTOConverter.convertToUserDTO(user.get()), postsDTO);
    }

    public List<PostCommentDTO> getAllPostComments(Long postId) {
        Optional<Post> post = postRepository.findById(postId);

        if (post.isEmpty()) {
            throw new PostNotFoundException(postId);
        }

        List<PostComment> comments = postCommentRepository.findAllCommentsByPost(post.get());

        return comments.stream()
                        .map(EntityToDTOConverter::convertToPostCommentDTO).toList();

    }
}
