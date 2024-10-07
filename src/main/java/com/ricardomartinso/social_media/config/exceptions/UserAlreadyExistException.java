package com.ricardomartinso.social_media.config.exceptions;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException() {
        super("User already exists");
    }
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
