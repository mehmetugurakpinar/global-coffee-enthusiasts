package com.globalcoffeeenthusiasts.adapters.user.rest;

import com.globalcoffeeenthusiasts.adapters.user.rest.dto.UserCreateRequest;
import com.globalcoffeeenthusiasts.adapters.user.rest.dto.UserResponse;
import com.globalcoffeeenthusiasts.common.rest.BaseController;
import com.globalcoffeeenthusiasts.common.rest.Response;
import com.globalcoffeeenthusiasts.user.model.User;
import com.globalcoffeeenthusiasts.user.usecase.retrieve.UserRetrieve;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/coffee-social-platform/users"})
@CrossOrigin
@Slf4j
public class UserController extends BaseController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Response<UserResponse> createSurvey(@RequestBody UserCreateRequest userCreateRequest) {
        User user = publish(User.class, userCreateRequest.toUseCase());
        return respond(UserResponse.from(user));
    }

    @GetMapping({"/{id}"})
    public Response<UserResponse> retrieve(@PathVariable("id") String id) {
        User user = publish(User.class, UserRetrieve.from(id));
        return respond(UserResponse.from(user));
    }
}
