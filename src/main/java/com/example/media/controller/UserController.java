package com.example.media.controller;

import com.example.media.model.dto.UserDto;
import com.example.media.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        log.info("создать пользователя");
       userService.createUser(userDto);

    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable UUID id) {
        log.info("получить информацию о пользователе");
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable UUID id, @RequestBody UserDto userDto) {
        log.info("обновить пользователя");
         userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        log.info("удалить пользователя");
       userService.deleteUser(id);
    }
}