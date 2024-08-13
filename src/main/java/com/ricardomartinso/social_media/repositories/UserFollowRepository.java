package com.ricardomartinso.social_media.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardomartinso.social_media.model.user.UserFollow;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFollowRepository extends JpaRepository<UserFollow, Long> {
    List<UserFollow> findByUserId(Long userId);
}
