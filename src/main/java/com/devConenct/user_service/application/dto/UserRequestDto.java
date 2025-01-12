package com.devConenct.user_service.application.dto;

import com.devConenct.user_service.domain.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDto(
        @NotBlank String username,
        @Email @NotBlank String email,
        @NotBlank String password,
        Role role,
        String phone,
        String firstName,
        String lastName,
        String profilePictureUrl,
        String bio,
        String city,
        String company
) {}
