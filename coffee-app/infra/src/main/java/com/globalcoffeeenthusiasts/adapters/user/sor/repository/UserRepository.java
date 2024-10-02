package com.globalcoffeeenthusiasts.adapters.user.sor.repository;

import com.globalcoffeeenthusiasts.adapters.user.sor.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
}
