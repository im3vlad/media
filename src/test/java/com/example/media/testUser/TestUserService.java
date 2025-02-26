package com.example.media.testUser;

import com.example.media.mapper.UserMapper;
import com.example.media.model.dto.UserDto;
import com.example.media.model.entity.UserEntity;
import com.example.media.repository.UserRepository;
import com.example.media.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.UUID;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void createOrderTest() {
        UserDto userDto = new UserDto();
        userDto.setUserId(UUID.randomUUID());
        userDto.setUserName("Андрей");
        UserMapper userMapper = new UserMapper();
        UserEntity userEntity = userMapper.mapFromUserDto(userDto);
        userRepository.save(userEntity);

    }

    @Test
    void userUpdateTest2(){
        UserDto userDto = new UserDto();
        userDto.setUserId(UUID.randomUUID());
        userRepository.findById(userDto.getUserId());
        UserMapper userMapper = new UserMapper();
        UserEntity userEntity = userMapper.mapFromUserDto(userDto);
        userRepository.save(userEntity);
        userMapper.mapFromUserEntity(userEntity);
    }
}