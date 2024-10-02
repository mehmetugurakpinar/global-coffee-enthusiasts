package com.globalcoffeeenthusiasts.user.usecase;

import com.globalcoffeeenthusiasts.common.model.Page;
import com.globalcoffeeenthusiasts.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserPaginate implements UseCase {

    private Page page;
}
