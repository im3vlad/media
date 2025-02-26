package com.example.media.service;

import com.example.media.mapper.UserMapper;
import com.example.media.model.dto.UserDto;
import com.example.media.model.entity.UserEntity;
import com.example.media.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;



    public UserDto getUser(UUID id) {
       UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Пользователя не существует"));
        return userMapper.mapFromUserEntity(userEntity);
    }

    @Override
    public List<UserEntity> getAllUSer() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void createUser(UserDto userDto) {
        UserEntity userEntity = userMapper.mapFromUserDto(userDto);
        userRepository.save(userEntity);

    }
    @Override
    @Transactional
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDto updateUser(UUID id, UserDto userDto) {
        userRepository.findById(id);
        UserEntity userEntity = userMapper.mapFromUserDto(userDto);
        userRepository.save(userEntity);
        return userMapper.mapFromUserEntity(userEntity);
    }

}
