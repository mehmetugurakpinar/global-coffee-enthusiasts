package com.globalcoffeeenthusiasts.user.usecase.delete;

import com.globalcoffeeenthusiasts.common.model.UseCase;
import com.globalcoffeeenthusiasts.user.model.User;
import com.globalcoffeeenthusiasts.user.usecase.create.UserCreate;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder(builderMethodName = "userDelete", builderClassName = "Builder")
public class UserDelete  implements UseCase {
    private String id;

    private UserDelete(UserDelete.Builder builder) {
        this.id = builder.id;
    }

    public static UserDelete.Builder userDelete() {
        return new UserDelete.Builder();
    }

    public User toUser() {
        return User.user()
                .id(this.id)
                .build();
    }

    public static final class Builder {

        private Builder() {
        }

        public UserDelete build() {
            return new UserDelete(this);
        }
    }
}
