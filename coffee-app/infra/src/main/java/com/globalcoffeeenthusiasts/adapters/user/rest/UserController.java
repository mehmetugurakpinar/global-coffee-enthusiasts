package com.globalcoffeeenthusiasts.adapters.user.rest;

import com.globalcoffeeenthusiasts.adapters.user.rest.dto.UserCreateRequest;
import com.globalcoffeeenthusiasts.adapters.user.rest.dto.UserResponse;
import com.globalcoffeeenthusiasts.adapters.user.rest.dto.UserUpdateRequest;
import com.globalcoffeeenthusiasts.common.rest.BaseController;
import com.globalcoffeeenthusiasts.common.rest.DataResponse;
import com.globalcoffeeenthusiasts.common.rest.Response;
import com.globalcoffeeenthusiasts.user.model.User;
import com.globalcoffeeenthusiasts.user.usecase.retrieve.UserRetrieve;
import com.globalcoffeeenthusiasts.user.usecase.delete.UserDelete;
import com.globalcoffeeenthusiasts.user.usecase.retrieve.UserRetrieveAll;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public Response<DataResponse<UserResponse>> getAll() {
        List<User> users = publish(List.class, UserRetrieveAll.from());
        List<UserResponse> collect = users.stream()
                .map(UserResponse::from)
                .toList();
        return respond(collect);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        publish(UserDelete.from(id));
    }

    @PutMapping("/{id}")
    public Response<String> update(@PathVariable("id") String id, @RequestBody UserUpdateRequest userUpdateRequest) {
        publish(User.class, userUpdateRequest.toUseCase(id));
        return Response.ok("User updated successfully");
    }
}
