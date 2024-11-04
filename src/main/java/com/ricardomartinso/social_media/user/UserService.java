package com.ricardomartinso.social_media.user;

import com.ricardomartinso.social_media.errors.exceptions.UserAlreadyExistException;
import com.ricardomartinso.social_media.errors.exceptions.UserNotFoundException;
import com.ricardomartinso.social_media.auth.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        return user.get();

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        return user
                .map(UserAuthenticated::new)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
