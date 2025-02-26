package com.e6.media.model.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class UserDto {
    private UUID userId = UUID.randomUUID();
    private String userName;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
