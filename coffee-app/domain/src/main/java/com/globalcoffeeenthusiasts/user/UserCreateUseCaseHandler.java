package com.globalcoffeeenthusiasts.user;

import com.globalcoffeeenthusiasts.common.DomainComponent;
import com.globalcoffeeenthusiasts.common.usecase.ObservableUseCasePublisher;
import com.globalcoffeeenthusiasts.common.usecase.UseCaseHandler;
import com.globalcoffeeenthusiasts.user.model.User;
import com.globalcoffeeenthusiasts.user.port.UserPort;
import com.globalcoffeeenthusiasts.user.usecase.create.UserCreate;

@DomainComponent
public class UserCreateUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<User, UserCreate> {
    private final UserPort userPort;

    public UserCreateUseCaseHandler(UserPort userPort) {
        this.userPort = userPort;
        this.register(UserCreate.class, this);
    }

    public User handle(UserCreate useCase) {
        return this.userPort.create(useCase);
    }
}
