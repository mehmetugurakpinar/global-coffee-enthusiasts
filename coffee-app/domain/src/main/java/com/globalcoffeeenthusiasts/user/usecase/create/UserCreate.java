package com.globalcoffeeenthusiasts.user.usecase.create;

import com.globalcoffeeenthusiasts.common.model.UseCase;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@Getter
@EqualsAndHashCode
@Builder(builderMethodName = "userCreate", builderClassName = "Builder")
public class UserCreate  implements UseCase {
    private String id = String.valueOf(UUID.randomUUID());
    private String username;
    private String email;
    private String password;
    private String profilePictureUrl;

    private UserCreate(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
        this.profilePictureUrl = builder.profilePictureUrl;
    }

    public static Builder userCreate() {
        return new Builder();
    }

    public static final class Builder {

        private Builder() {
        }

        public UserCreate build() {
            return new UserCreate(this);
        }
    }
}
