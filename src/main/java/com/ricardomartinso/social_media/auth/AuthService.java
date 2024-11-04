package com.ricardomartinso.social_media.auth;

import com.ricardomartinso.social_media.errors.exceptions.UserAlreadyExistException;
import com.ricardomartinso.social_media.user.User;
import com.ricardomartinso.social_media.user.UserAuthenticated;
import com.ricardomartinso.social_media.user.UserRepository;
import com.ricardomartinso.social_media.user.UserService;
import com.ricardomartinso.social_media.token.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final TokenService tokenService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(final TokenService tokenService, final UserService userService, final AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.tokenService = tokenService;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest newUser) {
        String encryptedPassword = passwordEncoder.encode(newUser.password());

        Optional<User> username = userRepository.findByUsername(newUser.username());
        Optional<User> userEmail = userRepository.findByEmail(newUser.email());

        if (username.isPresent() || userEmail.isPresent()) {
            throw new UserAlreadyExistException();
        }

        userRepository.save(new User(newUser, encryptedPassword));
    }

    public AuthenticateResponse authenticate(AuthenticateRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.username(),
                request.password()
        ));

        UserAuthenticated userAuthenticated = new UserAuthenticated(userService.getUserByUsername(request.username()));

        var jwtToken = tokenService.generateToken(userAuthenticated);
        var refreshToken = tokenService.generateRefreshToken(userAuthenticated);
        tokenService.revokeAllUserTokens(userAuthenticated.getUser());
        tokenService.saveToken(userAuthenticated.getUser(), jwtToken);

        return new AuthenticateResponse(jwtToken, refreshToken);
    }



}
