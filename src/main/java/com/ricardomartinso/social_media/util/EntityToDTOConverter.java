package com.ricardomartinso.social_media.util;

import com.ricardomartinso.social_media.dtos.PostCommentDTO;
import com.ricardomartinso.social_media.dtos.PostDTO;
import com.ricardomartinso.social_media.dtos.UserDTO;
import com.ricardomartinso.social_media.model.post.Post;
import com.ricardomartinso.social_media.model.post.PostComment;
import com.ricardomartinso.social_media.model.user.User;

public class EntityToDTOConverter {

    public static PostDTO convertToPostDTO(Post post) {
        return new PostDTO(post.getId(), post.getContent(), post.getImageUrl(), post.getCreatedAt());
    }

    public static UserDTO convertToUserDTO(User user) {
        return new UserDTO(user.getUsername(), user.getEmail());
    }

    public static PostCommentDTO convertToPostCommentDTO(PostComment postComment) {
        return new PostCommentDTO(postComment.getUser().getId(), postComment.getUser().getImageUrl() ,postComment.getComment(), postComment.getCreatedAt());
    }
}
