package com.ricardomartinso.social_media.post;


import org.springframework.http.HttpStatus;

public record UserPostsResponse(String message, AllUserPosts data, HttpStatus statusCode) {
}
