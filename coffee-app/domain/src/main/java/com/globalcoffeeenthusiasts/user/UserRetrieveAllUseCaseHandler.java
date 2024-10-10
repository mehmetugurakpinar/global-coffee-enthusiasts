package com.globalcoffeeenthusiasts.user;

import com.globalcoffeeenthusiasts.common.DomainComponent;
import com.globalcoffeeenthusiasts.common.usecase.ObservableUseCasePublisher;
import com.globalcoffeeenthusiasts.common.usecase.UseCaseHandler;
import com.globalcoffeeenthusiasts.user.model.User;
import com.globalcoffeeenthusiasts.user.port.UserPort;
import com.globalcoffeeenthusiasts.user.usecase.retrieve.UserRetrieveAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DomainComponent
public class UserRetrieveAllUseCaseHandler extends ObservableUseCasePublisher implements UseCaseHandler<List<User>, UserRetrieveAll> {
    private static final Logger log = LoggerFactory.getLogger(UserRetrieveAllUseCaseHandler.class);
    private final UserPort userPort;

    public UserRetrieveAllUseCaseHandler(UserPort userPort) {
        this.userPort = userPort;
        this.register(UserRetrieveAll.class, this);
    }

    @Override
    public List<User> handle(UserRetrieveAll userRetrieveAll) {
        log.info("Handling UserRetrieveAll use case.");
        return this.userPort.retrieveAll(); // Tüm kullanıcıları getiren metot
    }
}
