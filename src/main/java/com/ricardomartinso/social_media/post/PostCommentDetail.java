package com.ricardomartinso.social_media.post;

import java.util.Date;

public record PostCommentDetail(Long userId, String userImageUrl, String comment, Date postedAt){
}
