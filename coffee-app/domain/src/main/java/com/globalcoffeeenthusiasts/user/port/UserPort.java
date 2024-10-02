package com.globalcoffeeenthusiasts.user.port;

import com.globalcoffeeenthusiasts.common.model.Page;
import com.globalcoffeeenthusiasts.user.model.User;
import com.globalcoffeeenthusiasts.user.usecase.UserPaginate;
import com.globalcoffeeenthusiasts.user.usecase.create.UserCreate;

public interface UserPort {
    User create(UserCreate userCreate);

    User retrieve(String id);

    Page<User> paginate(UserPaginate userPaginate);

    void delete(String id);
}