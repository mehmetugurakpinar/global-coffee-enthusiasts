package com.globalcoffeeenthusiasts.adapters.user.sor;

import com.globalcoffeeenthusiasts.adapters.user.sor.entity.UserEntity;
import com.globalcoffeeenthusiasts.adapters.user.sor.repository.UserRepository;
import com.globalcoffeeenthusiasts.common.model.Page;
import com.globalcoffeeenthusiasts.user.model.User;
import com.globalcoffeeenthusiasts.user.port.UserPort;
import com.globalcoffeeenthusiasts.user.usecase.UserPaginate;
import com.globalcoffeeenthusiasts.user.usecase.create.UserCreate;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

@Service
public class UserDataAdapter implements UserPort {
    private final UserRepository userRepository;

    public UserDataAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserCreate surveyCreate) {
        UserEntity userEntity = UserEntity.of(
                surveyCreate.getUsername(),
                surveyCreate.getEmail(),
                surveyCreate.getPassword());
        return (userRepository.save(userEntity)).toModel();
    }

    public User retrieve(String id) {
        return (userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User not found")))
                .toModel();
    }

    public Page<User> paginate(UserPaginate userPaginate) {
        throw new NotImplementedException("Not implemented yet");
    }

    public void delete(String id) {
        throw new NotImplementedException("Not implemented yet");
    }
}