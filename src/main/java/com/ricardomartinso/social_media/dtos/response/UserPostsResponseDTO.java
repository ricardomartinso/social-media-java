package com.ricardomartinso.social_media.dtos.response;


import com.ricardomartinso.social_media.dtos.UserPostsDTO;
import org.springframework.http.HttpStatus;

public record UserPostsResponseDTO(String message, UserPostsDTO data, HttpStatus statusCode) {
}
