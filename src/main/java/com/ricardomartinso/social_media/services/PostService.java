package com.ricardomartinso.social_media.services;

import com.ricardomartinso.social_media.dtos.PostDTO;
import com.ricardomartinso.social_media.dtos.UsersPostsResponseDTO;
import com.ricardomartinso.social_media.model.post.Post;
import com.ricardomartinso.social_media.model.user.User;
import com.ricardomartinso.social_media.repositories.PostRepository;
import com.ricardomartinso.social_media.repositories.UserRepository;
import com.ricardomartinso.social_media.util.EntityToDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public UsersPostsResponseDTO getAllPostsByUserId(Long userId) {

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        List<Post> posts = postRepository.findByUserId(user.get().getId());

        List<PostDTO> postsDTO = posts
                .stream()
                .map(EntityToDTOConverter::convertToPostDTO)
                .toList();

        return new UsersPostsResponseDTO(EntityToDTOConverter.convertToUserDTO(user.get()), postsDTO);
    }
}
