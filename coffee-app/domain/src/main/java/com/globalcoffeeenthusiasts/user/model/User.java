package com.globalcoffeeenthusiasts.user.model;

import com.globalcoffeeenthusiasts.user.usecase.create.UserCreate;
import com.globalcoffeeenthusiasts.user.usecase.update.UserUpdate;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
@Builder(builderMethodName = "userField", builderClassName = "Builder")
public class User {

    private String id;
    private String username;
    private String email;
    private String password;
    private String profilePictureUrl;
    private LocalDateTime createdAt;

    private User(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
        this.profilePictureUrl = builder.profilePictureUrl;
    }

    public static Builder user() {
        return new Builder();
    }

    public static final class Builder {

        private Builder() {
        }

        public User build() {
            return new User(this);
        }
    }

    public void createUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserCreate toUseCase() {
        return UserCreate.userCreate()
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .build();
    }

    public void updateUser(String username, String email, String password, String profilePictureUrl) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePictureUrl = profilePictureUrl;
    }
}
