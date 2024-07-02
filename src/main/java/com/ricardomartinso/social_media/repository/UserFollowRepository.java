package com.ricardomartinso.social_media.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardomartinso.social_media.model.user.UserFollow;

public interface UserFollowRepository extends JpaRepository<UserFollow, Long> {

}
