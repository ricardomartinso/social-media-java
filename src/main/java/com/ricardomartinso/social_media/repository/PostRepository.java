package com.ricardomartinso.social_media.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardomartinso.social_media.model.post.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
