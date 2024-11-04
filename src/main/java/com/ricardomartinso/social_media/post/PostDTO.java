package com.ricardomartinso.social_media.post;

import java.util.Date;

public record PostDTO(Long id, String username, String content, String imageUrl , Date createdAt) {
}
