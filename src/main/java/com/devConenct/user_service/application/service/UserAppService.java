package com.devConenct.user_service.application.service;

import com.devConenct.user_service.application.dto.UserRequestDto;
import com.devConenct.user_service.application.dto.UserResponseDto;
import com.devConenct.user_service.application.mapper.UserMapper;
import com.devConenct.user_service.domain.model.User;
import com.devConenct.user_service.domain.repository.UserRepository;
import com.devConenct.user_service.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAppService {
    private final UserRepository userRepository;
    private final UserDomainService userDomainService;

    @Autowired
    public UserAppService(UserRepository userRepository, UserDomainService userDomainService) {
        this.userRepository = userRepository;
        this.userDomainService = userDomainService;
    }

    public UserResponseDto registerUser(UserRequestDto userRequestDto) {

        if(userDomainService.isEmailTaken(userRequestDto.email())){
            throw new IllegalArgumentException("Email is taken");
        }

        User user = UserMapper.toEntity(userRequestDto);
        User savedUser = userRepository.save(user);
        return UserMapper.toResponseDto(savedUser);
    }
}
