package com.devConenct.user_service.application.dto;

public record LoginResponseDto(
        String token,
        String message
) {}