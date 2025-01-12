package com.devConenct.user_service.domain.repository;

import com.devConenct.user_service.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    User save(User user);

}
