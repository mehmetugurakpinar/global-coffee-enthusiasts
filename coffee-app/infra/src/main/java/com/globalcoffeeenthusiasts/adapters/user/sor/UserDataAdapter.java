package com.globalcoffeeenthusiasts.adapters.user.sor;

import com.globalcoffeeenthusiasts.adapters.user.sor.entity.UserEntity;
import com.globalcoffeeenthusiasts.adapters.user.sor.repository.UserRepository;
import com.globalcoffeeenthusiasts.common.model.Page;
import com.globalcoffeeenthusiasts.user.model.User;
import com.globalcoffeeenthusiasts.user.port.UserPort;
import com.globalcoffeeenthusiasts.user.usecase.UserPaginate;
import com.globalcoffeeenthusiasts.user.usecase.create.UserCreate;
import com.globalcoffeeenthusiasts.user.usecase.update.UserUpdate;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
        userRepository.deleteById(id);
    }

    public void update(UserUpdate userUpdate) {
        UserEntity userEntity = userRepository.findById(userUpdate.getId())
                .orElseThrow(() -> new IllegalStateException("User not found"));
        UserEntity.of(
                userUpdate.getId(),
                userUpdate.getUsername(),
                userUpdate.getEmail(),
                userUpdate.getPassword(),
                userUpdate.getProfilePictureUrl());
        userRepository.save(userEntity);
    }

    public List<User> retrieveAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(UserEntity::toModel)
                .collect(Collectors.toList());
    }
}