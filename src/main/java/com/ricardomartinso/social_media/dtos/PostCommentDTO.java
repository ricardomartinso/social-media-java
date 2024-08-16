package com.ricardomartinso.social_media.dtos;

import java.util.Date;

public record PostCommentDTO (Long userId, String userImageUrl, String comment, Date postedAt){
}
