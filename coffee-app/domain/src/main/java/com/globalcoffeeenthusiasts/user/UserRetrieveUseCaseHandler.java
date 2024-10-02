package com.globalcoffeeenthusiasts.user;

import com.globalcoffeeenthusiasts.common.DomainComponent;
import com.globalcoffeeenthusiasts.common.usecase.ObservableUseCasePublisher;
import com.globalcoffeeenthusiasts.common.usecase.UseCaseHandler;
import com.globalcoffeeenthusiasts.user.model.User;
import com.globalcoffeeenthusiasts.user.port.UserPort;
import com.globalcoffeeenthusiasts.user.usecase.retrieve.UserRetrieve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DomainComponent
public class UserRetrieveUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<User, UserRetrieve> {
    private static final Logger log = LoggerFactory.getLogger(UserRetrieveUseCaseHandler.class);
    private final UserPort userPort;

    public UserRetrieveUseCaseHandler(UserPort userPort) {
        this.userPort = userPort;
        this.register(UserRetrieve.class, this);
    }

    public User handle(UserRetrieve userRetrieve) {
        return this.userPort.retrieve(userRetrieve.getId());
    }
}
