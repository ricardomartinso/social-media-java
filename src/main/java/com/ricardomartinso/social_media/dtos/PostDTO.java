package com.ricardomartinso.social_media.dtos;

import java.util.Date;

public record PostDTO(Long id, String content, String imageUrl , Date createdAt) {
}
