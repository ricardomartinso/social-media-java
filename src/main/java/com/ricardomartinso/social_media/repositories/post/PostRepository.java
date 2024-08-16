package com.ricardomartinso.social_media.repositories.post;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardomartinso.social_media.model.post.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long userId);
}
