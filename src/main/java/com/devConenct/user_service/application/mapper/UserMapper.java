package com.devConenct.user_service.application.mapper;

import com.devConenct.user_service.application.dto.UserRequestDto;
import com.devConenct.user_service.application.dto.UserResponseDto;
import com.devConenct.user_service.domain.model.User;

public class UserMapper {

    public static User toEntity(UserRequestDto dto){
        return new User(dto.username(), dto.email(), dto.password(), dto.role(), dto.phone(), dto.firstName(), dto.lastName(), dto.profilePictureUrl(), dto.bio(), dto.city(), dto.company());
    }

    public static UserResponseDto toResponseDto(User user){
        return new UserResponseDto(
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                user.isEnabled()
        );
    }
}
