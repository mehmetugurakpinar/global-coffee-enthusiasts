package com.globalcoffeeenthusiasts.adapters.user.rest.dto;

import com.globalcoffeeenthusiasts.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String username;
    private String email;
    private String password;
    private String profilePictureUrl;

    public static UserResponse from(User user) {
        return builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .profilePictureUrl(user.getProfilePictureUrl())
                .build();
    }

    public static UserResponseBuilder builder() {
        return new UserResponseBuilder();
    }
}
