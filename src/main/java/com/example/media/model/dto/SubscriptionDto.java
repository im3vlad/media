package com.example.media.model.dto;

import lombok.Data;


import java.util.UUID;

@Data
public class SubscriptionDto {
    private UUID subId;
    private String serviceName;

}
