package com.e6.media.service;

import com.e6.media.model.dto.UserDto;
import com.e6.media.model.entity.UserEntity;


import java.util.List;
import java.util.UUID;

public interface UserService {
    void createUser (UserDto userDto);
    void deleteUser (UUID userId);
    UserDto updateUser(UserDto userDto);
    UserEntity getUser(UUID userId);
    List<UserEntity> getAllUSer();
}
