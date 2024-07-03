package com.ricardomartinso.social_media.dtos;


import java.util.List;

public record UsersPostsResponseDTO(UserDTO user, List<PostDTO> posts) {
}
