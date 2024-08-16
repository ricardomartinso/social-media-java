package com.ricardomartinso.social_media.config;

import com.ricardomartinso.social_media.config.exceptions.PostNotFoundException;
import com.ricardomartinso.social_media.config.exceptions.UserNotFoundException;
import com.ricardomartinso.social_media.dtos.response.ResponseErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseErrorDTO> handleUserNotFoundException(UserNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ResponseErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND.name()));
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ResponseErrorDTO> handlePostNotFoundException(PostNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ResponseErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND.name()));
    }
}
