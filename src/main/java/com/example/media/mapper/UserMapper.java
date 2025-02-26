package com.example.media.mapper;

import com.example.media.model.dto.UserDto;
import com.example.media.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
@Data
public class UserMapper {
    public UserEntity mapFromUserDto(UserDto userDto){
    UserEntity userEntity = new UserEntity();
    userEntity.setUserid(userDto.getUserId());
    userEntity.setName(userDto.getUserName());
        return userEntity;
    }

    public UserDto mapFromUserEntity(UserEntity userEntity){
        UserDto userDto = new UserDto();
        userDto.setUserId(userEntity.getUserid());
        userDto.setUserName(userEntity.getName());
        return userDto;
    }
}
