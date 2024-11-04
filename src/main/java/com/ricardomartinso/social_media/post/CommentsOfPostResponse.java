package com.ricardomartinso.social_media.post;

import org.springframework.http.HttpStatus;

import java.util.List;

public record CommentsOfPostResponse(String message, List<PostCommentDetail> data, HttpStatus statusCode) {
}
