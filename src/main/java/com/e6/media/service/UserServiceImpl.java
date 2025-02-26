package com.e6.media.service;

import com.e6.media.mapper.UserMapper;
import com.e6.media.model.dto.UserDto;
import com.e6.media.model.entity.UserEntity;
import com.e6.media.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserEntity getUser(UUID id) {
        return (UserEntity) userRepository.findById(id).orElseThrow(() -> new RuntimeException("Пользователя не существует"));
    }

    @Override
    public List<UserEntity> getAllUSer() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public void createUser(UserDto userDto) {
        UserMapper userMapper = new UserMapper();
        UserEntity userEntity = userMapper.MapFromUserDto(userDto);
        userRepository.save(userEntity);

    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        userRepository.findById(userDto.getUserId());
        UserMapper userMapper = new UserMapper();
        UserEntity userEntity = userMapper.MapFromUserDto(userDto);
        userRepository.save(userEntity);
        return userMapper.MapFromUserEntity(userEntity);
    }

}
