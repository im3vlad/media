package com.e6.media.controller;


import com.e6.media.model.dto.UserDto;
import com.e6.media.model.entity.UserEntity;
import com.e6.media.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
       (this.userService) = userService;
    }

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
       userService.createUser(userDto);

    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable UUID id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable UUID id, @RequestBody UserDto userDto) {
         userService.updateUser(userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
       userService.deleteUser(id);
    }
}