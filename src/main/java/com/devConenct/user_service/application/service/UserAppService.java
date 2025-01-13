package com.devConenct.user_service.application.service;

import com.devConenct.user_service.application.dto.LoginRequestDto;
import com.devConenct.user_service.application.dto.LoginResponseDto;
import com.devConenct.user_service.application.dto.UserRequestDto;
import com.devConenct.user_service.application.dto.UserResponseDto;
import com.devConenct.user_service.application.mapper.UserMapper;
import com.devConenct.user_service.domain.exception.EmailAlreadyTakenException;
import com.devConenct.user_service.domain.model.User;
import com.devConenct.user_service.domain.repository.UserRepository;
import com.devConenct.user_service.domain.service.UserDomainService;
import com.devConenct.user_service.infrastructure.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAppService {
    private final UserRepository userRepository;
    private final UserDomainService userDomainService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserAppService(UserRepository userRepository, UserDomainService userDomainService, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.userDomainService = userDomainService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public UserResponseDto registerUser(UserRequestDto userRequestDto) {

        if (!userRequestDto.password().equals(userRequestDto.passwordConfirm())) {
            throw new IllegalArgumentException("Passwords do not match.");
        }

        if(userDomainService.isEmailTaken(userRequestDto.email())){
            throw new EmailAlreadyTakenException(userRequestDto.email());
        }

        User user = UserMapper.toEntity(userRequestDto);
        String hashedPassword = passwordEncoder.encode(userRequestDto.password());
        user.setPassword(hashedPassword);
        User savedUser = userRepository.save(user);
        return UserMapper.toResponseDto(savedUser);
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user = userDomainService.validateCredentials(
                loginRequestDto.email(),
                loginRequestDto.password()
        );

        String token = jwtTokenProvider.createToken(user.getUsername(), String.valueOf(user.getRole()));

        return new LoginResponseDto(token, "Login successful.");
    }

}
