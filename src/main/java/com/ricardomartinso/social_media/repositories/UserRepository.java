package com.ricardomartinso.social_media.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardomartinso.social_media.model.user.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
