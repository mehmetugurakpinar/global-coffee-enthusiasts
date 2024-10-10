package com.globalcoffeeenthusiasts.user.usecase.delete;

import com.globalcoffeeenthusiasts.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDelete  implements UseCase {
    private String id;

    public static UserDelete from(String id) {
        return UserDelete.builder()
                .id(id)
                .build();
    }
}
