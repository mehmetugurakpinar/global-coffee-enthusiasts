package com.globalcoffeeenthusiasts.adapters.user.rest.dto;

import com.globalcoffeeenthusiasts.user.usecase.update.UserUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {
	private String username;
	private String email;
	private String password;
	private String profilePictureUrl;

	public UserUpdate toUseCase(String id) {
		UserUpdate.Builder builder = UserUpdate.userUpdate()
				.id(id)
				.username(this.username)
				.email(this.email)
				.password(this.password)
				.profilePictureUrl(this.profilePictureUrl);

		return builder.build();
	}
}
