package com.ricardomartinso.social_media.post;

import org.springframework.http.HttpStatus;


public record CreatePostResponse(
        String message,
        PostDTO data,
        HttpStatus statusCode) {
}
