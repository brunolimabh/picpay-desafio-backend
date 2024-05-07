package com.example.picpaydesafiobackend.dto.user;

import com.example.picpaydesafiobackend.domain.user.User;

import java.util.List;

public class UserMapper {

    public static User toEntity(UserRequestDto dto) {
        if (dto == null) return null;

        User entity = new User();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setDocument(dto.getDocument());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setUserType(dto.getUserType());
        return entity;
    }

    public static UserResponseDto toDto(User entity) {
        if (entity == null) return null;

        UserResponseDto dto = new UserResponseDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setDocument(entity.getDocument());
        dto.setEmail(entity.getEmail());
        dto.setBalance(entity.getBalance());
        dto.setUserType(entity.getUserType());
        return dto;
    }

    public static List<UserResponseDto> toDto (List<User> entities) {
        return entities.stream()
                .map(UserMapper::toDto)
                .toList();
    }
}
