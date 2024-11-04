package com.ricardomartinso.social_media.errors.exceptions;

public class UserNotFoundException extends RuntimeException {


    public UserNotFoundException() {
        super("User not found");
    }

    public UserNotFoundException(Long id) {
        super("User with id " + id + " not found");
    }
}
