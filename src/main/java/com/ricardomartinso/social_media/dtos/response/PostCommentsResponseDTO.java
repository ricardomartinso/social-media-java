package com.ricardomartinso.social_media.dtos.response;

import com.ricardomartinso.social_media.dtos.PostCommentDTO;
import org.springframework.http.HttpStatus;

import java.util.List;

public record PostCommentsResponseDTO(String message, List<PostCommentDTO> data, HttpStatus statusCode) {
}
