package com.devConenct.user_service.application.dto;

import com.devConenct.user_service.domain.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDto(
        @NotBlank(message = "Username cannot be empty.") String username,
        @Email @NotBlank(message = "Email cannot be empty.") String email,
        @NotBlank(message = "password cannot be empty.") String password,
        @NotBlank(message = "password confirmation cannot be empty.") String passwordConfirm,
        Role role,
        String phone,
        String firstName,
        String lastName,
        String profilePictureUrl,
        String bio,
        String city,
        String company
) {}
