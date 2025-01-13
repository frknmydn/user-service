package com.devConenct.user_service.interfaces.controller;

import com.devConenct.user_service.application.dto.LoginRequestDto;
import com.devConenct.user_service.application.dto.LoginResponseDto;
import com.devConenct.user_service.application.dto.UserRequestDto;
import com.devConenct.user_service.application.dto.UserResponseDto;
import com.devConenct.user_service.application.service.UserAppService;
import com.devConenct.user_service.domain.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserAppService userAppService;

    @Autowired
    public UserController(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        UserResponseDto response = userAppService.registerUser(userRequestDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto loginRequestDto) {
        LoginResponseDto response = userAppService.login(loginRequestDto);
        return ResponseEntity.ok(response);
    }
}
