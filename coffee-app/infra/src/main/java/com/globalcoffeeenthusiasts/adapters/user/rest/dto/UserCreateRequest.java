package com.globalcoffeeenthusiasts.adapters.user.rest.dto;

import com.globalcoffeeenthusiasts.user.usecase.create.UserCreate;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String profilePictureUrl;

    public UserCreate toUseCase() {
        UserCreate.Builder builder = UserCreate.userCreate()
                .username(this.username)
                .email(this.email)
                .password(this.password);

        return builder.build();
    }
}
