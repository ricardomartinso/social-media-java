package com.ricardomartinso.social_media.repositories.post;

import com.ricardomartinso.social_media.model.post.Post;
import com.ricardomartinso.social_media.model.post.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    List<PostComment> findAllCommentsByPost(Post post);
}
