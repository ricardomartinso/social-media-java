package com.ricardomartinso.social_media.services.user;

import com.ricardomartinso.social_media.model.user.User;
import com.ricardomartinso.social_media.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        return user.get();

    }
}
