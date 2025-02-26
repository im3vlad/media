package com.example.media.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID userId = UUID.randomUUID();
    private String userName;

}
