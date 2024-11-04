package com.ricardomartinso.social_media.post;


import org.springframework.http.HttpStatus;

public record UserPostsResponse(String message, AllUserPostsDTO data, HttpStatus statusCode) {
}
