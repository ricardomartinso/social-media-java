package com.ricardomartinso.social_media.dtos;

import java.util.List;

public record UserPostsDTO (UserDTO user, List<PostDTO> posts) {
}
