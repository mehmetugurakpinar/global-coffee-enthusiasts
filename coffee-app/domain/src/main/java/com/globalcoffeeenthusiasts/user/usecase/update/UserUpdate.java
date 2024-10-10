package com.globalcoffeeenthusiasts.user.usecase.update;

import com.globalcoffeeenthusiasts.common.model.UseCase;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder(builderMethodName = "userUpdate", builderClassName = "Builder")
public class UserUpdate  implements UseCase {
	private String id;
	private String username;
	private String email;
	private String password;
	private String profilePictureUrl;

	private UserUpdate(Builder builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.email = builder.email;
		this.password = builder.password;
		this.profilePictureUrl = builder.profilePictureUrl;
	}

	public static Builder userUpdate() {
		return new Builder();
	}

	public static final class Builder {

		private Builder() {
		}

		public UserUpdate build() {
			return new UserUpdate(this);
		}
	}
}
