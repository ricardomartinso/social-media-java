package com.ricardomartinso.social_media.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authenticate")
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticateResponse> login(@RequestBody AuthenticateRequest request) {
        LOG.debug("Login requested for user : '{}'", request.username());
        AuthenticateResponse response  = authService.authenticate(request);
        LOG.debug("Token generated: '{}'", response.accessToken());
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest newUser) {
        LOG.debug("Signup requested for user : '{}'", newUser.username());
        authService.register(newUser);
        return ResponseEntity.status(200).body("CREATED");
    }
}
