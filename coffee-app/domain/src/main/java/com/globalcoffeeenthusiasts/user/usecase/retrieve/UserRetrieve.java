package com.globalcoffeeenthusiasts.user.usecase.retrieve;

import com.globalcoffeeenthusiasts.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRetrieve  implements UseCase {
    private String id;

    public static UserRetrieve from(String id) {
        return UserRetrieve.builder()
                .id(id)
                .build();
    }
}
