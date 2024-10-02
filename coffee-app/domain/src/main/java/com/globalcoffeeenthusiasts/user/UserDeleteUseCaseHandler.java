package com.globalcoffeeenthusiasts.user;

import com.globalcoffeeenthusiasts.common.DomainComponent;
import com.globalcoffeeenthusiasts.common.usecase.ObservableUseCasePublisher;
import com.globalcoffeeenthusiasts.common.usecase.VoidUseCaseHandler;
import com.globalcoffeeenthusiasts.user.port.UserPort;
import com.globalcoffeeenthusiasts.user.usecase.delete.UserDelete;

@DomainComponent
public class UserDeleteUseCaseHandler extends ObservableUseCasePublisher implements VoidUseCaseHandler<UserDelete> {
    private final UserPort userPort;

    public UserDeleteUseCaseHandler(UserPort userPort) {
        this.userPort = userPort;
        this.register(UserDelete.class, this);
    }

    public void handle(UserDelete useCase) {
        this.userPort.delete(useCase.getId());
    }
}
