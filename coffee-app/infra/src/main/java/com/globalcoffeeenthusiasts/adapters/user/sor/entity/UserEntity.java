package com.globalcoffeeenthusiasts.adapters.user.sor.entity;

import com.globalcoffeeenthusiasts.common.entity.AbstractEntity;
import com.globalcoffeeenthusiasts.user.model.User;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(
        name = "users"
)
public class UserEntity extends AbstractEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private String id;
    @Column(
            nullable = false,
            unique = true
    )
    private String username;
    @Column(
            nullable = false
    )
    private String email;
    @Column(
            nullable = false
    )
    private String password;
    private String profilePictureUrl;

    public UserEntity() {
    }

    private UserEntity(String id, String username, String email, String password, String profilePictureUrl) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profilePictureUrl = profilePictureUrl;
    }

    public User toModel() {
        return User.user()
                .id(id)
                .username(this.username)
                .email(this.email)
                .password(this.password)
                .build();
    }

    public static UserEntity of(String username, String email, String password) {
        return new UserEntity(String.valueOf(UUID.randomUUID()), username, email, password, "");
    }
}
