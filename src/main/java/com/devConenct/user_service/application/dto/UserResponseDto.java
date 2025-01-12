package com.devConenct.user_service.application.dto;

import com.devConenct.user_service.domain.model.Role;

public record UserResponseDto(
        String username,
        String email,
        Role role,
        boolean enabled
) {}