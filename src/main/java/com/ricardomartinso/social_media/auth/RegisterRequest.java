package com.ricardomartinso.social_media.auth;

public record RegisterRequest(String username, String password, String email, String first_name, String last_name) {
}
