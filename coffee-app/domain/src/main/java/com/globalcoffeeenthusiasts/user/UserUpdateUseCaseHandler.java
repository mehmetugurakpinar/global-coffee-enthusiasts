package com.globalcoffeeenthusiasts.user;

import com.globalcoffeeenthusiasts.common.DomainComponent;
import com.globalcoffeeenthusiasts.common.usecase.ObservableUseCasePublisher;
import com.globalcoffeeenthusiasts.common.usecase.UseCaseHandler;
import com.globalcoffeeenthusiasts.user.model.User;
import com.globalcoffeeenthusiasts.user.port.UserPort;
import com.globalcoffeeenthusiasts.user.usecase.update.UserUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DomainComponent
public class UserUpdateUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<User, UserUpdate> {
	private static final Logger log = LoggerFactory.getLogger(UserUpdateUseCaseHandler.class);
	private final UserPort userPort;

	public UserUpdateUseCaseHandler(UserPort userPort) {
		this.userPort = userPort;
		this.register(UserUpdate.class, this);
	}

	public User handle(UserUpdate userUpdate) {
		log.info("Handling UserUpdate use case for user ID: {}", userUpdate.getId());
		User existingUser = this.userPort.retrieve(userUpdate.getId());

		if (existingUser == null) {
			log.error("User with ID {} not found.", userUpdate.getId());
			throw new IllegalArgumentException("User not found");
		}

		existingUser.updateUser(
				userUpdate.getUsername(),
				userUpdate.getEmail(),
				userUpdate.getPassword(),
				userUpdate.getProfilePictureUrl()
		);

		this.userPort.update(userUpdate);

		return existingUser;
	}
}
