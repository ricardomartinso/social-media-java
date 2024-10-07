package com.ricardomartinso.social_media.dtos.request;

public record CreateUserRequestDTO(String username, String password, String email, String first_name, String last_name) {
}
