package com.ricardomartinso.social_media.errors.exceptions;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(String message) {
        super(message);
    }

    public PostNotFoundException(Long postId) {
        super("Post with id " + postId + " not found");
    }

    public PostNotFoundException() {
        super("Post not found");
    }
}
