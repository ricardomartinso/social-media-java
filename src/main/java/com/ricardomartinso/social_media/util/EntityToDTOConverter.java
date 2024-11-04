package com.ricardomartinso.social_media.util;

import com.ricardomartinso.social_media.post.PostCommentDetail;
import com.ricardomartinso.social_media.post.PostDTO;
import com.ricardomartinso.social_media.user.UserDTO;
import com.ricardomartinso.social_media.post.Post;
import com.ricardomartinso.social_media.post.PostComment;
import com.ricardomartinso.social_media.user.User;

public class EntityToDTOConverter {

    public static PostDTO convertToPostDTO(Post post) {
        return new PostDTO(post.getId(), post.getUser().getUsername(), post.getContent(), post.getImageUrl(), post.getCreatedAt());
    }

    public static UserDTO convertToUserDTO(User user) {
        return new UserDTO(user.getUsername(), user.getEmail());
    }

    public static PostCommentDetail convertToPostCommentDTO(PostComment postComment) {
        return new PostCommentDetail(postComment.getUser().getId(), postComment.getUser().getImageUrl() ,postComment.getComment(), postComment.getCreatedAt());
    }
}
