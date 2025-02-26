package com.example.media.mapper;

import com.example.media.model.dto.SubscriptionDto;
import com.example.media.model.entity.SubscriptionEntity;

public class SubscriptionMapper {
    public SubscriptionEntity mapFromSubscriptionDto(SubscriptionDto subscriptionDto){
        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setId(subscriptionDto.getSubId());
        subscriptionEntity.setServiceName(subscriptionDto.getServiceName());
        return subscriptionEntity;
    }

    public SubscriptionDto mapFromSubscriptionEntity(SubscriptionEntity subscriptionEntity){
        SubscriptionDto subscriptionDto = new SubscriptionDto();
        subscriptionDto.setSubId(subscriptionEntity.getUser().getUserid());
        subscriptionDto.setServiceName(subscriptionEntity.getServiceName());
        return subscriptionDto;
    }
}
