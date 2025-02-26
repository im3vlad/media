package com.e6.media.mapper;

import com.e6.media.model.dto.UserDto;
import com.e6.media.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
@Data
public class UserMapper {
    public UserEntity MapFromUserDto(UserDto userDto){
    UserEntity userEntity = new UserEntity(userDto.getUserId(), userDto.getUserName());
    userEntity.setUserid(UUID.randomUUID());
    userEntity.setName(userEntity.getName());
        return userEntity;
    }

    public UserDto MapFromUserEntity(UserEntity userEntity){
        UserDto userDto = new UserDto();
        userDto.setUserId(UUID.randomUUID());
        userDto.setUserName(userEntity.getName());
        return userDto;
    }
}
