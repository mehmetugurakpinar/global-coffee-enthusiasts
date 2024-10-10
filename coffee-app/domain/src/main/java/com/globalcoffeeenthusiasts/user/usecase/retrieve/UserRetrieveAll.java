package com.globalcoffeeenthusiasts.user.usecase.retrieve;

import com.globalcoffeeenthusiasts.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRetrieveAll implements UseCase {

	private UserRetrieveAll() {
	}

	public static UserRetrieveAll from() {
		return new UserRetrieveAll();
	}
}