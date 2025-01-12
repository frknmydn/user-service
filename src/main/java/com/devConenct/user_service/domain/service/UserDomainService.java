package com.devConenct.user_service.domain.service;

import com.devConenct.user_service.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserDomainService {
    private final UserRepository userRepository;

    public UserDomainService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isEmailTaken(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
