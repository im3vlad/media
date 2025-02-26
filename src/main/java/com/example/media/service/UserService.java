package com.example.media.service;

import com.example.media.model.dto.UserDto;
import com.example.media.model.entity.UserEntity;


import java.util.List;
import java.util.UUID;

public interface UserService {
    void createUser (UserDto userDto);
    void deleteUser (UUID userId);
    UserDto updateUser(UUID id, UserDto userDto);
    UserDto getUser(UUID userId);
    List<UserEntity> getAllUSer();
}
