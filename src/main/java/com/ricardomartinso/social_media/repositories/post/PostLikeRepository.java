package com.ricardomartinso.social_media.repositories.post;

import com.ricardomartinso.social_media.model.post.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
}
