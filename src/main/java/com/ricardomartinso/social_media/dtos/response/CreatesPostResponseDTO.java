package com.ricardomartinso.social_media.dtos.response;

import com.ricardomartinso.social_media.dtos.PostDTO;
import org.springframework.http.HttpStatus;


public record CreatesPostResponseDTO(
        String message,
        PostDTO data,
        HttpStatus statusCode) {
}
